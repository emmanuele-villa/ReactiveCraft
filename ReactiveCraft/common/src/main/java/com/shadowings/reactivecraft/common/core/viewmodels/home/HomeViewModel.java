package com.shadowings.reactivecraft.common.core.viewmodels.home;

import com.shadowings.reactivecraft.common.core.services.home.ICharacterListService;
import com.shadowings.reactivecraft.common.core.viewmodels.CreateCharacterViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionNavigator;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.simplelocator.SimpleLocator;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends MainSectionViewModelBase {

    //region injections
    private ICharacterListService characterListService;
    private IMainSectionNavigator mainSectionNavigator;

    public HomeViewModel()
    {
        init(
                SimpleLocator.getInstance().get(ICharacterListService.class),
                SimpleLocator.getInstance().get(IMainSectionNavigator.class)
        );
    }

    public HomeViewModel(ICharacterListService characterListService, IMainSectionNavigator mainSectionNavigator)
    {
        init(characterListService, mainSectionNavigator);
    }

    //endregion

    private void init(ICharacterListService characterListService, IMainSectionNavigator mainSectionNavigator)
    {
        this.characterListService = characterListService;
        this.mainSectionNavigator = mainSectionNavigator;

        assert this.characterListService != null;
        assert this.mainSectionNavigator != null;
    }

    public Observable<CharacterPreviewListViewModel> characterPreviewList;

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
        mainSectionNavigator.open(CreateCharacterViewModel.class);
    }
}
