package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;

public class BookingCarActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mNoticeRetu;
    private RelativeLayout mRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_car);
        initView();
    }

    private void initView() {
        mNoticeRetu = (TextView) findViewById(R.id.notice_retu);
        mNoticeRetu.setOnClickListener(this);
        mRl = (RelativeLayout) findViewById(R.id.rl);
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
