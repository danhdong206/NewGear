package com.newgear.android.dj.module;

import com.newgear.android.dj.scopes.ForActivity;
import com.newgear.android.ui.login.LoginActivity;
import com.newgear.android.ui.login.dj.LoginActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ForActivity
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity getLoginActivity();
}
