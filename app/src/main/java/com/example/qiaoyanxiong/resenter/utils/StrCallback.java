package com.example.qiaoyanxiong.resenter.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * okhttpString信息返回重写
 * Created by Slingge on 2017/2/14 0014.
 */

public abstract class StrCallback extends StringCallback {
Context context;
    @Override
    public void onError(Call call, Exception e, int id) {
        Log.e("qiao", "onError: " +e.toString());
        Toast.makeText(context, "网络错误", Toast.LENGTH_SHORT).show();
        String name = context.getPackageName();
        Log.e("qiao", "onError: " +name);
    }

    @Override
    public void onResponse(String response, int id) {
        Log.e("qiao", "onError: " +response);
    }
}
