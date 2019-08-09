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
import com.example.qiaoyanxiong.resenter.shop.adapter.RlvBookAdapter;
import com.example.qiaoyanxiong.resenter.shop.bean.BookDataBean;
import com.example.qiaoyanxiong.resenter.utils.BaseObsever;
import com.example.qiaoyanxiong.resenter.utils.HttpManager;
import com.example.qiaoyanxiong.resenter.utils.RxUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {


    private View view;
    private RecyclerView mBookRecycleView;
    private ArrayList<BookDataBean.InfoBean> list;
    private RlvBookAdapter adapter;

    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_book, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        HttpManager.getHttpManager().getApiService(MyShopService.url, MyShopService.class).getBook(1)
                .compose(RxUtils.<BookDataBean>rxScheduleThread())
                .subscribe(new BaseObsever<BookDataBean>() {
                    @Override
                    public void onNext(BookDataBean bookDataBean) {
                        list.addAll(bookDataBean.getInfo());
                        adapter.notifyDataSetChanged();
                    }

                    private static final String TAG = "BookFragment";

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }
                });
    }

    private void initView(View inflate) {
        mBookRecycleView = (RecyclerView) inflate.findViewById(R.id.book_recycle_view);

        mBookRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RlvBookAdapter(getActivity(), list);
        mBookRecycleView.setHasFixedSize(true);
        mBookRecycleView.setAdapter(adapter);
    }
}
