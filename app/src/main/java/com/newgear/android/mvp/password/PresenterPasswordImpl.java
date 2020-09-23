package com.newgear.android.mvp.password;

import com.newgear.android.model.Response;
import com.newgear.android.model.UserPassword;
import com.newgear.android.mvp.login.LoginViewPresenter;
import com.newgear.android.retrofit.APIInterface;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresenterPasswordImpl implements PasswordViewPresenter.Presenter {
    APIInterface apiInterface;
    PasswordViewPresenter.View mView;

    private Disposable disposable;

    @Inject
    public PresenterPasswordImpl(APIInterface apiInterface, PasswordViewPresenter.View mView) {
        this.apiInterface = apiInterface;
        this.mView = mView;
    }

    @Override
    public void loadPassword(String mPhoneNumber, String mPassword) {
        mView.showProgress();

        apiInterface.getLogin(mPhoneNumber, mPassword)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(Response response) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("Wrong password. Please try again!");
                        mView.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        mView.showComplete();
                        disposable.dispose();
                        mView.hideProgress();
                    }
                });
    }

    @Override
    public void onLoginPassword(String password) {
        UserPassword userPassword = new UserPassword(password);
        int loginCode = userPassword.isValidData();

        if (loginCode == 0) {
            mView.showError("You must enter your password");
        } else if (loginCode == 1) {
            mView.showError("Password must be at least 6 characters");
        } else if (loginCode == 2) {
            mView.showError("Password must be at most 127 characters");
        }
    }


}
