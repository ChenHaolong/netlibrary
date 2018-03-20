package com.net.chl.mylibrary.downfile;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chenhaolong on 2017/9/18.
 */

public class DownFileCallback implements Callback<ResponseBody> {

    private String TAG=DownFileCallback.class.getSimpleName();

    private String mFileName;
    private String mFileDirName;

    public DownFileCallback(String fileDirName, String fileName) {
        mFileDirName=Environment.getExternalStorageDirectory()+"/"+fileDirName;
        mFileName= Environment.getExternalStorageDirectory()+"/"+fileDirName+"/"+fileName;
    }

    @Override
    public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
        if (response.isSuccessful()) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                        writeFile(response.body());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }}).start();

        }else {
//            Print.e(TAG, response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
//        Print.e(TAG, t);
    }

    private void writeFile(ResponseBody responseBody) throws IOException {

        InputStream is = null;
        byte[] buf = new byte[2048];
        int len;
        FileOutputStream fos = null;
        try {
            is = responseBody.byteStream();
            //创建文件夹
            File fileDir=new File(mFileDirName);
            if (!fileDir.exists()){
                fileDir.mkdirs();
            }
            File file = new File(mFileName);
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
        } finally {
            responseBody.close();
            if (is != null) {
                is.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}
