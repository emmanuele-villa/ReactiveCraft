package com.shadowings.reactivecraft.common.core.viewmodels.home;

import android.support.annotation.NonNull;
import android.util.Log;

import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;
import com.shadowings.reactivecraft.common.core.services.home.ICharacterListService;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.simplelocator.SimpleLocator;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class HomeViewModel extends MainSectionViewModelBase {

    //region injections
    private ICharacterListService characterListService;

    public HomeViewModel()
    {
        init(SimpleLocator.getInstance().get(ICharacterListService.class));
    }

    public HomeViewModel(ICharacterListService characterListService)
    {
        init(characterListService);
    }

    //endregion

    private void init(ICharacterListService characterListService)
    {
        this.characterListService = characterListService;

        assert this.characterListService != null;
    }

    @NonNull
    public Observable<CharacterPreviewListViewModel> characterPreviewListBehaviorSubject;

    @Override
    protected void registerRules() {
        characterPreviewListBehaviorSubject =
                isActive
                        .filter((active) -> active)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(Schedulers.computation())
                        .flatMap(b -> this.characterListService.get())
                        .map(CharacterPreviewListViewModel::build);
    }

}
