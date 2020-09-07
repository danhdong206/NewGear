package com.newgear.android.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newgear.android.model.user.User;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://gear-staging.symcresol.com/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            OkHttpClient client = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request originalRequest = chain.request();
//
//                            List<User> users = new Select().from(User.class).queryList();
//                            String apiToken = "";
//                            if(users != null && !users.isEmpty()){
//                                apiToken = users.get(0).getApiToken();
//                            }
//                            Request newRequest = originalRequest.newBuilder()
//                                    .header("Accept-Language", "en-US")
//                                    .header("Accept-Encoding", "gzip")
//                                    .header("Api-Token", apiToken)
//                                    .header("Content-Type", "application/json")
//                                    .build();
//
//                            return chain.proceed(newRequest);
//                        }
//                    })
//                    .addInterceptor(interceptor)
//                    .build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .client(client)
//                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
