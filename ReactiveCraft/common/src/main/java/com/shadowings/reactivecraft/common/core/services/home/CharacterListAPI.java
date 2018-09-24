package com.shadowings.reactivecraft.common.core.services.home;

import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface CharacterListAPI {

    @GET("bins/zjycc")
    Observable<CharacterPreviewList> get();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.api.myjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
