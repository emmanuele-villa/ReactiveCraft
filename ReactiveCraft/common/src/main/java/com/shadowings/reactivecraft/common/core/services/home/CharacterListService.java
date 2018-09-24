package com.shadowings.reactivecraft.common.core.services.home;


import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;

import io.reactivex.Observable;

public class CharacterListService implements ICharacterListService {

    private final CharacterListAPI characterListAPI;

    public CharacterListService()
    {
        characterListAPI = CharacterListAPI.retrofit.create(CharacterListAPI.class);
    }

    @Override
    public Observable<CharacterPreviewList> get() {
        return characterListAPI.get();
    }
}
