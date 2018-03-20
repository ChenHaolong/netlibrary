package com.net.chl.okhttplibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/3/12.
 */

public class ResultBean<T> {

    public int status;
    public String message;
    public T data;

    @Override
    public String toString() {
        return "BaseBean [msg=" + message + ", code=" + status + ", result=" + data + "]";
    }
}
