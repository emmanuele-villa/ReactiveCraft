package com.shadowings.reactivecraft.common.core.viewmodels.splash;


import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;

import io.reactivex.Observable;

public class HomeViewModelBuilder implements IHomeViewModelBuilder {
    @Override
    public Observable<HomeViewModel> buildHomeViewModel() {
        return Observable.just(new HomeViewModel());
    }
}
