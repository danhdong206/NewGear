package com.newgear.android.di.module.login;

import com.newgear.android.di.scopes.FragmentScope;
import com.newgear.android.mvp.login.LoginViewPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginFragmentMVPModule {
    private final LoginViewPresenter.View mView;

    public LoginFragmentMVPModule(LoginViewPresenter.View mView) {
        this.mView = mView;
    }

    @Provides
    @FragmentScope
    LoginViewPresenter.View provideView() {
        return mView;
    }
}
