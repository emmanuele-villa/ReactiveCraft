package com.shadowings.reactivecraft.common.core.services.charactercreation;

import com.shadowings.reactivecraft.common.core.models.charactercreation.RealmList;
import com.shadowings.reactivecraft.common.core.models.charactercreation.RegionList;

import io.reactivex.Observable;


public interface ICharacterCreationService {
    Observable<RegionList> getRegions();
    Observable<RealmList> getRealms(String region);
}
