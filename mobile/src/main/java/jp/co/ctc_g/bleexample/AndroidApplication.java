package jp.co.ctc_g.bleexample;

import android.app.Application;

import jp.co.ctc_g.bleexample.presentation.internal.di.components.ApplicationComponent;
import jp.co.ctc_g.bleexample.presentation.internal.di.modules.ApplicationModule;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
//        this.applicationComponent = DaggerApplicationComponent.builder()
//                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
