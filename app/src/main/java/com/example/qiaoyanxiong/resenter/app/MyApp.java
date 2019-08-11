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


public class MyApp extends Application {

    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static MyApp getInstance() {
        return app;
    }
}
