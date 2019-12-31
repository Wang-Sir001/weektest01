package com.bawei.wangjiangwei.utils;

import android.os.Handler;

import com.bawei.wangjiangwei.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * 姓名：王江伟
 * 时间：2019年12月31日10:41:25
 * 作用：网络请求框架
 */
public class OkHttpUtils {
    Handler handler = new Handler();
    private OkHttpClient okHttpClient;
    private static OkHttpUtils okHttpUtils;

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class){
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    public void doGet(String url,OkHttpCallback okHttpCallback){
        Request build = new Request.Builder()
                .get()
                .url(url)
                .build();

        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                okHttpCallback.error(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                okHttpCallback.success(response.body().string());
            }
        });
    }

    public interface OkHttpCallback{
        void success(String data);
        void error(Throwable throwable);
    }
}
