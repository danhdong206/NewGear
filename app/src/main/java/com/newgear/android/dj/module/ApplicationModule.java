package com.newgear.android.dj.module;

import android.content.Context;

import com.newgear.android.App;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {
    @Binds
    abstract Context bindContext(App application);
}
