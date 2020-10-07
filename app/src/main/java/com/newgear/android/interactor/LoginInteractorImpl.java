package com.newgear.android.interactor;

import com.newgear.android.network.RestService;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class LoginInteractorImpl implements LoginInteractor {
    RestService restService;

    @Inject
    public LoginInteractorImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Flowable<Void> get(String phoneNumber) {
        return restService.getPhoneNumber(phoneNumber);
    }
}
