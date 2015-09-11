package jp.co.ctc_g.bleexample.presentation.internal.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.ctc_g.bleexample.domain.executor.ThreadExecutor;
import jp.co.ctc_g.bleexample.presentation.internal.di.modules.ApplicationModule;
import jp.co.ctc_g.bleexample.presentation.view.activity.BaseActivity;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    Context context();
    ThreadExecutor threadExecutor();
    //PostExecutionThread postExecutionThread();
    //UserRepository userRepository();
}
