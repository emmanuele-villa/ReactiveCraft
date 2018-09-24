package com.shadowings.reactivecraft.navigation;

import android.support.v4.app.Fragment;

import com.shadowings.reactivecraft.R;
import com.shadowings.reactivecraft.common.core.navigation.AMainSectionNavigator;
import com.shadowings.simplelocator.ObjectFactory;

public class MainSectionNavigator extends AMainSectionNavigator {

    public static <T extends Fragment> void addRule(Class<?> vm, ObjectFactory<T> factory)
    {
        navigationMap.put(vm.getName(), factory);
    }

    @Override
    protected int getReplaceId() {
        return R.id.frame_layout;
    }
}
