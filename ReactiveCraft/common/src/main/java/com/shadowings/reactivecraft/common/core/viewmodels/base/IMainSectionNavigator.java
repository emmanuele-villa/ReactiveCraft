package com.shadowings.reactivecraft.common.core.viewmodels.base;


public interface IMainSectionNavigator {
    void open(Class<? extends IMainSectionViewModel> vm);

    void set(Class<? extends IMainSectionViewModel> vm);
}