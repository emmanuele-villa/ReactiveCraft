package com.shadowings.reactivecraft.common.core.services.charactercreation;


import com.shadowings.reactivecraft.common.core.models.charactercreation.RealmList;
import com.shadowings.reactivecraft.common.core.models.charactercreation.RegionList;
import com.shadowings.reactivecraft.common.core.services.RealmsAPI;

import java.util.Collection;
import java.util.Collections;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class CharacterCreationService implements ICharacterCreationService {


    @Override
    public Observable<RegionList> getRegions() {
        RegionList regions = new RegionList();
        regions.add("EU");
        regions.add("KR");
        regions.add("TW");
        regions.add("US");
        Collections.sort(regions);
        return Observable.just(regions);
    }

    @Override
    public Observable<RealmList> getRealms(String region) {
        Retrofit client = RealmsAPI.getClient(region);
        RealmsAPI api = client.create(RealmsAPI.class);
        return api.getRealmList("en_EN", "eng7z9cg4cpa47cw6njxdrd5duv6ypmk");
    }
}
