package com.shadowings.reactivecraft.common.core.services.home;


import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;
import com.shadowings.simplelocator.SimpleLocator;

import io.reactivex.Observable;

public class CharacterListService implements ICharacterListService {

    //region injections
    private SharedPreferences sharedPreferences;

    public CharacterListService() {
        init(SimpleLocator.getInstance().get(SharedPreferences.class));
    }

    public CharacterListService(SharedPreferences sharedPreferences) {
        init(sharedPreferences);
    }

    private void init(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
    //endregion

    @Override
    public Observable<CharacterPreviewList> get() {
        Gson gson = new GsonBuilder().create();
        String defaultString = gson.toJson(new CharacterPreviewList());
        String cached = sharedPreferences.getString("CHARACTER_LIST", defaultString);
        CharacterPreviewList characterPreviewList = gson.fromJson(cached, CharacterPreviewList.class);
        return Observable.just(characterPreviewList);
    }

}
