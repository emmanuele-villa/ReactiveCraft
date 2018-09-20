package com.shadowings.reactivecraft.common.navigation.implementations;

import com.shadowings.reactivecraft.core.navigation.interfaces.IMainSectionNavigator;
import com.shadowings.reactivecraft.core.viewmodels.interfaces.IMainSectionViewModel;

import java.util.HashMap;

public abstract class AMainSectionNavigator implements IMainSectionNavigator {

    protected static HashMap<Class,Class> navigationMap;

    @Override
    public void open(Class<? extends IMainSectionViewModel> vm) {
    }
}
