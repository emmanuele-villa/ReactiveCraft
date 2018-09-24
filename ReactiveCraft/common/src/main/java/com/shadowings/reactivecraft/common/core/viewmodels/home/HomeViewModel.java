package com.shadowings.reactivecraft.common.core.viewmodels.home;

import android.support.annotation.NonNull;

import com.shadowings.reactivecraft.common.core.services.home.ICharacterPreviewVMListProvider;
import com.shadowings.reactivecraft.common.core.viewmodels.base.MainSectionViewModelBase;
import com.shadowings.simplelocator.SimpleLocator;

import io.reactivex.subjects.BehaviorSubject;

public class HomeViewModel extends MainSectionViewModelBase {

    //region injections
    private ICharacterPreviewVMListProvider characterPreviewListService;

    public HomeViewModel()
    {
        init(SimpleLocator.getInstance().get(ICharacterPreviewVMListProvider.class));
    }

    public HomeViewModel(ICharacterPreviewVMListProvider characterPreviewListService)
    {
        init(characterPreviewListService);
    }

    //endregion

    private void init(ICharacterPreviewVMListProvider characterPreviewListService)
    {
        this.characterPreviewListService = characterPreviewListService;

        assert this.characterPreviewListService != null;
    }

    @NonNull
    public final BehaviorSubject<CharacterPreviewListViewModel> characterPreviewListBehaviorSubject = BehaviorSubject.create();

    @Override
    public void activated() {
        super.activated();
        characterPreviewListBehaviorSubject.onNext(characterPreviewListService.get());
    }
}
