package com.shadowings.reactivecraft.common.core.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionNavigator;
import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionViewModel;
import com.shadowings.reactivecraft.common.droid.fragments.MainSectionFragmentBase;
import com.shadowings.simplelocator.ObjectFactory;
import com.shadowings.simplelocator.SimpleLocator;

import java.util.HashMap;

public abstract class AMainSectionNavigator implements IMainSectionNavigator {

    protected static HashMap<String, ObjectFactory<? extends MainSectionFragmentBase>> navigationMap = new HashMap<>();

    protected abstract int getReplaceId();

    public void open(Class<? extends IMainSectionViewModel> vm, boolean addToBackStack) {
        try {
            AppCompatActivity currentActivity = SimpleLocator.getInstance().get(AppCompatActivity.class);

            ObjectFactory<? extends MainSectionFragmentBase> factory = navigationMap.get(vm.getName());
            MainSectionFragmentBase fragment = factory.build();
            fragment.setViewModel(vm.getConstructor().newInstance());

            FragmentManager fragmentManager = currentActivity.getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction().replace(getReplaceId(), fragment);
            if (addToBackStack) {
                transaction.addToBackStack(fragment.getViewModel().getClass().getName());
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void open(Class<? extends IMainSectionViewModel> vm) {
        open(vm, true);
    }

    @Override
    public void set(Class<? extends IMainSectionViewModel> vm) {
        AppCompatActivity currentActivity = SimpleLocator.getInstance().get(AppCompatActivity.class);

        FragmentManager fragmentManager = currentActivity.getSupportFragmentManager();
        for (Fragment fragment : fragmentManager.getFragments()) {
            fragmentManager.beginTransaction().remove(fragment).commit();
        }
        open(vm, false);
    }


}
