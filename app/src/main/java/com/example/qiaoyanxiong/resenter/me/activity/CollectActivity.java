package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;

public class CollectActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mNoticeRetu;
    private Toolbar mNotab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initView();
    }

    private void initView() {
        mNoticeRetu = (TextView) findViewById(R.id.notice_retu);
        mNotab = (Toolbar) findViewById(R.id.notab);
        mNoticeRetu.setOnClickListener(this);
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
