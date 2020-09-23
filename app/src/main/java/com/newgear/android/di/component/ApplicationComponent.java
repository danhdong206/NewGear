package com.newgear.android.di.component;

import com.newgear.android.di.module.RetrofitModule;
import com.newgear.android.di.scopes.ApplicationScope;
import com.newgear.android.retrofit.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = RetrofitModule.class)
public interface ApplicationComponent {
    APIInterface getApiInterface();

    void injectApplication(MyApplication myApplication);
}
