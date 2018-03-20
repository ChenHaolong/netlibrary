package com.net.chl.mylibrary;

import retrofit2.Response;

/**
 * Name MyFrame
 * Created by chenhaolong on 2017/1/22.
 */

public interface ResponseCallBack<T> {

    void callResponse(Response<T> response);


    void onFiled(String type, String msg);


}
