package com.newgear.android.di.module.password;

import com.newgear.android.di.scopes.FragmentScope;
import com.newgear.android.mvp.password.PasswordViewPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PasswordFragmentMVPModule {
    private final PasswordViewPresenter.View mView;

    public PasswordFragmentMVPModule(PasswordViewPresenter.View mView) {
        this.mView = mView;
    }

    @Provides
    @FragmentScope
    PasswordViewPresenter.View provideView() {
        return mView;
    }
}
