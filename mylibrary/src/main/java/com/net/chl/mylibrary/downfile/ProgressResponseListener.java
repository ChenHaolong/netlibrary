package com.net.chl.mylibrary.downfile;

/**
 * Name SkyEmergencyCenter
 * Created by chenhaolong on 2017/2/7.
 */

public interface ProgressResponseListener {

    void onResponseProgress(long readByte, long contentLength, boolean done);
}
