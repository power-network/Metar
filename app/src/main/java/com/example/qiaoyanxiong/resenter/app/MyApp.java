package com.example.qiaoyanxiong.resenter.app;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private static MyApp myApp;

    public static MyApp getInstance() {
        return myApp;
    }

    public static Context getContext() {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
