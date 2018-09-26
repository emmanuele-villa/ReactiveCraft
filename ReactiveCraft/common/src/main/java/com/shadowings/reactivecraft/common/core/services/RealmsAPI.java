package com.shadowings.reactivecraft.common.core.services;

import com.shadowings.reactivecraft.common.core.models.charactercreation.RealmList;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RealmsAPI {

    @GET("wow/realm/status")
    Observable<RealmList> getRealmList(@Query("locale") String locale, @Query("apikey") String apiKey);

    public static Retrofit getClient(String region) {
        String baseUrl = String.format("https://%s.api.battle.net", region);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}