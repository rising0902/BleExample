package jp.co.ctc_g.bleexample;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ScannerController {

    private static final String LOG_TAG = "VERIFICATION";

    private Context context;
    private BluetoothManager bluetoothManager;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;
    private SyncScanCallback syncScanCallback;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ScannerController(Context context) {
        this.context = context;
        bluetoothManager = (BluetoothManager)context.getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();
        bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
        syncScanCallback = new SyncScanCallback(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void startScanning() {
        bluetoothLeScanner.startScan(syncScanCallback);
        //List<ScanFilter> scanFilters = new ArrayList<ScanFilter>();
        //ScanFilter uuidFilter = new ScanFilter.Builder().setServiceUuid(new ParcelUuid(UUID.fromString("00002a29-0000-1000-8000-00805f9b34fb"))).build();
        //scanFilters.add(uuidFilter);
        //ScanSettings.Builder mScanSettingBuiler = new ScanSettings.Builder();
        //mScanSettingBuiler.setScanMode(android.bluetooth.le.ScanSettings.SCAN_MODE_LOW_POWER);
        //ScanSettings mScanSettings = mScanSettingBuiler.build();
        //bluetoothLeScanner.startScan(scanFilters, mScanSettings, syncScanCallback);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void stopScanning() {
        bluetoothLeScanner.stopScan(syncScanCallback);
    }
}
