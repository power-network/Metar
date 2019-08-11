package com.example.qiaoyanxiong.resenter.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.qiaoyanxiong.resenter.FragmentUtils;
import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.homepager.HomepagerFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        FragmentUtils.addFragment(manager,HomepagerFragment.class,R.id.fl);
    }
}
