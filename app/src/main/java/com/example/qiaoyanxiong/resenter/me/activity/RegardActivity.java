package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;

public class RegardActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mNoticeRetu;
    private Toolbar mNotab;
    private WebView mReweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regard);
        initView();
    }

    private void initView() {
        mNoticeRetu = (TextView) findViewById(R.id.notice_retu);
        mNoticeRetu.setOnClickListener(this);
        mNotab = (Toolbar) findViewById(R.id.notab);
        mReweb = (WebView) findViewById(R.id.reweb);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.notice_retu:
                finish();
                break;
        }
    }
}
