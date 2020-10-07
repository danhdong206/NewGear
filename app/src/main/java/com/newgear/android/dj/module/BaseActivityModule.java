package com.newgear.android.dj.module;

import android.app.Activity;
import android.app.FragmentManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule {
    static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    static FragmentManager activityFragmentManager(Activity activity) {
        return activity.getFragmentManager();
    }
}
