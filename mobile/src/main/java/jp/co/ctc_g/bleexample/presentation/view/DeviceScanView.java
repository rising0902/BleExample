package jp.co.ctc_g.bleexample.presentation.view;

import android.content.Context;

public interface DeviceScanView {

    void initScanStartButton();
    void initScanStopButton();
    void scanStartSuccessed();
    void scanStopSuccessed();
    void showError();
    Context getContext();
}
