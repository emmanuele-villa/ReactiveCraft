package com.shadowings.reactivecraft.common.core.viewmodels.splash;

import com.shadowings.reactivecraft.common.core.schedulers.SchedulerProvider;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.reactivecraft.common.core.viewmodels.home.CharacterPreviewListViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.simplelocator.SimpleLocator;

import org.xml.sax.Locator;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class SplashViewModel extends MainSectionViewModelBase {

    private IHomeViewModelBuilder homeViewModelBuilder;

    //region injections
    public SplashViewModel()
    {
        init(SimpleLocator.get(IHomeViewModelBuilder.class));
    }

    public SplashViewModel(IHomeViewModelBuilder builder)
    {
        init(builder);
    }

    private void init(IHomeViewModelBuilder builder)
    {
        this.homeViewModelBuilder = builder;
    }
    //endregion

    public Observable<HomeViewModel> homeViewModel;

    @Override
    protected void registerRules() {
        homeViewModel =
                Observable
                        .timer(5, TimeUnit.SECONDS, SchedulerProvider.getWorkerScheduler())
                        .subscribeOn(SchedulerProvider.getWorkerScheduler())
                        .flatMap(__ -> homeViewModelBuilder.buildHomeViewModel());
    }
}

