package com.newgear.android.di.component.password;

import com.newgear.android.di.component.ApplicationComponent;
import com.newgear.android.di.module.login.LoginFragmentMVPModule;
import com.newgear.android.di.module.password.PasswordFragmentMVPModule;
import com.newgear.android.di.scopes.FragmentScope;
import com.newgear.android.fragment.LoginFragment;
import com.newgear.android.fragment.PasswordFragment;

import dagger.Component;

@FragmentScope
@Component(modules = PasswordFragmentMVPModule.class, dependencies = ApplicationComponent.class)
public interface PasswordFragmentComponent {
    void injectPasswordFragment(PasswordFragment passwordFragment);
}
