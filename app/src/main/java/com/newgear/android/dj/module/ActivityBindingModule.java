package com.newgear.android.dj.module;

import com.newgear.android.dj.scopes.ForActivity;
import com.newgear.android.ui.login.LoginActivity;
import com.newgear.android.ui.login.dj.LoginActivityModule;
import com.newgear.android.ui.password.PasswordActivity;
import com.newgear.android.ui.password.dj.PasswordActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ForActivity
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity getLoginActivity();

    @ForActivity
    @ContributesAndroidInjector(modules = PasswordActivityModule.class)
    abstract PasswordActivity getPasswordActivity();
}
