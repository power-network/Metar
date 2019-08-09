package com.example.qiaoyanxiong.resenter.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.SyncStateContract;


public class HttpUtils {

    public static boolean isNetworkAvailable(Context context){
        if (context != null){
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null){
                return info.isAvailable();
            }
        }
        return false;
    }
//
//    public static void startFragmentInCommonActivity(Context context, int fragmet) {
//        Intent intent = new Intent(context, CommonActivity.class);
//        intent.putExtra(SyncStateContract.Constants.TYPE_FRAGMENT_KEY, fragmet);
//        context.startActivity(intent);
//    }
}
