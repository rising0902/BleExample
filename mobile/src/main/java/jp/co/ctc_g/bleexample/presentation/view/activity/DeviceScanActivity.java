package jp.co.ctc_g.bleexample.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import jp.co.ctc_g.bleexample.R;
import jp.co.ctc_g.bleexample.presentation.internal.di.HasComponent;
import jp.co.ctc_g.bleexample.presentation.internal.di.components.DeviceScanComponent;
import jp.co.ctc_g.bleexample.presentation.internal.di.components.DaggerDeviceScanComponent;
import jp.co.ctc_g.bleexample.presentation.view.fragment.DeviceScanFragment;

public class DeviceScanActivity extends BaseActivity
        implements HasComponent<DeviceScanComponent> {

    private DeviceScanComponent deviceScanComponent;

    public static void start(Context context) {
        Intent intent = new Intent(context, DeviceScanActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_scan);

        initInjector();
        addFragment(R.id.container_device_scan, new DeviceScanFragment());
    }

    private void initInjector() {
        this.deviceScanComponent = DaggerDeviceScanComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public DeviceScanComponent getComponent() {
        return this.deviceScanComponent;
    }
}
