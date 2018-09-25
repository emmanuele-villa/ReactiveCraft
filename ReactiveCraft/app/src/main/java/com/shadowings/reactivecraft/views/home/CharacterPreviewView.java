package com.shadowings.reactivecraft.views.home;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.shadowings.reactivecraft.R;
import com.shadowings.reactivecraft.common.core.viewmodels.home.CharacterPreviewViewModel;
import com.shadowings.reactivecraft.common.droid.views.BaseViewGroup;

public class CharacterPreviewView extends BaseViewGroup<CharacterPreviewViewModel> {
    TextView textView;

    public CharacterPreviewView(Context context) {
        super(context);
    }

    public CharacterPreviewView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CharacterPreviewView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_character_preview;
    }

    @Override
    protected void initViews() {
        textView = findViewById(R.id.test_textView);
    }

    @Override
    protected void viewModelChanged() {
        textView.setText(viewModel.getTestString());
    }

}
