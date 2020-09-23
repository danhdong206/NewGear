package com.newgear.android.di.component;

import android.app.Application;
import android.support.v4.app.Fragment;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().build();
        applicationComponent.injectApplication(this);
    }

    public static MyApplication get(Fragment fragment) {
        return (MyApplication) fragment.getActivity().getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
