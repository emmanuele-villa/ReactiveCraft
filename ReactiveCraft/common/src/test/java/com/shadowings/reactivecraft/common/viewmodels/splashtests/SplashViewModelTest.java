package com.shadowings.reactivecraft.common.viewmodels.splashtests;

import com.shadowings.reactivecraft.common.core.schedulers.SchedulerProvider;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.splash.SplashViewModel;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.assertFalse;

public class SplashViewModelTest {

    @BeforeClass
    public static void prepare()
    {
        SchedulerProvider.setWorkerScheduler(new TestScheduler());
    }

    @Test
    public void shouldWaitFiveSeconds_thenCreateHome()
    {
        SplashViewModel viewModel = new SplashViewModel(new HomeViewModelBuilderMock());
        TestObserver<HomeViewModel> observer = new TestObserver<>();

        viewModel.activated();

        viewModel.homeViewModelObservable
                .subscribeOn(SchedulerProvider.getWorkerScheduler())
                .subscribe(observer);

        ((TestScheduler)SchedulerProvider.getWorkerScheduler()).advanceTimeBy(6, TimeUnit.SECONDS);

        observer.assertComplete();
    }
}
