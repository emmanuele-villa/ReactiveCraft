package com.shadowings.reactivecraft.common.core.viewmodels.home;

import com.shadowings.reactivecraft.common.core.services.home.ICharacterListService;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.simplelocator.SimpleLocator;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends MainSectionViewModelBase {

    public Observable<CharacterPreviewListViewModel> characterPreviewList;

    //region injections
    private ICharacterListService characterListService;

    public HomeViewModel() {
        this.characterListService = SimpleLocator.get(ICharacterListService.class);
    }

    public HomeViewModel(ICharacterListService characterListService) {
        this.characterListService = characterListService;
    }

    //endregion

    @Override
    protected void registerRules() {
        characterPreviewList =
                isActive
                        .filter((active) -> active)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(Schedulers.computation())
                        .flatMap(b -> this.characterListService.get())
                        .map(CharacterPreviewListViewModel::build);
    }

    public void openCharacterCreation() {
        //mainSectionNavigator.open(CreateCharacterViewModel.class);
    }
}
