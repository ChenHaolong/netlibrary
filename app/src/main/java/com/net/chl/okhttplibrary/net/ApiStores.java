package com.net.chl.okhttplibrary.net;


import com.net.chl.okhttplibrary.model.ResultBean;
import com.net.chl.okhttplibrary.model.WeatherBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 搜有的请求类
 * Created by chenhaolong on 2017/9/8.
 */

public interface ApiStores{
    @GET("/open/api/weather/json.shtml?")
    Call<ResultBean<WeatherBean>> getWeather(@Query("city") String cityname);

    @Streaming
    @GET
    Call<ResponseBody> downAPK(@Url String url);
}
