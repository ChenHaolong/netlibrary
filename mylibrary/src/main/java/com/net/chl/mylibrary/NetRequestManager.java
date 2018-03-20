package com.net.chl.mylibrary;

import okhttp3.Response;
import retrofit2.Call;

/**
 * Name SkyEmergencyCenter
 * Created by chenhaolong on 2017/1/22.
 */

public interface NetRequestManager<T> {

    void get(Call call, ResponseCallBack<T> callBack);

    void post(Call call, ResponseCallBack<T> callBack);

    void downFile(Call<Response> call, String fileDir, String fileName);
}
