package com.newgear.android.interactor;

import io.reactivex.Flowable;

public interface LoginInteractor {
    Flowable<Void> get(String phoneNumber);
}
