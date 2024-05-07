package com.raynor.xxljob.util;

import com.google.gson.Gson;
import com.raynor.xxljob.result.ReturnT;
import okhttp3.*;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author zongkxc
 */
public class HttpUtil {

    /**
     * 构建请求体 form body
     */
    public static FormBody.Builder toBuilder(Object o) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object val = field.get(o);
                builder.add(field.getName(), val == null ? "" : val.toString());
            }
            return builder;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new FormBody.Builder();
        }
    }
    /**
     * okhttp post请求
     * @param okHttpClient 客户端
     * @param builder 请求体
     * @param url   请求地址
     * @param classType 反序列化类型
     * @return  ReturnT 通用类型
     */
    public static ReturnT execute(OkHttpClient okHttpClient, FormBody.Builder builder, String url, Class<?> classType){
        return HttpUtil.execute(okHttpClient,builder,null,url,classType);
    }

    /**
     * okhttp post请求
     * @param okHttpClient 客户端
     * @param builder 请求体
     * @param headers 请求头
     * @param url   请求地址
     * @param classType 反序列化类型
     * @return  ReturnT 通用类型
     */
    public static ReturnT execute(OkHttpClient okHttpClient,FormBody.Builder builder,Headers headers,String url, Class<?> classType){
        try (Response response = okHttpClient.newCall(HttpUtil.toRequest(headers, builder, url)).execute()) {
            if (!response.isSuccessful()) {
                return new ReturnT<>(500, response.body().string());
            }
            if (Objects.equals(classType, ReturnT.class)) {
                return (ReturnT) new Gson().fromJson(response.body().string(), classType);
            }
            return new ReturnT<>(new Gson().fromJson(response.body().string(), classType));
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnT<>(500, e.getMessage());
        }
    }

    private static Request toRequest(Headers headers,FormBody.Builder builder,String url){
        if(headers != null){
            return new Request.Builder().post(builder.build()).headers(headers).url(url).build();
        }else{
            return new Request.Builder().post(builder.build()).url(url).build();
        }
    }
}
