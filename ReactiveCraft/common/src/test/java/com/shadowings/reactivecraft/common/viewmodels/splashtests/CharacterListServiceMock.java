package com.shadowings.reactivecraft.common.viewmodels.splashtests;

import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;
import com.shadowings.reactivecraft.common.core.services.home.ICharacterListService;

import io.reactivex.Observable;

public class CharacterListServiceMock implements ICharacterListService {
    @Override
    public Observable<CharacterPreviewList> get() {
        return Observable.just(new CharacterPreviewList());
    }
}
