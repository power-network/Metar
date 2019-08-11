package com.example.qiaoyanxiong.resenter.homepager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.api.MyShopService;
import com.example.qiaoyanxiong.resenter.homeadapter.HomeVpAdapter;
import com.example.qiaoyanxiong.resenter.homebean.HomeBean;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomepagerFragment extends Fragment implements View.OnClickListener {


    private View view;
    /**
     * 今日打卡
     */
    private TextView mTvDaka2;
    private TextView mTvDaojishi;
    private TextView mTvTian1;
    private LinearLayout mLlDaojishi;
    private RelativeLayout mRlTop;
    /**
     * 今日打卡
     */
    private TextView mTvDaka;
    /**
     * 历年考试题
     */
    private RadioButton mRb3;
    /**
     * 模拟考试
     */
    private RadioButton mRb4;
    /**
     * 收藏
     */
    private RadioButton mRb6;
    /**
     * 英语专项练习
     */
    private RadioButton mRb1;
    /**
     * 政治专项练习
     */
    private RadioButton mRb2;
    /**
     * 错题库
     */
    private RadioButton mRb5;
    private LinearLayout mLlCenter;

    private View mView;
    private AppBarLayout mAppBarLayout;
    private ViewPager mViewPager;
    private SlidingTabLayout mTabChannel;
    private ArrayList<String> titles;
    private SparseArray<HomeTabFragment> fragments;
    private HomeTabFragment homeTabFragment;
    private HomeBean homeBean;
    private HomeVpAdapter adapter;

    public HomepagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_homepager, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTvDaka2 = (TextView) inflate.findViewById(R.id.tv_daka2);
        mTvDaojishi = (TextView) inflate.findViewById(R.id.tv_daojishi);
        mTvTian1 = (TextView) inflate.findViewById(R.id.tv_tian_1);
        mLlDaojishi = (LinearLayout) inflate.findViewById(R.id.ll_daojishi);
        mRlTop = (RelativeLayout) inflate.findViewById(R.id.rl_top);
        mTvDaka = (TextView) inflate.findViewById(R.id.tv_daka);
        mRb3 = (RadioButton) inflate.findViewById(R.id.rb_3);
        mRb4 = (RadioButton) inflate.findViewById(R.id.rb_4);
        mRb6 = (RadioButton) inflate.findViewById(R.id.rb_6);
        mRb1 = (RadioButton) inflate.findViewById(R.id.rb_1);
        mRb2 = (RadioButton) inflate.findViewById(R.id.rb_2);
        mRb5 = (RadioButton) inflate.findViewById(R.id.rb_5);
        mLlCenter = (LinearLayout) inflate.findViewById(R.id.ll_center);
        mAppBarLayout = (AppBarLayout) inflate.findViewById(R.id.appBarLayout);
        mViewPager = (ViewPager) inflate.findViewById(R.id.viewPager);
        mTvDaka2.setOnClickListener(this);
        mTvDaojishi.setOnClickListener(this);
        mTvTian1.setOnClickListener(this);
        mLlDaojishi.setOnClickListener(this);
        mRlTop.setOnClickListener(this);
        mTvDaka.setOnClickListener(this);
        mRb3.setOnClickListener(this);
        mRb4.setOnClickListener(this);
        mRb6.setOnClickListener(this);
        mRb1.setOnClickListener(this);
        mRb2.setOnClickListener(this);
        mRb5.setOnClickListener(this);
        mLlCenter.setOnClickListener(this);
        mAppBarLayout.setOnClickListener(this);
        mViewPager.setOnClickListener(this);
        mTabChannel = (SlidingTabLayout) inflate.findViewById(R.id.tab_channel);
        mTabChannel.setOnClickListener(this);
        mView = (View) inflate.findViewById(R.id.view);
        mView.setOnClickListener(this);


        initData();
    }

    private static final String TAG = "HomepagerFragment";

    private void initData() {
        OkHttpClient build1 = new OkHttpClient.Builder()
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("name", "17538256659")
                .add("pass", "wangqing123")
                .build();
        Request request1 = new Request.Builder()
                .post(formBody)
                .url(MyShopService.url + "login/login")
                .build();
        Call call = build1.newCall(request1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    if (jsonObject.getString("ret").equals("200")) {
                        JSONObject jsonObject1 = jsonObject.getJSONObject("info").getJSONObject("token");
                        initData1(jsonObject1.get("access_token"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void initData1(Object access_token) {
        OkHttpClient build = new OkHttpClient.Builder()
                .build();
        Request request = new Request.Builder()
                .addHeader("A-uthorization", "Bearer " + access_token)
                .get()
                .url(MyShopService.url + "Shiti/ti_type_list")
                .build();
        Call call1 = build.newCall(request);
        call1.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    if (jsonObject.getString("ret").equals("200")) {
                        HomeBean homeBean = new Gson().fromJson(string, HomeBean.class);
                        initTab(homeBean);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void initTab(final HomeBean homeBean) {
        titles = new ArrayList<>();
        for (int i = 0; i < homeBean.getInfo().getU_type().size(); i++) {
            titles.add(homeBean.getInfo().getU_type().get(i).getName());
        }

        fragments = new SparseArray<>();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {
                        homeTabFragment = fragments.get(position);
                        if (homeTabFragment != null) {
                            return homeTabFragment;
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("list", (Serializable) homeBean.getInfo().getU_type().get(position).getZ_type());
                            homeTabFragment = new HomeTabFragment();
                            homeTabFragment.setArguments(bundle);
                            fragments.put(position, homeTabFragment);
                            return homeTabFragment;
                        }
                    }

                    @Override
                    public int getCount() {
                        return titles.size();
                    }

                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {
                        return titles.get(position);
                    }
                });
                mTabChannel.setViewPager(mViewPager);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_daka2:
                break;
            case R.id.tv_daojishi:
                break;
            case R.id.tv_tian_1:
                break;
            case R.id.ll_daojishi:
                break;
            case R.id.rl_top:
                break;
            case R.id.tv_daka:
                break;
            case R.id.rb_3:
                break;
            case R.id.rb_4:
                break;
            case R.id.rb_6:
                break;
            case R.id.rb_1:
                break;
            case R.id.rb_2:
                break;
            case R.id.rb_5:
                break;
            case R.id.ll_center:
                break;
            case R.id.appBarLayout:
                break;
            case R.id.viewPager:
                break;
            case R.id.tab_channel:
                break;
            case R.id.view:
                break;
        }
    }
}
