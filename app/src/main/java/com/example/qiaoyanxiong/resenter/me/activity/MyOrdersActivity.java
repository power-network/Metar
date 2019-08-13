package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;

public class MyOrdersActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mNoticeRetu;
    private Toolbar mNotab;
    private RecyclerView mOrdrecy;
    /**
     * 新建地址
     */
    private TextView mOrderRess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        initView();
    }

    private void initView() {
        mNoticeRetu = (TextView) findViewById(R.id.notice_retu);
        mNoticeRetu.setOnClickListener(this);
        mNotab = (Toolbar) findViewById(R.id.notab);
        mOrdrecy = (RecyclerView) findViewById(R.id.ordrecy);
        mOrderRess = (TextView) findViewById(R.id.order_ress);
        mOrderRess.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.notice_retu:
                break;
            case R.id.order_ress:
                break;
        }
    }
}
