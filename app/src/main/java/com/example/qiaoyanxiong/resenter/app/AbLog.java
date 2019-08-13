package com.example.qiaoyanxiong.resenter.app;

import android.util.Log;

public class AbLog {
    public static Boolean E = true;


    public static void e(String tag, String text) {
        if (E) {
            if (text.length() > 4000) {
                int count = 0;
                for (int i = 0; i < text.length(); i += 4000) {
                    count++;
                    if (i + 4000 < text.length()) {
                        Log.e(tag + count, text.substring(i, i + 4000));
                    } else {
                        Log.e(tag + count, text.substring(i, text.length()));
                    }
                }
            } else
                Log.e(tag, text);
        }
    }

    public static void e2(String text) {
        if (E) {
            if (text.length() > 4000) {
                int count=0;
                for (int i = 0; i < text.length(); i += 4000) {
                    count++;
                    if (i + 4000 < text.length()) {
                        Log.e(MyApp.CONTEXT.getClass().getSimpleName() + count, text.substring(i, i + 4000));
                    } else {
                        Log.e(MyApp.CONTEXT.getClass().getSimpleName() + count, text.substring(i, text.length()));
                    }
                }
            } else
                Log.e(MyApp.CONTEXT.getClass().getSimpleName(), text);
        }
    }
}
