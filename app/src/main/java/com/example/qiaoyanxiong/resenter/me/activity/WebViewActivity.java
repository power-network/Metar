package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;

import org.json.JSONException;
import org.json.JSONObject;

public class WebViewActivity extends AppCompatActivity {

    /**
     * 返回
     */
    private TextView mBack;
    private Toolbar mWebtob;
    private WebView mWeb;
    private final String webUrl = "http://59.110.163.144/appoint/aboutus/disPlayDetail?id=";
    private int fales;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        fales = getIntent().getIntExtra("false", -1);

        initView();
        initToobar();
    }

    private void initToobar() {
        setSupportActionBar(mWebtob);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mBack = (TextView) findViewById(R.id.back);
        mWebtob = (Toolbar) findViewById(R.id.webtob);
        mWeb = (WebView) findViewById(R.id.web);

        WebSettings settings = mWeb.getSettings();
        // 设置可以支持缩放
        settings.setSupportZoom(true);
        // 设置支持js
        settings.setJavaScriptEnabled(true);
        // 关闭缓存
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        // 支持自动加载图片
        settings.setLoadsImagesAutomatically(true);
        // 设置出现缩放工具
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        // 扩大比例的缩放
        settings.setUseWideViewPort(true);
        // 自适应屏幕
        settings.setLoadWithOverviewMode(true);

        if (fales == 2) {
            mWeb.setWebViewClient(new WebViewClient());
            mWeb.loadUrl("file:///android_asset/agreement.html");
        }

        url = getIntent().getStringExtra("url");

        mWeb.addJavascriptInterface(new JSNotify(),"huoqu");
        mWeb.loadUrl(url);
    }

    public class JSNotify extends Object {
        @JavascriptInterface
        public void huo_id(String id) {
            //拿到id跳转页面
            Log.e("id---",id);
            try {
                JSONObject obj=new JSONObject(id);
                Bundle bundle=new Bundle();
                bundle.putString("id",obj.getString("id"));
                bundle.putString("name",obj.getString("name"));
                bundle.putString("class_hour",obj.getString("class_hour"));
                bundle.putString("jia_ge",obj.getString("jia_ge"));
                bundle.putString("yuan_jia_ge",obj.getString("yuan_jia_ge"));
                bundle.putString("pic",obj.getString("pic"));
//                MyApplication.openActivity(WebViewActivity.this,ClassDetailActivity.class,bundle);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
