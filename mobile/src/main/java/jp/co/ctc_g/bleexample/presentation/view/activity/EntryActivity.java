package jp.co.ctc_g.bleexample.presentation.view.activity;

import android.os.Bundle;

import jp.co.ctc_g.bleexample.R;

public class EntryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        DeviceScanActivity.start(this);
    }
}
