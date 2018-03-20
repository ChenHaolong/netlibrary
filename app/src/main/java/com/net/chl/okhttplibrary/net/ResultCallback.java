package com.net.chl.okhttplibrary.net;

/**
 * Created by Administrator on 2018/3/15.
 */

public interface ResultCallback<T> {
    void success(T t);
    void filed(String type, String msg);
}
