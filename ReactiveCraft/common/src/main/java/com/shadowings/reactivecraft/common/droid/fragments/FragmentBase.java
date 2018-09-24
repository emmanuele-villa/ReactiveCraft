package com.shadowings.reactivecraft.common.droid.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.base.IViewModel;

public abstract class FragmentBase<T extends IMainSectionViewModel> extends Fragment{

    protected abstract int getLayoutId();

    protected T viewModel;
    public T getViewModel() {
        return viewModel;
    }
    public void setViewModel(T viewModel) {
        this.viewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), null);
    }
}
