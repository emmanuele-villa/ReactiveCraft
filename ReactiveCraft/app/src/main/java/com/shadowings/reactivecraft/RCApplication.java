package com.shadowings.reactivecraft;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shadowings.reactivecraft.common.core.services.charactercreation.CharacterCreationService;
import com.shadowings.reactivecraft.common.core.services.charactercreation.ICharacterCreationService;
import com.shadowings.reactivecraft.common.core.services.home.CharacterListService;
import com.shadowings.reactivecraft.common.core.services.home.ICharacterListService;
import com.shadowings.reactivecraft.common.core.viewmodels.CreateCharacterViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionNavigator;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.reactivecraft.fragments.charactercreation.CreateCharacterFragment;
import com.shadowings.reactivecraft.fragments.home.HomeFragment;
import com.shadowings.reactivecraft.navigation.MainSectionNavigator;
import com.shadowings.simplelocator.SimpleLocator;

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
        initNavigation();
    }

    private void initNavigation() {
        MainSectionNavigator.addRule(HomeViewModel.class, HomeFragment::new);
        MainSectionNavigator.addRule(CreateCharacterViewModel.class, CreateCharacterFragment::new);
    }

    private void initSimpleLocator() {
        SimpleLocator.getInstance().register(AppCompatActivity.class, RCApplication::getCurrentActivity);
        SimpleLocator.getInstance().register(SharedPreferences.class, () -> this.getSharedPreferences(getClass().getName(), MODE_PRIVATE));

        SimpleLocator.getInstance().register(IMainSectionNavigator.class, MainSectionNavigator::new);
        SimpleLocator.getInstance().register(ICharacterListService.class, CharacterListService::new);
        SimpleLocator.getInstance().register(ICharacterCreationService.class, CharacterCreationService::new);
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
