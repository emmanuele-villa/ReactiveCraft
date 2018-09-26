package com.shadowings.reactivecraft.common.viewmodels.homeviewmodeltests;

import com.shadowings.reactivecraft.common.core.models.charactercreation.RealmList;
import com.shadowings.reactivecraft.common.core.models.charactercreation.RegionList;
import com.shadowings.reactivecraft.common.core.services.charactercreation.ICharacterCreationService;

import io.reactivex.Observable;

public class CharacterCreationServiceMock implements ICharacterCreationService {
    @Override
    public Observable<RegionList> getRegions() {
        return Observable.just(new RegionList());
    }

    @Override
    public Observable<RealmList> getRealms(String region) {
        return Observable.just(new RealmList());
    }
}
