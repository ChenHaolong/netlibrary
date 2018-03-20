package com.net.chl.mylibrary.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/17.
 */
public class OnOffLineCachedInterceptor implements Interceptor {
    private static final int MAX_AGE = 60;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

//        if (!OtherUtilities.isNetworkAvaliable()) {
//            request = request.newBuilder()
//                    //强制使用缓存
//                    .cacheControl(CacheControl.FORCE_CACHE).build();
//        }

        Response response = chain.proceed(request);

//        if (OtherUtilities.isNetworkAvaliable()) {
//            response.newBuilder().header("Cache-Control", "public, max-age=" + MAX_AGE).removeHeader("Pragma").build();
//        } else {
//            int maxStale = 60 * 60 * 24 * 28; //无网络时，设置超时为4周
//            response.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale).removeHeader("Pragma").build();
//        }
        return response;
    }
}
