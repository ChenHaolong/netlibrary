package com.net.chl.mylibrary.interceptor;


import com.net.chl.mylibrary.downfile.ProgressResponseBody;
import com.net.chl.mylibrary.downfile.ProgressResponseListener;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by chenhaolong on 2017/9/15.
 */

public class DownFileInterceptor implements Interceptor {

    private ProgressResponseListener progressListener;

    public DownFileInterceptor(ProgressResponseListener progressListener) {
        this.progressListener = progressListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //拦截
        Response originalResponse = chain.proceed(chain.request());

        //包装响应体并返回
        return originalResponse.newBuilder()
                .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                .build();
    }
}
