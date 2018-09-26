package com.shadowings.reactivecraft.common.core.viewmodels.splash;

import com.shadowings.reactivecraft.common.core.schedulers.SchedulerProvider;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.simplelocator.SimpleLocator;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;


public class SplashViewModel extends MainSectionViewModelBase {

    public Observable<HomeViewModel> homeViewModelObservable;
    private IHomeViewModelBuilder homeViewModelBuilder;

    //region injections
    public SplashViewModel() {
        init(SimpleLocator.get(IHomeViewModelBuilder.class));
    }

    public SplashViewModel(IHomeViewModelBuilder builder) {
        init(builder);
    }
    //endregion

    private void init(IHomeViewModelBuilder builder) {
        this.homeViewModelBuilder = builder;
    }

    @Override
    protected void registerRules() {
        homeViewModelObservable =
                Observable
                        .timer(5, TimeUnit.SECONDS, SchedulerProvider.getWorkerScheduler())
                        .subscribeOn(SchedulerProvider.getWorkerScheduler())
                        .flatMap(__ -> homeViewModelBuilder.buildHomeViewModel());
    }
}

