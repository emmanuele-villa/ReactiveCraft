package com.shadowings.reactivecraft.common.core.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionNavigator;
import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionViewModel;
import com.shadowings.reactivecraft.common.droid.fragments.MainSectionFragmentBase;
import com.shadowings.simplelocator.ObjectFactory;
import com.shadowings.simplelocator.SimpleLocator;
import java.lang.reflect.*;

import java.util.HashMap;

public abstract class AMainSectionNavigator implements IMainSectionNavigator {

    protected static HashMap<String, ObjectFactory<? extends MainSectionFragmentBase>> navigationMap = new HashMap<>();
    protected abstract int getReplaceId();

    @Override
    public void open(Class<? extends IMainSectionViewModel> vm) {
        try {

        ObjectFactory<? extends MainSectionFragmentBase> factory = navigationMap.get(vm.getName());
        MainSectionFragmentBase fragment = factory.build();
        fragment.setViewModel(vm.getConstructor().newInstance());
        AppCompatActivity currentActivity = SimpleLocator.getInstance().get(AppCompatActivity.class);
        FragmentManager fragmentManager = currentActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(getReplaceId(), fragment).commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
