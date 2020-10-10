package com.newgear.android.ui.password.dj;

import android.support.v4.app.Fragment;

import com.newgear.android.dj.module.BaseFragmentModule;
import com.newgear.android.dj.scopes.ForFragment;
import com.newgear.android.ui.password.presenter.PasswordPresenter;
import com.newgear.android.ui.password.presenter.PasswordPresenterImpl;
import com.newgear.android.ui.password.view.PasswordFragment;
import com.newgear.android.ui.password.view.PasswordView;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = BaseFragmentModule.class)
public abstract class PasswordFragmentModule {
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    abstract Fragment fragment(PasswordFragment passwordFragment);

    @Provides
    @ForFragment
    static PasswordView providePasswordView(PasswordFragment passwordFragment) {
        return passwordFragment;
    }

    @ForFragment
    @Binds
    abstract PasswordPresenter providePasswordPresenter(PasswordPresenterImpl passwordPresenter);
}
