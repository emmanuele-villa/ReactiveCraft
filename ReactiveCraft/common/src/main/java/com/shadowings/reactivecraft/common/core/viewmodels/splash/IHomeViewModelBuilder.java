package com.shadowings.reactivecraft.common.core.viewmodels.splash;

import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;

import io.reactivex.Observable;


public interface IHomeViewModelBuilder {
    Observable<HomeViewModel> buildHomeViewModel();
}
