package jp.co.ctc_g.bleexample.presentation.view.fragment;

import android.content.Context;
import android.util.Log;

import jp.co.ctc_g.bleexample.presentation.view.DeviceScanView;

public class DeviceScanFragment extends BaseFragment implements DeviceScanView {

    private static final String LOG_TAG = DeviceScanFragment.class.getSimpleName();

    public DeviceScanFragment() {
        super();
    }

    @Override
    public void initScanStartButton() {

    }

    @Override
    public void initScanStopButton() {

    }

    @Override
    public void scanStartSuccessed() {

    }

    @Override
    public void scanStopSuccessed() {

    }

    @Override
    public void showError() {
        Log.e(LOG_TAG, "");
    }

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }
}
