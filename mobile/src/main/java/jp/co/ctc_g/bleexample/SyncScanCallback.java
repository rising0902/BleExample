package jp.co.ctc_g.bleexample;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.Log;

import java.util.List;
import java.util.UUID;

import de.greenrobot.event.EventBus;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class SyncScanCallback extends ScanCallback {

    private static final String LOG_TAG = "VERIFICATION";

    private boolean bluetoothEnable = false;
    private Context context;

    public SyncScanCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onScanResult(int callbackType, ScanResult result) {
        super.onScanResult(callbackType, result);
        BluetoothDevice device = result.getDevice();
        device.connectGatt(context, false, callback);
        if (device.getUuids() != null && device.getUuids().length >= 0)
          for (ParcelUuid uuid : device.getUuids()) {
              Log.i(LOG_TAG, device.getName() + " - " + uuid.getUuid().toString());
          }
        EventBus.getDefault().post(new ScanSuccessed());
    }

    @Override
    public void onBatchScanResults(List<ScanResult> results) {
        super.onBatchScanResults(results);
        for (ScanResult result: results) {
            BluetoothDevice device = result.getDevice();
            device.connectGatt(context, false, callback);
            for (ParcelUuid uuid : device.getUuids()) {
                Log.i(LOG_TAG, device.getName() + " - " + uuid.getUuid().toString());
            }
        }
    }

    @Override
    public void onScanFailed(int errorCode) {
        super.onScanFailed(errorCode);

        Log.e(LOG_TAG, "Scan fail!");
    }

    private final BluetoothGattCallback callback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                 bluetoothEnable = false;
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                Log.i(LOG_TAG, gatt.getDevice().getName());
                for (BluetoothGattService service : gatt.getServices()) {
                    Log.i(LOG_TAG, service.getUuid().toString());
                    for (BluetoothGattService s : service.getIncludedServices()) {
                        Log.i(LOG_TAG, s.getUuid().toString());
                    }
                }
                BluetoothGattService service = gatt.getService(UUID.fromString("0000180b-0000-1000-8000-00805f9b34fb"));
                if (service != null) {
                    BluetoothGattCharacteristic mBleCharacteristic = service.getCharacteristic(UUID.fromString("00002a29-0000-1000-8000-00805f9b34fb"));
                    if (mBleCharacteristic != null) {
                        Log.i(LOG_TAG, "Hit!!!!!");
                        bluetoothEnable = true;
                    }
                }
            }
        }
    };
}

