package com.net.chl.mylibrary;


import com.net.chl.mylibrary.downfile.ProgressResponseListener;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenhaolong on 2017/9/6.
 */

enum RetrofitUtils {
    INSTANCE;
    private Retrofit.Builder builder;

    RetrofitUtils() {
        builder = new Retrofit.Builder()
                //baseUrl
                .baseUrl(OkhttpUtils.getBaseUrl())
                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    /**
     * 普通
     */
    Retrofit getRetrofit() {
        return builder.client(OkhttpUtils.getOkHttpClient()).build();
    }

    /**
     * 下载文件
     */
    Retrofit getDownFileRetrofit(ProgressResponseListener progressListener) {
        return builder.client(OkhttpUtils.getDownFileClient(progressListener)).build();
    }

}
