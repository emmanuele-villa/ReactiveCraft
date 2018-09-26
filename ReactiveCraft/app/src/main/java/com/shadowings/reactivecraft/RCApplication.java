package com.shadowings.reactivecraft;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shadowings.reactivecraft.common.core.schedulers.SchedulerProvider;
import com.shadowings.reactivecraft.common.core.services.charactercreation.CharacterCreationService;
import com.shadowings.reactivecraft.common.core.services.charactercreation.ICharacterCreationService;
import com.shadowings.reactivecraft.common.core.services.home.CharacterListService;
import com.shadowings.reactivecraft.common.core.services.home.ICharacterListService;
import com.shadowings.reactivecraft.common.core.viewmodels.splash.HomeViewModelBuilder;
import com.shadowings.reactivecraft.common.core.viewmodels.splash.IHomeViewModelBuilder;
import com.shadowings.simplelocator.SimpleLocator;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class RCApplication extends Application implements Application.ActivityLifecycleCallbacks {

    @SuppressLint("StaticFieldLeak")
    private static AppCompatActivity currentActivity;

    public static AppCompatActivity getCurrentActivity() {
        return currentActivity;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(this);

        initSimpleLocator();

        initScheduler();
    }

    private void initScheduler()
    {
        SchedulerProvider.setWorkerScheduler(Schedulers.io());
    }

    private void initSimpleLocator() {
        SimpleLocator.register(AppCompatActivity.class, RCApplication::getCurrentActivity);
        SimpleLocator.register(SharedPreferences.class, () -> this.getSharedPreferences(getClass().getName(), MODE_PRIVATE));

        SimpleLocator.register(ICharacterListService.class, CharacterListService::new);
        SimpleLocator.register(ICharacterCreationService.class, CharacterCreationService::new);
        SimpleLocator.register(IHomeViewModelBuilder.class, HomeViewModelBuilder::new);
    }

    //region Application.ActivityLifecycleCallbacks

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        currentActivity = (AppCompatActivity) activity;
    }

    @Override
    public void onActivityStarted(Activity activity) {
        currentActivity = (AppCompatActivity) activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        currentActivity = (AppCompatActivity) activity;
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
