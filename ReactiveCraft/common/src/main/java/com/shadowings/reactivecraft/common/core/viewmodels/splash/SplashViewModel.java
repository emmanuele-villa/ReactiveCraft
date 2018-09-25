package com.shadowings.reactivecraft.common.core.viewmodels.splash;

import android.annotation.SuppressLint;

import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionNavigator;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.simplelocator.SimpleLocator;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SplashViewModel extends MainSectionViewModelBase {

    //region injections

    private IMainSectionNavigator mainSectionNavigator;

    public SplashViewModel()
    {
        init(SimpleLocator.getInstance().get(IMainSectionNavigator.class));
    }

    public SplashViewModel(IMainSectionNavigator mainSectionNavigator)
    {
        init(mainSectionNavigator);
    }

    //endregion

    @SuppressLint("CheckResult")
    private void init(IMainSectionNavigator mainSectionNavigator)
    {
        this.mainSectionNavigator = mainSectionNavigator;

        assert mainSectionNavigator != null;


    }

    private void openHome(Long l)
    {
        mainSectionNavigator.set(HomeViewModel.class);
    }

    @Override
    protected void registerRules() {
        register(
            Observable.timer(5, TimeUnit.SECONDS, Schedulers.io())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::openHome)
        );
    }
}
