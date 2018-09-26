package com.shadowings.reactivecraft.common.core.viewmodels.home;

import com.shadowings.reactivecraft.common.core.schedulers.SchedulerProvider;
import com.shadowings.reactivecraft.common.core.services.home.ICharacterListService;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.reactivecraft.common.core.viewmodels.charactercreation.CreateCharacterViewModel;
import com.shadowings.simplelocator.SimpleLocator;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class HomeViewModel extends MainSectionViewModelBase {

    public Observable<CharacterPreviewListViewModel> characterPreviewListObservable;
    public Observable<CreateCharacterViewModel> createCharacterViewModelObservable;

    private BehaviorSubject<Boolean> requestOpenCharacterCreation  = BehaviorSubject.create();

    //region injections
    private ICharacterListService characterListService;
    private ICreateCharacterViewModelBuilder createCharacterViewModelBuilder;

    public HomeViewModel() {
        init(
                SimpleLocator.get(ICharacterListService.class),
                SimpleLocator.get(ICreateCharacterViewModelBuilder.class)
        );
    }

    public HomeViewModel(ICharacterListService characterListService, ICreateCharacterViewModelBuilder createCharacterViewModelBuilder) {
        init(characterListService, createCharacterViewModelBuilder);
    }

    private void init(ICharacterListService characterListService, ICreateCharacterViewModelBuilder createCharacterViewModelBuilder)
    {
        this.characterListService = characterListService;
        this.createCharacterViewModelBuilder = createCharacterViewModelBuilder;
    }

    //endregion

    @Override
    protected void registerRules() {
        characterPreviewListObservable =
                isActive
                        .filter((active) -> active)
                        .observeOn(SchedulerProvider.getWorkerScheduler())
                        .flatMap(b -> this.characterListService.get())
                        .map(CharacterPreviewListViewModel::build);

        createCharacterViewModelObservable =
                requestOpenCharacterCreation
                        .flatMap(__ -> createCharacterViewModelBuilder.buildCharacterViewModel());
    }

    public void requestCharacterCreationViewModel() {
        requestOpenCharacterCreation.onNext(true);
    }
}
