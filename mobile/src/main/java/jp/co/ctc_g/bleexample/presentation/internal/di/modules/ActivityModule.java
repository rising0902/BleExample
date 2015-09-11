package jp.co.ctc_g.bleexample.presentation.internal.di.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

import jp.co.ctc_g.bleexample.presentation.internal.di.PreActivity;

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PreActivity
    Activity activity() {
        return this.activity;
    }
}
