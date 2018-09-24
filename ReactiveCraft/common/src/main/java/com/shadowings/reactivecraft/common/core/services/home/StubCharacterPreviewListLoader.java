package com.shadowings.reactivecraft.common.core.services.home;

import com.shadowings.reactivecraft.common.core.models.home.CharacterPreview;
import com.shadowings.reactivecraft.common.core.models.home.CharacterPreviewList;

public class StubCharacterPreviewListLoader implements ICharacterPreviewListLoader {
    @Override
    public CharacterPreviewList get() {
        CharacterPreviewList list = new CharacterPreviewList();
        for(int i=0; i<10; i++)
        {
            CharacterPreview characterPreview = new CharacterPreview();
            characterPreview.setName("NAME " + i);
            characterPreview.setRealm("REALM");
            characterPreview.setRegion("REGION");
            list.add(characterPreview);
        }
        return list;
    }
}
