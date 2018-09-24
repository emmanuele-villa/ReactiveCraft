package com.shadowings.reactivecraft.common.core.viewmodels.home;

import com.shadowings.reactivecraft.common.core.models.home.CharacterPreview;
import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;

import java.util.ArrayList;

public class CharacterPreviewListViewModel extends ArrayList<CharacterPreviewViewModel> {

    public static CharacterPreviewListViewModel build(CharacterPreviewList model)
    {
        CharacterPreviewListViewModel vms = new CharacterPreviewListViewModel();
        for(CharacterPreview characterPreview : model)
        {
            CharacterPreviewViewModel vm = new CharacterPreviewViewModel();
            vm.setCharacterPreview(characterPreview);
            vms.add(vm);
        }
        return vms;
    }
}
