package com.net.chl.okhttplibrary.view;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.net.chl.okhttplibrary.R;
import com.net.chl.okhttplibrary.model.ResultBean;
import com.net.chl.okhttplibrary.model.WeatherBean;
import com.net.chl.okhttplibrary.net.RequestMethodManager;
import com.net.chl.okhttplibrary.net.ResultCallback;

import java.io.File;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mRequestBtn;
    private TextView mResultTv;
    private EditText mCityNameTv;

//    private String apkUrl="http://zhibo.38.hn/appxz/乐创云客1.1.1.apk";
    private String apkUrl="http://p0.so.qhimgs1.com/bdr/326__/t01355d8ee1fecdb8e4.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addListener();
    }

    private void initView() {
        mRequestBtn = findViewById(R.id.requestBtn);
        mResultTv = findViewById(R.id.resultTv);
        mCityNameTv=findViewById(R.id.cityNameTv);
    }

    private void addListener() {
        mRequestBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.requestBtn:

                // 所需的全部权限
                String[] PERMISSIONS = new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                };
                Acp.getInstance(this).request(new AcpOptions.Builder().setPermissions(PERMISSIONS).build(), new AcpListener() {
                    @Override
                    public void onGranted() {
//                        RequestMethodManager.getInstance().downAPK("http://zhibo.38.hn/appxz/乐创云客1.1.1.apk", "demo", "apk", new ProgressResponseListener() {
//                            @Override
//                            public void onResponseProgress(long readByte, long contentLength, boolean done) {
////                                Log.d("MainActiivty", done+"");
//                                if (done){
//                                    installApk();
//                                }
//                            }
//                        });
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                    }
                });

                String cityName=mCityNameTv.getText().toString();

                RequestMethodManager.getInstance().getWeather(cityName, new ResultCallback<ResultBean<WeatherBean>>() {
                    @Override
                    public void success(ResultBean<WeatherBean> weatherBeanResultBean) {
                        mResultTv.setText(weatherBeanResultBean.message);
                    }

                    @Override
                    public void filed(String type, String msg) {

                    }
                });
                break;
                default:
        }
    }

    private void installApk() {
        String apkPath= Environment.getExternalStorageDirectory()+"/"+"demo"+"/"+"apk";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= 24) { //适配安卓7.0
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri apkFileUri = FileProvider.getUriForFile(this,
                    getPackageName()+".fileprovider", new File(apkPath));
            intent.setDataAndType(apkFileUri, "application/vnd.android.package-archive");
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.parse("file://" + apkPath.toString()),
                    "application/vnd.android.package-archive");// File.toString()会返回路径信息
//            SDPackageUtil.installApkPackage(apkPath);
        }
        startActivity(intent);
    }
}
