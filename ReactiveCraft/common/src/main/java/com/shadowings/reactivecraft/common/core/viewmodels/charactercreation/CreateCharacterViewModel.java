package com.shadowings.reactivecraft.common.core.viewmodels.charactercreation;

import com.shadowings.reactivecraft.common.core.models.charactercreation.RealmList;
import com.shadowings.reactivecraft.common.core.models.charactercreation.RegionList;
import com.shadowings.reactivecraft.common.core.services.charactercreation.ICharacterCreationService;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.simplelocator.SimpleLocator;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class CreateCharacterViewModel extends MainSectionViewModelBase {

    public Observable<RealmList> realmList;
    private BehaviorSubject<String> selectedRegion = BehaviorSubject.create();

    //region injections
    private ICharacterCreationService characterCreationService;

    public CreateCharacterViewModel() {
        init(SimpleLocator.get(ICharacterCreationService.class));
    }

    public CreateCharacterViewModel(ICharacterCreationService characterCreationService) {
        init(characterCreationService);
    }

    //endregion

    private void init(ICharacterCreationService characterCreationService) {
        this.characterCreationService = characterCreationService;
    }

    public void setRegion(String region) {
        selectedRegion.onNext(region);
    }

    public Observable<RegionList> getRegions() {
        return characterCreationService.getRegions();
    }

    private Observable<RealmList> getRealms(String region) {
        return characterCreationService.getRealms(region);
    }

    @Override
    protected void registerRules() {
        realmList =
                selectedRegion
                        .subscribeOn(Schedulers.computation())
                        .observeOn(Schedulers.computation())
                        .flatMap(this::getRealms);
    }
}
