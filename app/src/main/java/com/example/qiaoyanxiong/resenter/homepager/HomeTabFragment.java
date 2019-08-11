package com.example.qiaoyanxiong.resenter.homepager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.homeadapter.HomeAdapter;
import com.example.qiaoyanxiong.resenter.homebean.HomeBean;
import com.example.qiaoyanxiong.resenter.homebean.UTypeBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTabFragment extends Fragment {


    private View view;
    private RecyclerView mHomeLv;
    private List<UTypeBean.ZTypeBean> list;
    private HomeAdapter adapter;

    public HomeTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home_tab, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mHomeLv = (RecyclerView) inflate.findViewById(R.id.home_lv);

        Bundle arguments = getArguments();
         list = (List<UTypeBean.ZTypeBean>) arguments.getSerializable("list");
        initData();
    }

    private void initData() {
        mHomeLv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HomeAdapter(getActivity(), list);
        mHomeLv.setAdapter(adapter);
    }
}
