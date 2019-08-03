package com.newgear.android.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newgear.android.model.User;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.io.IOException;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://gear-staging.scs71.com/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request originalRequest = chain.request();

                            List<User> users = new Select().from(User.class).queryList();
                            String apiToken = "";
                            if(users != null && !users.isEmpty()){
                                apiToken = users.get(0).getApiToken();
                            }
                            Request newRequest = originalRequest.newBuilder()
                                    .header("Accept-Language", "en-US")
                                    .header("Accept-Encoding", "gzip")
                                    .header("Api-Token", apiToken)
                                    .header("Content-Type", "application/json")
                                    .build();

                            return chain.proceed(newRequest);
                        }
                    })
                    .addInterceptor(interceptor)
                    .build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
