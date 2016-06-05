package com.databinding.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Author Yan.
 * Date 16/6/4.
 */
public class BaseApplication extends Application{

    private final String TAG = BaseApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        //配置下关于OKHttp的一些参数
        OkHttpClient mHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor(TAG))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(mHttpClient);
        //初始化下关于Fresco
        Fresco.initialize(getApplicationContext());

    }
}
