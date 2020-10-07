package com.newgear.android.network;

import com.newgear.android.data.model.User;

import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CustomRequestInterceptor implements Interceptor {
    private static final String API_TOKEN = "Api-Token";
    private static final String ACCEPT_LANGUAGE = "Accept-Language";
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final String TIME_ZONE = "Time-Zone";

    @Override public Response intercept(Chain chain) throws IOException {
        final String acceptLanguage = Locale.getDefault().toString().replace("_", "-");
        final String acceptEncoding = "gzip";
        final String timeZone = TimeZone.getDefault().getID();
        Request.Builder builder = chain.request().newBuilder();
        if (acceptLanguage != null) {
            builder.addHeader(ACCEPT_LANGUAGE, acceptLanguage);
        }
        if (acceptEncoding != null) {
            //builder.addHeader(ACCEPT_ENCODING, acceptEncoding);
        }
        if (timeZone != null) {
            builder.addHeader(TIME_ZONE, timeZone);
        }
//        User user = User.currentUser();
//        if (user != null && user.getApiToken() != null) {
//            builder.addHeader("Api-Token", user.getApiToken());
//        }

        return chain.proceed(builder.build());
    }

}
