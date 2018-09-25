package com.shadowings.reactivecraft.common.core.viewmodels.base;


import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;

public abstract class MainSectionViewModelBase extends ViewModelBase implements IMainSectionViewModel {

    @NonNull
    public final BehaviorSubject<Boolean> isActive = BehaviorSubject.create();
    private CompositeDisposable compositeDisposable;

    @Override
    public void activated() {
        isActive.onNext(true);
        bind();
    }

    //region rx

    @Override
    public void deactivated() {
        isActive.onNext(false);
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
