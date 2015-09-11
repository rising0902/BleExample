package jp.co.ctc_g.bleexample.presentation.navigator;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ActivityNavigator {

    @Inject
    public ActivityNavigator() {
    }

    public void navigateToUserList(Context context) {
        if (context != null) {
            //Intent intentToLaunch = UserListActivity.getCallingIntent(context);
            //context.startActivity(intentToLaunch);
        }
    }

    public void navigateToUserDetails(Context context, int userId) {
        if (context != null) {
            //Intent intentToLaunch = UserDetailsActivity.getCallingIntent(context, userId);
            //context.startActivity(intentToLaunch);
        }
    }
}
