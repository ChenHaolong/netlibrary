package com.net.chl.okhttplibrary.net;

import com.net.chl.mylibrary.ResponseCallBack;
import com.net.chl.okhttplibrary.model.ResultBean;

import retrofit2.Response;

/**
 * Created by Administrator on 2018/3/15.
 */

public class ResponseCallback<T> implements ResponseCallBack<T> {
    private String TAG=getClass().getSimpleName();
    private ResultCallback<T> callback;

    public ResponseCallback(ResultCallback<T> callback){
        this.callback=callback;
    }

    @Override
    public void callResponse(Response<T> response) {
        if (response.isSuccessful()) {
            T t = response.body();
            if (t instanceof ResultBean) {
                ResultBean bean = (ResultBean) t;
                if (bean.status == 200) {
                    callback.success(t);
                } else {
                    callback.filed("请求失败", "");
                }
            }
        } else {
            callback.filed("请求错误", "");
        }
    }

    @Override
    public void onFiled(String type, String msg) {
        callback.filed(type, msg);
    }

}
