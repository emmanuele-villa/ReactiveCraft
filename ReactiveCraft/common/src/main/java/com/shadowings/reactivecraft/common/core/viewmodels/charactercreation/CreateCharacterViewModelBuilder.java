package com.shadowings.reactivecraft.common.core.viewmodels.charactercreation;


import com.shadowings.reactivecraft.common.core.viewmodels.home.ICreateCharacterViewModelBuilder;

import io.reactivex.Observable;

public class CreateCharacterViewModelBuilder implements ICreateCharacterViewModelBuilder {
    @Override
    public Observable<CreateCharacterViewModel> buildCharacterViewModel() {
        return Observable.just(new CreateCharacterViewModel());
    }
}
