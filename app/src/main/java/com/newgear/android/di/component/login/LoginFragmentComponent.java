package com.newgear.android.di.component.login;

import com.newgear.android.di.component.ApplicationComponent;
import com.newgear.android.di.module.login.LoginFragmentMVPModule;
import com.newgear.android.di.scopes.FragmentScope;
import com.newgear.android.fragment.LoginFragment;

import dagger.Component;

@FragmentScope
@Component(modules = LoginFragmentMVPModule.class, dependencies = ApplicationComponent.class)
public interface LoginFragmentComponent {
    void injectLoginFragment(LoginFragment loginFragment);
}
