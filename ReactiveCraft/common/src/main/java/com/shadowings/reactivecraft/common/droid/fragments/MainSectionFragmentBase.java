package com.shadowings.reactivecraft.common.droid.fragments;

import com.shadowings.reactivecraft.common.core.viewmodels.base.IMainSectionViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class MainSectionFragmentBase<T extends IMainSectionViewModel> extends FragmentBase<T> {

    //region lifecycle

    private CompositeDisposable compositeDisposable;

    @Override
    public void onResume() {
        super.onResume();
        viewModel.activated();
        bind();
    }

    //endregion

    //region rx

    @Override
    public void onPause() {
        super.onPause();
        viewModel.deactivated();
        unbind();
    }

    private void bind() {
        unbind();
        compositeDisposable = new CompositeDisposable();
        registerRules();
    }

    private void unbind() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    protected void register(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected abstract void registerRules();
    //endregion
}
