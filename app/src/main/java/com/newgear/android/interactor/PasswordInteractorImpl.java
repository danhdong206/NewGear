package com.newgear.android.interactor;

import com.newgear.android.network.RestService;
import com.newgear.android.network.response.PasswordResponse;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class PasswordInteractorImpl implements PasswordInteractor {
    RestService restService;

    @Inject
    public PasswordInteractorImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Flowable<PasswordResponse> get(String phoneNumber, String password) {
        return restService.getPassword(phoneNumber, password);
    }
}
