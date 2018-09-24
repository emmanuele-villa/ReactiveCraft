package com.shadowings.reactivecraft.common.core.viewmodels.base;


public interface IMainSectionNavigator {
    void open(Class<? extends IMainSectionViewModel> vm);
}