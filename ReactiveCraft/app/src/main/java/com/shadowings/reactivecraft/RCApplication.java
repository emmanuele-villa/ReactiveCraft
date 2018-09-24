package com.shadowings.reactivecraft;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionNavigator;
import com.shadowings.reactivecraft.common.core.viewmodels.splash.SplashViewModel;
import com.shadowings.reactivecraft.fragments.SplashFragment;
import com.shadowings.reactivecraft.navigation.MainSectionNavigator;
import com.shadowings.simplelocator.SimpleLocator;

public class RCApplication extends Application implements Application.ActivityLifecycleCallbacks {

    @SuppressLint("StaticFieldLeak")
    private static AppCompatActivity currentActivity;
    public static AppCompatActivity getCurrentActivity()
    {
        return currentActivity;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initSimpleLocator();
        initNavigation();
    }

    private void initNavigation() {
        MainSectionNavigator.addRule(SplashViewModel.class, SplashFragment::new);
    }

    private void initSimpleLocator()
    {
        SimpleLocator.getInstance().register(IMainSectionNavigator.class, MainSectionNavigator::new);
        SimpleLocator.getInstance().register(AppCompatActivity.class, RCApplication::getCurrentActivity);
    }

    //region Application.ActivityLifecycleCallbacks

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        currentActivity = (AppCompatActivity)activity;
    }

    @Override
    public void onActivityStarted(Activity activity) {
        currentActivity = (AppCompatActivity)activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        currentActivity = (AppCompatActivity)activity;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        currentActivity = null;
    }

    @Override
    public void onActivityStopped(Activity activity) {
        currentActivity = null;
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    //endregion
}
