package com.newgear.android.dj.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgear.android.network.CustomRequestInterceptor;
import com.newgear.android.network.RestService;
import com.newgear.android.utils.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Module
public class NetworkModule {

    public static final int CONNECT_TIMEOUT_SECOND = 60;
    public static final int READ_TIMEOUT_SECOND = 60;
    public static final int WRITE_TIMEOUT_SECOND = 60;

    @Provides
    @Singleton
    RestService provideRestService(Retrofit retrofit) {
        return retrofit.create(RestService.class);
    }

    @Provides
    @Singleton Interceptor provideRequestInterceptor() {
        return new CustomRequestInterceptor();
    }

    @Provides
    @Singleton
    Retrofit createRetrofit(Interceptor requestInterceptor, HttpLoggingInterceptor httpLoggingInterceptor) {
        final ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .client(createOkHttpClient(requestInterceptor, httpLoggingInterceptor))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient createOkHttpClient(Interceptor requestInterceptor, HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(CONNECT_TIMEOUT_SECOND, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT_SECOND, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT_SECOND, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }
}
