package com.example.qiaoyanxiong.resenter.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MyApp extends Application {

    private static MyApp app;
    public static Context CONTEXT;
    public static boolean isLogin = false;

    /**
     * 通过类名启动Activity
     *
     * @param targetClass
     */
    public static void openActivity(Context context, Class<?> targetClass) {
        openActivity(context, targetClass, null);
    }
    /**
     * 通过类名启动Activity，并且含有Bundle数据
     *
     * @param targetClass
     * @param extras
     */
    public static void openActivity(Context context, Class<?> targetClass,
                                    Bundle extras) {
        Intent intent = new Intent(context, targetClass);
        if (extras != null) {
            intent.putExtras(extras);
        }
        context.startActivity(intent);
    }

    public static String id;
    public static String pass;
    public static String u_name;
    public static String u_pic;
    public static String phnoe;
    public static String sex;
    public static String yu_bao_ming;
    public static String yu_bao_time;
    public static String xinxi;
    public static String time;
    public static String name;

    public static String access_token;
    public static String expires;
    public static String refreshTokenExpires;
    public static String refresh_token;
    public static String header_value="Bearer "+access_token;

    public static boolean isUpdate;

    @Override
    public void onCreate() {
        super.onCreate();
//        AbLog.E = true;
        CONTEXT = getApplicationContext();
        app = this;
        isLogin = SharedPreferencesUtil.getSharePreBoolean(CONTEXT, "isLogin");
        access_token=SharedPreferencesUtil.getSharePreStr(CONTEXT,"access_token");
        id=SharedPreferencesUtil.getSharePreStr(CONTEXT,"userId");
        u_name=SharedPreferencesUtil.getSharePreStr(CONTEXT,"u_name");
        u_pic=SharedPreferencesUtil.getSharePreStr(CONTEXT,"u_pic");
        expires=SharedPreferencesUtil.getSharePreStr(CONTEXT,"expires");
        refresh_token=SharedPreferencesUtil.getSharePreStr(CONTEXT,"refresh_token");

    }

    public static MyApp getInstance() {
        return app;
    }
}
