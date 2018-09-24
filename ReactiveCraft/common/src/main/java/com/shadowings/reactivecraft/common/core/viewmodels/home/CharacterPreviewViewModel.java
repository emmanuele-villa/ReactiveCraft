package com.shadowings.reactivecraft.common.core.viewmodels.home;

import com.shadowings.reactivecraft.common.core.models.home.CharacterPreview;
import com.shadowings.reactivecraft.common.core.viewmodels.base.IViewModel;

public class CharacterPreviewViewModel implements IViewModel {
    private CharacterPreview characterPreview;
    private int testString;

    public CharacterPreview getCharacterPreview() {
        return characterPreview;
    }

    public void setCharacterPreview(CharacterPreview characterPreview) {
        this.characterPreview = characterPreview;
    }

    public String getTestString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.characterPreview.getRegion());
        sb.append(" - ");
        sb.append(this.characterPreview.getRealm());
        sb.append(" - ");
        sb.append(this.characterPreview.getName());
        return sb.toString();
    }
}
