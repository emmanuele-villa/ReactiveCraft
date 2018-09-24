package com.shadowings.reactivecraft.common.core.services.home;

import com.shadowings.reactivecraft.common.core.models.home.CharacterPreview;
import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;
import com.shadowings.reactivecraft.common.core.viewmodels.home.CharacterPreviewListViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.home.CharacterPreviewViewModel;
import com.shadowings.simplelocator.SimpleLocator;

public class CharacterPreviewVMListProvider implements ICharacterPreviewVMListProvider {

    private ICharacterPreviewListLoader characterPreviewListLoader;

    //region injection
    public CharacterPreviewVMListProvider()
    {
        init(SimpleLocator.getInstance().get(ICharacterPreviewListLoader.class));
    }

    public CharacterPreviewVMListProvider(ICharacterPreviewListLoader characterPreviewListLoader)
    {
        init(characterPreviewListLoader);
    }

    private void init(ICharacterPreviewListLoader characterPreviewListLoader)
    {
        this.characterPreviewListLoader = characterPreviewListLoader;
    }
    //endregion

    @Override
    public CharacterPreviewListViewModel get() {
        CharacterPreviewListViewModel vms = new CharacterPreviewListViewModel();
        CharacterPreviewList models = characterPreviewListLoader.get();
        for (CharacterPreview c : models) {
            CharacterPreviewViewModel vm = new CharacterPreviewViewModel();
            vm.setCharacterPreview(c);
            vms.add(vm);
        }
        return vms;
    }
}
