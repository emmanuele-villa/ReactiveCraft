package com.shadowings.reactivecraft.common.core.viewmodels;

import com.shadowings.reactivecraft.common.core.models.charactercreation.RegionList;
import com.shadowings.reactivecraft.common.core.services.charactercreation.ICharacterCreationService;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.simplelocator.SimpleLocator;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Single;

public class CreateCharacterViewModel extends MainSectionViewModelBase {

    //region injections
    private ICharacterCreationService characterCreationService;

    public CreateCharacterViewModel()
    {
        init(SimpleLocator.getInstance().get(ICharacterCreationService.class));
    }

    public CreateCharacterViewModel(ICharacterCreationService characterCreationService)
    {
        init(characterCreationService);
    }

    private void init(ICharacterCreationService characterCreationService)
    {
        this.characterCreationService = characterCreationService;
    }

    //endregion
    public Observable<RegionList> getRegions()
    {
        return characterCreationService.getRegions();
    }

    @Override
    protected void registerRules() {

    }
}
