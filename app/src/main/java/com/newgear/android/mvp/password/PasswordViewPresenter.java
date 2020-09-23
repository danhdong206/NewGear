package com.newgear.android.mvp.password;

public interface PasswordViewPresenter {
    interface View {
        void showProgress();

        void hideProgress();

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPassword(String phoneNumber, String password);

        void onLoginPassword(String password);
    }
}
