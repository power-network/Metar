package com.example.qiaoyanxiong.resenter.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.fragment.BankFragment;
import com.example.qiaoyanxiong.resenter.fragment.CourseFragment;
import com.example.qiaoyanxiong.resenter.fragment.ForumFragment;
import com.example.qiaoyanxiong.resenter.fragment.MeFragment;
import com.example.qiaoyanxiong.resenter.fragment.ShopFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_toolbar)
    Toolbar mtab;
    private TabLayout mMainTabLayout;
    private FrameLayout mMainFragment;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        //注释
    }

    private void initView() {
        mMainTabLayout = (TabLayout) findViewById(R.id.main_tab_layout);
        mMainFragment = (FrameLayout) findViewById(R.id.main_fragment);

        initToobler();

        initAddTabName();

        addFragments();

        showFragment();

        initTabSelectFragments();
    }

    private void initToobler() {
        setSupportActionBar(mtab);
        mtab.setTitle("");
    }

    private void initTabSelectFragments() {
        mMainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        switchFragment(0);
                        break;
                    case 1:
                        switchFragment(1);
                        break;
                    case 2:
                        switchFragment(2);
                        break;
                    case 3:
                        switchFragment(3);
                        break;
                    case 4:
                        switchFragment(4);
                        mtab.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void showFragment() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_fragment, fragments.get(0));
        transaction.commit();
    }

    private void addFragments() {
        fragments = new ArrayList<>();
        fragments.add(new BankFragment());
        fragments.add(new ShopFragment());
        fragments.add(new CourseFragment());
        fragments.add(new ForumFragment());
        fragments.add(new MeFragment());
    }

    private void initAddTabName() {
        mMainTabLayout.addTab(mMainTabLayout.newTab().setText(R.string.bank).setIcon(R.drawable.bankselect));
        mMainTabLayout.addTab(mMainTabLayout.newTab().setText(R.string.shop).setIcon(R.drawable.shopselect));
        mMainTabLayout.addTab(mMainTabLayout.newTab().setText(R.string.course).setIcon(R.drawable.courseselect));
        mMainTabLayout.addTab(mMainTabLayout.newTab().setText(R.string.forum).setIcon(R.drawable.forumselect));
        mMainTabLayout.addTab(mMainTabLayout.newTab().setText(R.string.me).setIcon(R.drawable.bankselect));
    }

    private int last;

    private void switchFragment(int type) {
        Fragment fragment = fragments.get(type);
        Fragment lastFragment = fragments.get(last);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.main_fragment, fragment);
        }
        transaction.show(fragment);
        transaction.hide(lastFragment);
        transaction.commit();
        last = type;
    }

}
