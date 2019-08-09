package com.example.qiaoyanxiong.resenter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment {


    @BindView(R.id.my_image)
    ImageView myImage;
    @BindView(R.id.my_head)
    CircleImageView myHead;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_reg)
    TextView myReg;
    @BindView(R.id.my_amend)
    TextView myAmend;
    @BindView(R.id.my_imgper)
    ImageView myImgper;
    @BindView(R.id.my_person)
    RelativeLayout myPerson;
    @BindView(R.id.my_imgshop)
    ImageView myImgshop;
    @BindView(R.id.my_shop)
    RelativeLayout myShop;
    @BindView(R.id.my_imgder)
    ImageView myImgder;
    @BindView(R.id.my_order)
    RelativeLayout myOrder;
    @BindView(R.id.my_imgres)
    ImageView myImgres;
    @BindView(R.id.my_ress)
    RelativeLayout myRess;
    @BindView(R.id.my_imgcou)
    ImageView myImgcou;
    @BindView(R.id.my_course)
    RelativeLayout myCourse;
    @BindView(R.id.my_imgtion)
    ImageView myImgtion;
    @BindView(R.id.my_ection)
    RelativeLayout myEction;
    @BindView(R.id.my_imgting)
    ImageView myImgting;
    @BindView(R.id.my_sulting)
    RelativeLayout mySulting;
    @BindView(R.id.my_imgstom)
    ImageView myImgstom;
    @BindView(R.id.my_custom)
    RelativeLayout myCustom;
    @BindView(R.id.my_imgabout)
    ImageView myImgabout;
    @BindView(R.id.my_about)
    RelativeLayout myAbout;
    Unbinder unbinder;

    public MeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void createView() {

    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_my_layout;
    }

}
