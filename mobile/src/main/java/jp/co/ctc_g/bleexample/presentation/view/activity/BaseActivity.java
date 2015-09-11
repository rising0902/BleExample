package jp.co.ctc_g.bleexample.presentation.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import jp.co.ctc_g.bleexample.AndroidApplication;
import jp.co.ctc_g.bleexample.presentation.internal.di.components.ApplicationComponent;
import jp.co.ctc_g.bleexample.presentation.internal.di.modules.ActivityModule;
import jp.co.ctc_g.bleexample.presentation.navigator.ActivityNavigator;

public class BaseActivity extends FragmentActivity {

    @Inject
    ActivityNavigator activityNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(containerViewId, fragment);
        ft.commit();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication)getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
