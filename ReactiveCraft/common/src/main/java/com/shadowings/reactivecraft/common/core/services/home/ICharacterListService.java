package com.shadowings.reactivecraft.common.core.services.home;

import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;

import io.reactivex.Observable;

public interface ICharacterListService {
    Observable<CharacterPreviewList> get();
}
