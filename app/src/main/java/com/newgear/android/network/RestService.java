package com.newgear.android.network;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface RestService {
    @POST("api/v1/public/auth_phone_number")
    Flowable<Void> getPhoneNumber(@Field("phone_number") String phoneNumber);
}
