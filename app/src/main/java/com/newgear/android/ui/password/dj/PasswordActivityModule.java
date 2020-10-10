package com.newgear.android.ui.password.dj;

import android.app.Activity;

import com.newgear.android.dj.module.BaseActivityModule;
import com.newgear.android.dj.scopes.ForActivity;
import com.newgear.android.dj.scopes.ForFragment;
import com.newgear.android.ui.password.PasswordActivity;
import com.newgear.android.ui.password.view.PasswordFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {BaseActivityModule.class})
public abstract class PasswordActivityModule {
    @ForActivity
    @Binds
    abstract Activity activity(PasswordActivity updatePasswordActivity);

    @ForFragment
    @ContributesAndroidInjector(modules = PasswordFragmentModule.class)
    abstract PasswordFragment loadingPasswordFragment();
}
