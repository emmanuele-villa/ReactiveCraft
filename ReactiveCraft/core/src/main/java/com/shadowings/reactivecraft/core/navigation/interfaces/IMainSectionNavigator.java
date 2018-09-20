package com.shadowings.reactivecraft.core.navigation.interfaces;

import com.shadowings.reactivecraft.core.viewmodels.interfaces.IMainSectionViewModel;

public interface IMainSectionNavigator {
    void open(Class<? extends IMainSectionViewModel> vm);
}
