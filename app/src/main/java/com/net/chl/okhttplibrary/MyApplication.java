package com.net.chl.okhttplibrary;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.net.chl.mylibrary.OkhttpUtils;


/**
 * Created by Administrator on 2018/3/12.
 */

public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        RePlugin.App.attachBaseContext(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        RePlugin.App.onCreate();
        initOkhttp();
    }

    private void initOkhttp() {
        OkhttpUtils.initOkhttp().setBaseUrl(HttpApi.baseUrl).printLog(true);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        /* Not need to be called if your application's minSdkVersion > = 14 */
//        RePlugin.App.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        /* Not need to be called if your application's minSdkVersion > = 14 */
//        RePlugin.App.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);

        /* Not need to be called if your application's minSdkVersion > = 14 */
//        RePlugin.App.onConfigurationChanged(config);
    }

}
