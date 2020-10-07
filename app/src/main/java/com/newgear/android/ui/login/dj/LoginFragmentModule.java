package com.newgear.android.ui.login.dj;

import android.support.v4.app.Fragment;

import com.newgear.android.dj.module.BaseFragmentModule;
import com.newgear.android.dj.scopes.ForFragment;
import com.newgear.android.ui.login.presenter.LoginPresenter;
import com.newgear.android.ui.login.presenter.LoginPresenterImpl;
import com.newgear.android.ui.login.view.LoginFragment;
import com.newgear.android.ui.login.view.LoginView;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = BaseFragmentModule.class)
public abstract class LoginFragmentModule {
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    abstract Fragment fragment(LoginFragment loginFragment);

    @Provides
    @ForFragment
    static LoginView provideLoginView(LoginFragment loginFragment) {
        return loginFragment;
    }

    @ForFragment
    @Binds
    abstract LoginPresenter provideLoginPresenter(LoginPresenterImpl loginPresenter);
}
