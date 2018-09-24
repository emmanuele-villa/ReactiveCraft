package com.shadowings.reactivecraft.common.droid.views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

import com.shadowings.reactivecraft.common.core.viewmodels.base.IViewModel;

public abstract class BaseViewGroup<T extends IViewModel> extends ConstraintLayout {

    protected abstract int getLayoutId();

    protected T viewModel;

    public T getViewModel() {
        return viewModel;
    }

    public void setViewModel(T viewModel) {
        this.viewModel = viewModel;
        viewModelChanged();
    }

    public BaseViewGroup(Context context) {
        super(context);
        setup();
    }

    public BaseViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public BaseViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup()
    {
        inflate(getContext(), getLayoutId(), this);
        initViews();
    }

    protected abstract void initViews();

    protected abstract void viewModelChanged();
}
