package jp.co.ctc_g.bleexample.presentation.internal.di.components;

import android.app.Activity;
import android.app.Application;

import dagger.Component;
import jp.co.ctc_g.bleexample.presentation.internal.di.PreActivity;
import jp.co.ctc_g.bleexample.presentation.internal.di.modules.ActivityModule;
import jp.co.ctc_g.bleexample.presentation.view.fragment.DeviceScanFragment;

@PreActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface DeviceScanComponent extends ActivityComponent {
    void inject(DeviceScanFragment deviceScanFragment);
}
