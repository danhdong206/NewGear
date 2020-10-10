package com.newgear.android.ui.password.presenter;

import com.newgear.android.data.model.UserPassword;
import com.newgear.android.interactor.PasswordInteractor;
import com.newgear.android.network.response.PasswordResponse;
import com.newgear.android.ui.password.view.PasswordView;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PasswordPresenterImpl implements PasswordPresenter {

    private PasswordView mPasswordView;

    private PasswordInteractor mPasswordInteractor;
    private Disposable disposable;

    @Inject
    public PasswordPresenterImpl(PasswordView mPasswordView, PasswordInteractor mPasswordInteractor) {
        this.mPasswordView = mPasswordView;
        this.mPasswordInteractor = mPasswordInteractor;
    }

    @Override
    public void loadPassword(String mPhoneNumber, String mPassword) {
        mPasswordView.showProgress();

        mPasswordInteractor.get(mPhoneNumber, mPassword)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PasswordResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(PasswordResponse response) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mPasswordView.showError("Wrong password. Please try again!");
                        mPasswordView.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        mPasswordView.showComplete("Login Successfully");
                        disposable.dispose();
                        mPasswordView.hideProgress();
                    }
                });
    }

    @Override
    public void onLoginPassword(String password) {
        UserPassword userPassword = new UserPassword(password);
        int loginCode = userPassword.isValidData();

        if (loginCode == 0) {
            mPasswordView.showError("You must enter your password");
        } else if (loginCode == 1) {
            mPasswordView.showError("Password must be at least 6 characters");
        } else if (loginCode == 2) {
            mPasswordView.showError("Password must be at most 127 characters");
        }
    }
}
