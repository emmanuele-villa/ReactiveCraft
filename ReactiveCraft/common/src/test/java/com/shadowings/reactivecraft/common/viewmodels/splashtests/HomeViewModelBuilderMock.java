package com.shadowings.reactivecraft.common.viewmodels.splashtests;

import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.splash.IHomeViewModelBuilder;
import com.shadowings.reactivecraft.common.viewmodels.homeviewmodeltests.CreateCharacterViewModelBuilderMock;

import io.reactivex.Observable;

public class HomeViewModelBuilderMock implements IHomeViewModelBuilder {
    @Override
    public Observable<HomeViewModel> buildHomeViewModel() {
        return Observable.just(new HomeViewModel(new CharacterListServiceMock(), new CreateCharacterViewModelBuilderMock()));
    }
}
