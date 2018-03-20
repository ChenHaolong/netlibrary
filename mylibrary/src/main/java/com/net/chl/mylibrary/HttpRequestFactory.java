package com.net.chl.mylibrary;

/**
 * Name SkyEmergencyCenter
 * Created by chenhaolong on 2017/1/23.
 */

public class HttpRequestFactory {

    public static NetRequestManager getRequestManager(){
        return OkHttpManager.getInstence();
    }
}
