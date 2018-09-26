package com.shadowings.reactivecraft.common.viewmodels.homeviewmodeltests;

import com.shadowings.reactivecraft.common.core.services.charactercreation.CharacterCreationService;
import com.shadowings.reactivecraft.common.core.viewmodels.charactercreation.CreateCharacterViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.home.ICreateCharacterViewModelBuilder;

import io.reactivex.Observable;

public class CreateCharacterViewModelBuilderMock implements ICreateCharacterViewModelBuilder {
    @Override
    public Observable<CreateCharacterViewModel> buildCharacterViewModel() {
        return Observable.just(new CreateCharacterViewModel(new CharacterCreationServiceMock()));
    }
}
