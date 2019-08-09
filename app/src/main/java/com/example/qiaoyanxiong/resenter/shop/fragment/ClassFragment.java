package com.example.qiaoyanxiong.resenter.shop.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.api.MyShopService;
import com.example.qiaoyanxiong.resenter.shop.adapter.RlvKeChengAdapter;
import com.example.qiaoyanxiong.resenter.shop.bean.KeChengDataBean;
import com.example.qiaoyanxiong.resenter.shop.bean.KechengBean;
import com.example.qiaoyanxiong.resenter.utils.BaseObsever;
import com.example.qiaoyanxiong.resenter.utils.HttpManager;
import com.example.qiaoyanxiong.resenter.utils.RxUtils;
import com.example.qiaoyanxiong.resenter.utils.UnicodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassFragment extends Fragment {


    private View view;
    private RecyclerView mClassRecycleView;
    private List<KeChengDataBean.InfoBean.KechengBean> list;
    private RlvKeChengAdapter adapter;

    public ClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_class, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        HttpManager.getHttpManager().getApiService(MyShopService.url, MyShopService.class).getShop(0, 1)
                .compose(RxUtils.<KeChengDataBean>rxScheduleThread())
                .subscribe(new BaseObsever<KeChengDataBean>() {
                    @Override
                    public void onNext(KeChengDataBean bean) {
                        list.addAll(bean.getInfo().getKecheng());
                        adapter.notifyDataSetChanged();
                    }

                    private static final String TAG = "ClassFragment";

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }
                });
    }

    private static final String TAG = "ClassFragment";

    private void initView(View inflate) {
        mClassRecycleView = (RecyclerView) inflate.findViewById(R.id.class_recycle_view);
        mClassRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RlvKeChengAdapter(getActivity(), list);
        mClassRecycleView.setHasFixedSize(true);
        mClassRecycleView.setAdapter(adapter);
    }
}
