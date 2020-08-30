package com.newgear.android.retrofit;

import com.newgear.android.model.Response;
import com.newgear.android.model.timeline.Feed;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST("api/v1/public/auth_phone_number")
    @FormUrlEncoded
    Call<Void> getPhoneNumber(@Field("phone_number") String phoneNumber);

    @POST("api/v1/public/api_token")
    @FormUrlEncoded
    Call<Response> getLogin(@Field("phone_number") String phoneNumber, @Field("password") String password);

    @GET("api/v2/feeds")
    Call<Feed> getFeeds();
}
