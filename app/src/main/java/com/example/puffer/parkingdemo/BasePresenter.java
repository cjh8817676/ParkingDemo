package com.example.puffer.parkingdemo;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter extends ViewModel {
    private CompositeDisposable disposable = new CompositeDisposable();

    protected void addDisposable(Disposable d) {
        disposable.add(d);
    }

    @Override
    protected void onCleared() {
        disposable.clear();
        super.onCleared();
    }
}
