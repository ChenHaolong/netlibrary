package com.net.chl.okhttplibrary.net;


import com.net.chl.mylibrary.OkHttpManager;
import com.net.chl.mylibrary.downfile.ProgressResponseListener;

/**
 * Created by chenhaolong on 2017/9/8.
 */

public class RequestMethodManager {

    private static RequestMethodManager methodManager;
    private OkHttpManager httpManager;
    private ApiStores apiStores;

    private RequestMethodManager() {
        httpManager = OkHttpManager.getInstence();
        apiStores = httpManager.getApi().create(ApiStores.class);
    }

    public static RequestMethodManager getInstance() {
        synchronized (RequestMethodManager.class) {
            if (methodManager == null) {
                methodManager = new RequestMethodManager();
            }
        }
        return methodManager;
    }

    @SuppressWarnings("unchecked")
    public void getWeather(String cityName, ResultCallback callback) {
        httpManager.get(apiStores.getWeather(cityName), new ResponseCallback(callback));
    }

    /**
     * apk升級
     */
    public void downAPK(String url, String fileDir, String fileName, ProgressResponseListener progressListener) {

        httpManager.downFile((httpManager.getDownFileApi(progressListener).create(ApiStores.class)).downAPK(url), fileDir, fileName);
    }

    /**
     *
     * gradlew clean build bintrayUpload -PbintrayUser=chenhaolong -PbintrayKey=d03d5ec40bcfc4856d1df0a66a1e21a6ddc9569d -PdryRun=true
     *
     */

}
