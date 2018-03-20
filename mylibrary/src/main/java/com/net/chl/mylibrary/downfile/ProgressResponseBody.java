package com.net.chl.mylibrary.downfile;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by chenhaolong on 2017/9/15.
 */

public class ProgressResponseBody extends ResponseBody {

    //实体相应
    private final ResponseBody responseBody;
    //实体操作进度回调
    private final ProgressResponseListener progressListener;
    //读取的数据包装
    private BufferedSource bufferedSource;
    private long totalBytesRead;


    public ProgressResponseBody(ResponseBody responseBody, ProgressResponseListener responseListener) {
        this.responseBody = responseBody;
        this.progressListener = responseListener;
    }

    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    /**包装返回的实体*/
    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            //包装
            bufferedSource = Okio.buffer(source(responseBody.source()));
        }
        return bufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                //增加当前读取的字节数，如果读取完成了bytesRead会返回-1
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                //回调，如果contentLength()不知道长度，会返回-1
                progressListener.onResponseProgress(totalBytesRead, contentLength(), bytesRead == -1);
                return bytesRead;
            }
        };
    }

    public void setTotalBytesRead(long downloadSize){
        this.totalBytesRead=downloadSize;
    }
}
