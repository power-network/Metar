package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.api.MyShopService;
import com.example.qiaoyanxiong.resenter.app.MyApp;
import com.example.qiaoyanxiong.resenter.me.adapter.NoticeAdapter;
import com.example.qiaoyanxiong.resenter.me.bean.NoticeBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyNoticeActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mNotab;
    private RecyclerView mNorecy;
    /**
     * 返回
     */
    private TextView mNoticeRetu;
    private int page = 1;
    private NoticeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notice);
        initView();
        initToobar();
        initData();
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(MyShopService.courUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyShopService.class)
                .testNotice(page + "", "Bearer " + MyApp.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NoticeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("qiao", "onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(NoticeBean noticeBean) {
                        if (noticeBean.ret.equals("200")) {
                            List<NoticeBean.NewsInfo> info = noticeBean.info;
                            adapter.initNoter(info);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("qiao", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initToobar() {
        setSupportActionBar(mNotab);
    }

    private void initView() {
        mNotab = (Toolbar) findViewById(R.id.notab);
        mNorecy = (RecyclerView) findViewById(R.id.norecy);
        mNoticeRetu = (TextView) findViewById(R.id.notice_retu);
        mNoticeRetu.setOnClickListener(this);

        mNorecy.setLayoutManager(new LinearLayoutManager(this));
        mNorecy.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new NoticeAdapter(this);
        mNorecy.setAdapter(adapter);
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
