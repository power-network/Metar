package com.example.qiaoyanxiong.resenter.utils;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseObsever<T> implements Observer<T> {

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    private static final String TAG = "BaseObsever";

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: ");
    }
}
