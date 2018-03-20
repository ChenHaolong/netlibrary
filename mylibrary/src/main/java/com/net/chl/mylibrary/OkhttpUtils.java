package com.net.chl.mylibrary;

import android.content.Context;

import com.net.chl.mylibrary.downfile.ProgressResponseListener;
import com.net.chl.mylibrary.interceptor.BaseUrlInterceptor;
import com.net.chl.mylibrary.interceptor.DownFileInterceptor;
import com.net.chl.mylibrary.interceptor.OnOffLineCachedInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by chenhaolong on 2017/9/6.
 */

public final class OkhttpUtils {

    private static int TIMEOUT_READ = 60;
    private static int TIMEOUT_CONNECTION = 60;
    private static Cache cache;
    private static boolean mPrint = false;
    private static boolean mIsRetry = false;


    private static String mBaseUrl;
    private static OkhttpUtils mInstance;


    private OkhttpUtils() {
    }

    public static OkhttpUtils initOkhttp() {
        if (mInstance == null) {
            synchronized (OkhttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new OkhttpUtils();
                }
            }
        }
        return mInstance;
    }

    public OkhttpUtils setBaseUrl(String baseUrl) {
        mBaseUrl = baseUrl;
        return this;
    }

    public OkhttpUtils setCacheSize(Context context, int size) {
        cache = new Cache(context.getCacheDir(), size);
        return this;
    }

    public void printLog(boolean print) {
        mPrint = print;
    }

    static String getBaseUrl() {
        return mBaseUrl;
    }

    public OkhttpUtils setReadTimeOut(int seconds) {
        TIMEOUT_READ = seconds;
        return this;
    }

    public OkhttpUtils setConnectionTimeOut(int seconds) {
        TIMEOUT_CONNECTION = seconds;
        return this;
    }

    /**
     * 是否重连
     *
     * @param isRetry true 为请求失败重连
     * @return 返回本对象
     */
    public OkhttpUtils isRetry(boolean isRetry) {
        mIsRetry = isRetry;
        return this;
    }


    /**
     * 普通请求client
     * @return 返回OKhttpClient对象
     */
    public static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                //必须是设置Cache目录
                .cache(cache)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                //走缓存，两个都要设置
                .addInterceptor(new OnOffLineCachedInterceptor())
                .addNetworkInterceptor(new OnOffLineCachedInterceptor())
                //运行中动态修改baseUrl
                .addInterceptor(new BaseUrlInterceptor())
                //失败重连
                .retryOnConnectionFailure(mIsRetry)
                //time out
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 下载文件的client
     *
     * @param progressListener 进度回调
     * @return 返回本对象
     */
    public static OkHttpClient getDownFileClient(ProgressResponseListener progressListener) {
        return new OkHttpClient.Builder()
                //运行中动态修改baseUrl
//                .addInterceptor(new BaseUrlInterceptor())
                .addInterceptor(new DownFileInterceptor(progressListener))
                .build();
    }
}
