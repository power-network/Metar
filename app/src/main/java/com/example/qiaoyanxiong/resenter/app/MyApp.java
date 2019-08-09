package com.example.qiaoyanxiong.resenter.app;

import android.app.Application;
<<<<<<< HEAD
import android.content.Context;

public class MyApp extends Application {

    private static MyApp myApp;

    public static MyApp getInstance() {
        return myApp;
    }

    public static Context getContext() {
        return null;
    }
=======

public class MyApp extends Application {

    private static MyApp app;
>>>>>>> d5f3668f65337b26bcd60a53cdf64cc9e6a469ae

    @Override
    public void onCreate() {
        super.onCreate();
<<<<<<< HEAD
=======
        app = this;
    }

    public static MyApp getInstance() {
        return app;
>>>>>>> d5f3668f65337b26bcd60a53cdf64cc9e6a469ae
    }
}
