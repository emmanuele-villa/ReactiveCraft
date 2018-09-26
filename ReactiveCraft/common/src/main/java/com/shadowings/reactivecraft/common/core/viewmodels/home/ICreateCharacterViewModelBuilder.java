package com.shadowings.reactivecraft.common.core.viewmodels.home;

import com.shadowings.reactivecraft.common.core.viewmodels.charactercreation.CreateCharacterViewModel;

import io.reactivex.Observable;

public interface ICreateCharacterViewModelBuilder {
    Observable<CreateCharacterViewModel> buildCharacterViewModel();
}
