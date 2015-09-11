package jp.co.ctc_g.bleexample.presentation.internal.di.components;

import android.app.Activity;
import android.app.Application;

import dagger.Component;
import jp.co.ctc_g.bleexample.presentation.internal.di.PreActivity;
import jp.co.ctc_g.bleexample.presentation.internal.di.modules.ActivityModule;

@PreActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
