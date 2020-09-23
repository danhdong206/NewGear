package com.newgear.android.mvp.login;

public interface LoginViewPresenter {
    interface View {
        void showProgress();

        void hideProgress();

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPhoneNumber(String phoneNumber);
        void onLoginPhoneNumber(String phoneNumber);
    }
}
