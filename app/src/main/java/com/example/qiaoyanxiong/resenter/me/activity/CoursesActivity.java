package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;

//我的收藏
public class CoursesActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mNoticeRetu;
    private Toolbar mNotab;
    private TableLayout mCourtab;
    private ViewPager mCourvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        initView();
    }

    private void initView() {
        mNoticeRetu = (TextView) findViewById(R.id.notice_retu);
        mNotab = (Toolbar) findViewById(R.id.notab);
        mCourtab = (TableLayout) findViewById(R.id.courtab);
        mCourvp = (ViewPager) findViewById(R.id.courvp);
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
