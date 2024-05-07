package com.raynor.xxljob.interceptor;

import com.raynor.xxljob.conf.XxlJobServerConf;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * cookie auth Interceptor
 */
public class AuthInterceptor implements Interceptor {
    private OkHttpClient okHttpClient;
    private XxlJobServerConf xxlJobServerConf;

    public AuthInterceptor(OkHttpClient okHttpClient, XxlJobServerConf xxlJobServerConf) {
        this.okHttpClient = okHttpClient;
        this.xxlJobServerConf = xxlJobServerConf;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        FormBody formBody = new FormBody.Builder()
                .add("userName", this.xxlJobServerConf.getName())
                .add("password", this.xxlJobServerConf.getPassword())
                .build();
        Request request = new Request.Builder().post(formBody).url(xxlJobServerConf.getLoginUrl()).build();
        Response response = this.okHttpClient.newCall(request).execute();
        String token = response.header("Set-Cookie");
        builder.addHeader("Cookie", token);
        return chain.proceed(builder.build());
    }
}
