package com.newgear.android.interactor;

import com.newgear.android.network.response.PasswordResponse;

import io.reactivex.Flowable;

public interface PasswordInteractor {
    Flowable<PasswordResponse> get(String phoneNumber, String password);
}
