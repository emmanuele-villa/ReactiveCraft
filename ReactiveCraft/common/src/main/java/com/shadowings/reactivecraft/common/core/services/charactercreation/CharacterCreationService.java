package com.shadowings.reactivecraft.common.core.services.charactercreation;


import com.shadowings.reactivecraft.common.core.models.charactercreation.RealmList;
import com.shadowings.reactivecraft.common.core.models.charactercreation.RegionList;

import io.reactivex.Observable;

public class CharacterCreationService implements ICharacterCreationService {

    @Override
    public Observable<RegionList> getRegions() {
        RegionList regions = new RegionList();
        regions.add("");
        return Observable.just(regions);
    }

    @Override
    public Observable<RealmList> getRealms(String region) {
        return null;
    }
}
