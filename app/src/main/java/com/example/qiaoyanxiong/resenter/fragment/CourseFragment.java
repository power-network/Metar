package com.example.qiaoyanxiong.resenter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment {


    private View view;
    /**
     * 课程
     */
    private TextView mTvTitle;
    private RecyclerView mRecly;

    public CourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_book,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mRecly = (RecyclerView) view.findViewById(R.id.recly);

        mRecly.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecly.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));


    }
}
