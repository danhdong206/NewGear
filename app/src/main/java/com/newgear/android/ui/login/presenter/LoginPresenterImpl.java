package com.newgear.android.ui.login.presenter;

import com.newgear.android.interactor.LoginInteractor;
import com.newgear.android.data.model.User;
import com.newgear.android.ui.login.view.LoginView;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView mLoginView;

    private LoginInteractor mLoginInteractor;
    private Disposable disposable;

    @Inject
    public LoginPresenterImpl(LoginView mLoginView, LoginInteractor mLoginInteractor) {
        this.mLoginView = mLoginView;
        this.mLoginInteractor = mLoginInteractor;
    }

    @Override
    public void loadPhoneNumber(String mPhoneNumber) {
        mLoginView.showProgress();

        mLoginInteractor.get(mPhoneNumber)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Void>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(Void aVoid) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mLoginView.showError("Phone number not exist.");
                        mLoginView.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        mLoginView.showComplete();
                        disposable.dispose();
                        mLoginView.hideProgress();
                    }
                });
    }

    @Override
    public void onLoginPhoneNumber(String mPhoneNumber) {
        User user = new User(mPhoneNumber);
        int loginCode = user.isValidData();

        if (loginCode == 0)
            mLoginView.showError("You must enter your phone number.");
        else if (loginCode == 1)
            mLoginView.showError("Phone number must be at least 6 characters.");
        else if (loginCode == 2)
            mLoginView.showError("Phone number must be at most 12 characters.");
    }
}
