package com.net.chl.mylibrary;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * author chenhaolong
 * date 2016/8/16
 */
public class CommResponseCallBack<T> implements Callback<T> {

    private static String TAG = CommResponseCallBack.class.getSimpleName();

    private ResponseCallBack<T> callBack;

    CommResponseCallBack(ResponseCallBack<T> callBack) {
        this.callBack = callBack;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.i(TAG, String.format("请求URL:>>>>%s",call.request().url()));
        callBack.callResponse(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        callBack.onFiled("请求失败", t.getMessage());
        Log.e(TAG, t.fillInStackTrace().toString());
    }
}
