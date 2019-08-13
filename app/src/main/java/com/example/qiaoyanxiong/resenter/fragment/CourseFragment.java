package com.example.qiaoyanxiong.resenter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.course.adapter.CourseAdapter;
import com.example.qiaoyanxiong.resenter.course.bean.GongGaoBean;
import com.example.qiaoyanxiong.resenter.course.bean.KechengBean;
import com.example.qiaoyanxiong.resenter.course.bean.LunboBean;
import com.example.qiaoyanxiong.resenter.course.conter.CourseConter;
import com.example.qiaoyanxiong.resenter.course.presenter.CoursePresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment implements CourseConter.CourseView {


    private View view;
    /**
     * 课程
     */
    private TextView mTvTitle;
    private RecyclerView mRecly;
    private CourseAdapter adapter;
    private CoursePresenter presenter;

    public CourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_book, null);
        initView(view);

        presenter = new CoursePresenter(this);
        presenter.gethttp(1);
        return view;
    }

    private void initView(View view) {
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mRecly = (RecyclerView) view.findViewById(R.id.recly);

        mRecly.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecly.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapter = new CourseAdapter(getActivity());
        mRecly.setAdapter(adapter);


    }


    @Override
    public void showArtSuccess(List<KechengBean> list) {
        adapter.initArt(list);
    }

    @Override
    public void showBannSuccess(List<LunboBean> bannerData, List<GongGaoBean> gongGaoBeans) {
        adapter.initBanner(bannerData, gongGaoBeans);
    }

    @Override
    public void showError(String error) {
        Log.e("qiao", "showError: " + error);
    }
}
