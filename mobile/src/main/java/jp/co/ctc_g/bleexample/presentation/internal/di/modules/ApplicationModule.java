package jp.co.ctc_g.bleexample.presentation.internal.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.co.ctc_g.bleexample.data.executor.JobExecutor;
import jp.co.ctc_g.bleexample.domain.executor.ThreadExecutor;
import jp.co.ctc_g.bleexample.AndroidApplication;
import jp.co.ctc_g.bleexample.presentation.navigator.ActivityNavigator;

@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ActivityNavigator provideNavigator() {
        return new ActivityNavigator();
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    //@Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    //    return uiThread;
    //}

    //@Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
    //    return userCache;
    //}

    //@Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository) {
    //    return userDataRepository;
    //}
}
