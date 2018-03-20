package com.net.chl.mylibrary;


import com.net.chl.mylibrary.downfile.DownFileCallback;
import com.net.chl.mylibrary.downfile.ProgressResponseListener;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by chenhaolong on 2017/9/8.
 */

public class OkHttpManager<T> implements NetRequestManager<T> {

    private static OkHttpManager okHttpManager;


    private OkHttpManager() {
    }

    public static OkHttpManager getInstence() {
        if (okHttpManager == null) {
            synchronized (OkHttpManager.class) {
                okHttpManager = new OkHttpManager();
            }
        }
        return okHttpManager;
    }

    public Retrofit getApi(){
        return RetrofitUtils.INSTANCE.getRetrofit();
    }

    public Retrofit getDownFileApi(ProgressResponseListener progressListener){
        return RetrofitUtils.INSTANCE.getDownFileRetrofit(progressListener);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void get(Call call, ResponseCallBack<T> callBack) {
        call.enqueue(new CommResponseCallBack(callBack));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void post(Call call, ResponseCallBack<T> callBack) {
        call.enqueue(new CommResponseCallBack(callBack));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void downFile(Call call, String fileDir, String fileName) {
        call.enqueue(new DownFileCallback(fileDir, fileName));
    }

}
