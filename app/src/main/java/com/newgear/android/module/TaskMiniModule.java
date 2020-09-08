package com.newgear.android.module;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.newgear.android.model.timeline.DriverInfo;
import com.newgear.android.model.timeline.PartnerRating;
import com.newgear.android.model.timeline.TasksMini;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskMiniModule {
    @Provides
    static PartnerRating providePartnerRatings() {
        return new PartnerRating();
    }

    @Provides
    static DriverInfo provideDriverInfos() {
        return new DriverInfo();
    }

    @Provides
    static TasksMini provideTaskMini(List<PartnerRating> partnerRating, List<DriverInfo> driverInfo) {
        return new TasksMini(partnerRating, driverInfo);
    }
}
