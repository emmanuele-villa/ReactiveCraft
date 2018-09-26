package com.shadowings.reactivecraft.common.viewmodels.homeviewmodeltests;

import com.shadowings.reactivecraft.common.core.schedulers.SchedulerProvider;
import com.shadowings.reactivecraft.common.core.viewmodels.home.CharacterPreviewListViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.reactivecraft.common.viewmodels.splashtests.CharacterListServiceMock;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;

public class HomeViewModelTest {

    @BeforeClass
    public static void prepare()
    {
        SchedulerProvider.setWorkerScheduler(new TestScheduler());
    }

    @Test
    public void characterListIsLoaded_afterActivation()
    {
        HomeViewModel viewModel = new HomeViewModel(new CharacterListServiceMock(), new CreateCharacterViewModelBuilderMock());
        TestObserver<CharacterPreviewListViewModel> observer = new TestObserver<>();

        viewModel.activated();

        viewModel.characterPreviewListObservable
                .subscribeOn(SchedulerProvider.getWorkerScheduler())
                .subscribe(observer);

        ((TestScheduler)SchedulerProvider.getWorkerScheduler()).advanceTimeBy(1, TimeUnit.SECONDS);

        observer.assertComplete();
    }
}
