package com.newgear.android.network;

import com.newgear.android.network.response.PasswordResponse;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestService {
    @FormUrlEncoded
    @POST("api/v1/public/auth_phone_number")
    Flowable<Void> getPhoneNumber(@Field("phone_number") String phoneNumber);

    @POST("api/v1/public/api_token")
    @FormUrlEncoded
    Flowable<PasswordResponse> getPassword(@Field("phone_number") String phoneNumber, @Field("password") String password);
}
