package com.newgear.android.ui.login.dj;

import android.app.Activity;

import com.newgear.android.dj.module.BaseActivityModule;
import com.newgear.android.dj.scopes.ForActivity;
import com.newgear.android.dj.scopes.ForFragment;
import com.newgear.android.ui.login.LoginActivity;
import com.newgear.android.ui.login.view.LoginFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {BaseActivityModule.class})
public abstract class LoginActivityModule {
    @ForActivity
    @Binds
    abstract Activity activity(LoginActivity updateLoginActivity);

    @ForFragment
    @ContributesAndroidInjector(modules = LoginFragmentModule.class)
    abstract LoginFragment loadingLoginFragment();
}
