package com.example.qiaoyanxiong.resenter.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.adapter.VpShopAdapter;
import com.example.qiaoyanxiong.resenter.shop.fragment.AllFragment;
import com.example.qiaoyanxiong.resenter.shop.fragment.BookFragment;
import com.example.qiaoyanxiong.resenter.shop.fragment.ClassFragment;

import java.util.ArrayList;

/**
 * 李玉爽
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {


    private View view;
    private TabLayout mShopTabLayout;
    private ViewPager mShopViewPage;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;
    private VpShopAdapter adapter;

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shop, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mShopTabLayout = (TabLayout) inflate.findViewById(R.id.shop_tab_layout);
        mShopViewPage = (ViewPager) inflate.findViewById(R.id.shop_view_page);

        initAddFragmentTitles();

        adapter = new VpShopAdapter(getChildFragmentManager(), fragments, title);
        mShopViewPage.setAdapter(adapter);

        mShopTabLayout.setupWithViewPager(mShopViewPage);
    }

    private void initAddFragmentTitles() {
        fragments = new ArrayList<>();
        fragments.add(new AllFragment());
        fragments.add(new BookFragment());
        fragments.add(new ClassFragment());

        title = new ArrayList<>();
        title.add("全部");
        title.add("图书");
        title.add("课程");
    }
}
