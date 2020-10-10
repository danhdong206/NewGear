package com.newgear.android.dj.module;

import com.newgear.android.interactor.LoginInteractor;
import com.newgear.android.interactor.LoginInteractorImpl;
import com.newgear.android.interactor.PasswordInteractor;
import com.newgear.android.interactor.PasswordInteractorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetworkModule.class)
public class InteractorModule {
    @Provides
    @Singleton
    LoginInteractor provideLoginInteractor(LoginInteractorImpl loginInteractor) {
        return loginInteractor;
    }

    @Provides
    @Singleton
    PasswordInteractor providePasswordInteractor(PasswordInteractorImpl passwordInteractor) {
        return passwordInteractor;
    }
}
