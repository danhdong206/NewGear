package com.newgear.android.mvp.login;

import com.newgear.android.model.User;
import com.newgear.android.retrofit.APIInterface;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresenterLoginImpl implements LoginViewPresenter.Presenter {
    APIInterface apiInterface;
    LoginViewPresenter.View mView;

    private Disposable disposable;

    @Inject
    public PresenterLoginImpl(APIInterface apiInterface, LoginViewPresenter.View mView) {
        this.apiInterface = apiInterface;
        this.mView = mView;
    }

    @Override
    public void loadPhoneNumber(String mPhoneNumber) {
        mView.showProgress();

        apiInterface.getPhoneNumber(mPhoneNumber)
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
                        mView.showError("Phone number not exist.");
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
    public void onLoginPhoneNumber(String phoneNumber) {
        User user = new User(phoneNumber);
        int loginCode = user.isValidData();

        if (loginCode == 0)
            mView.showError("You must enter your phone number.");
        else if (loginCode == 1)
            mView.showError("Phone number must be at least 6 characters.");
        else if (loginCode == 2)
            mView.showError("Phone number must be at most 12 characters.");
    }
}
