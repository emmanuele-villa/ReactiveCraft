package com.shadowings.reactivecraft.common.core.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionNavigator;
import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionViewModel;
import com.shadowings.simplelocator.ObjectFactory;
import com.shadowings.simplelocator.SimpleLocator;

import java.util.HashMap;

public abstract class AMainSectionNavigator implements IMainSectionNavigator {

    protected static HashMap<String, ObjectFactory<? extends Fragment>> navigationMap = new HashMap<>();
    protected abstract int getReplaceId();

    @Override
    public void open(Class<? extends IMainSectionViewModel> vm) {
        ObjectFactory<? extends Fragment> factory = navigationMap.get(vm.getName());
        Fragment fragment = factory.build();
        AppCompatActivity currentActivity = SimpleLocator.getInstance().get(AppCompatActivity.class);
        FragmentManager fragmentManager = currentActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(getReplaceId(), fragment).commit();
    }
}
