package com.example.qiaoyanxiong.resenter.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.activity.PhotoActivity;
import com.example.qiaoyanxiong.resenter.api.MyShopService;
import com.example.qiaoyanxiong.resenter.app.MyApp;
import com.example.qiaoyanxiong.resenter.app.SharedPreferencesUtil;
import com.example.qiaoyanxiong.resenter.me.activity.AddRessActivity;
import com.example.qiaoyanxiong.resenter.me.activity.BookingCarActivity;
import com.example.qiaoyanxiong.resenter.me.activity.CollectActivity;
import com.example.qiaoyanxiong.resenter.me.activity.ConsultActivity;
import com.example.qiaoyanxiong.resenter.me.activity.CoursesActivity;
import com.example.qiaoyanxiong.resenter.me.activity.LoginActivity;
import com.example.qiaoyanxiong.resenter.me.activity.MyNoticeActivity;
import com.example.qiaoyanxiong.resenter.me.activity.MyOrdersActivity;
import com.example.qiaoyanxiong.resenter.me.activity.PersonActivity;
import com.example.qiaoyanxiong.resenter.me.activity.RegardActivity;
import com.example.qiaoyanxiong.resenter.me.activity.RelationActivity;
import com.example.qiaoyanxiong.resenter.me.activity.WebViewActivity;
import com.example.qiaoyanxiong.resenter.me.bean.InfoBean;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView mMyImage;
    private CircleImageView mMyHead;
    /**  */
    private TextView mMyName;
    /**
     * 预报名：
     */
    private TextView mMyReg;
    /**
     * 修改
     */
    private TextView mMyAmend;
    private ImageView mMyImgper;
    private RelativeLayout mMyPerson;
    private ImageView mMyImgshop;
    private RelativeLayout mMyShop;
    private ImageView mMyImgder;
    private RelativeLayout mMyOrder;
    private ImageView mMyImgres;
    private RelativeLayout mMyRess;
    private ImageView mMyImgcou;
    private RelativeLayout mMyCourse;
    private ImageView mMyImgtion;
    private RelativeLayout mMyEction;
    private ImageView mMyImgting;
    private RelativeLayout mMySulting;
    private ImageView mMyImgstom;
    private RelativeLayout mMyCustom;
    private ImageView mMyImgabout;
    private RelativeLayout mMyAbout;
    /**
     * 登录
     */
    private TextView mMyLoga;
    private String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mMyImage = (ImageView) view.findViewById(R.id.my_image);
        mMyImage.setOnClickListener(this);
        mMyHead = (CircleImageView) view.findViewById(R.id.my_head);
        mMyHead.setOnClickListener(this);
        mMyName = (TextView) view.findViewById(R.id.my_name);
        mMyReg = (TextView) view.findViewById(R.id.my_reg);
        mMyAmend = (TextView) view.findViewById(R.id.my_amend);
        mMyAmend.setOnClickListener(this);
        mMyImgper = (ImageView) view.findViewById(R.id.my_imgper);
        mMyImgshop = (ImageView) view.findViewById(R.id.my_imgshop);
        mMyImgder = (ImageView) view.findViewById(R.id.my_imgder);
        mMyImgres = (ImageView) view.findViewById(R.id.my_imgres);
        mMyImgcou = (ImageView) view.findViewById(R.id.my_imgcou);
        mMyImgtion = (ImageView) view.findViewById(R.id.my_imgtion);
        mMyImgting = (ImageView) view.findViewById(R.id.my_imgting);
        mMyImgstom = (ImageView) view.findViewById(R.id.my_imgstom);
        mMyImgabout = (ImageView) view.findViewById(R.id.my_imgabout);
        mMyPerson = (RelativeLayout) view.findViewById(R.id.my_person);
        mMyPerson.setOnClickListener(this);
        mMyShop = (RelativeLayout) view.findViewById(R.id.my_shop);
        mMyShop.setOnClickListener(this);
        mMyOrder = (RelativeLayout) view.findViewById(R.id.my_order);
        mMyOrder.setOnClickListener(this);
        mMyRess = (RelativeLayout) view.findViewById(R.id.my_ress);
        mMyRess.setOnClickListener(this);
        mMyCourse = (RelativeLayout) view.findViewById(R.id.my_course);
        mMyCourse.setOnClickListener(this);
        mMyEction = (RelativeLayout) view.findViewById(R.id.my_ection);
        mMyEction.setOnClickListener(this);
        mMySulting = (RelativeLayout) view.findViewById(R.id.my_sulting);
        mMySulting.setOnClickListener(this);
        mMyCustom = (RelativeLayout) view.findViewById(R.id.my_custom);
        mMyCustom.setOnClickListener(this);
        mMyAbout = (RelativeLayout) view.findViewById(R.id.my_about);
        mMyAbout.setOnClickListener(this);
        mMyLoga = (TextView) view.findViewById(R.id.my_loga);
        mMyLoga.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!TextUtils.isEmpty(MyApp.access_token)){
            initData();
        }
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(MyShopService.courUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyShopService.class)
                .testmepre("Bearer " + MyApp.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("qiao", "onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(InfoBean infoBean) {
                        if (infoBean.ret.equals("200")) {
                            InfoBean.Info info = infoBean.info;
                            MyApp.id = info.id;
                            MyApp.u_name = info.u_name;
                            MyApp.u_pic = info.u_pic;
                            if (!TextUtils.isEmpty(info.yu_bao_xiao_url)){
                                url = info.yu_bao_xiao_url;
                            }
                            if (!TextUtils.isEmpty(info.u_name)){
                                mMyName.setText(info.u_name);
                            }
                            if (!TextUtils.isEmpty(info.u_pic)){
                                Glide.with(getActivity()).load(info.u_pic).into(mMyHead);
                            }
                            if (!TextUtils.isEmpty(info.yu_bao_xiao)){
                                mMyReg.setText("预报名：   "+info.yu_bao_xiao);
                            }
                            if (!TextUtils.isEmpty(info.phnoe)){
                                MyApp.phnoe = info.phnoe;
                            }
                            if (!TextUtils.isEmpty(info.yu_bao_time)){
                                MyApp.yu_bao_time = info.yu_bao_time;
                            }
                            if (!TextUtils.isEmpty(info.sex)){
                                MyApp.sex = info.sex;
                            }
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.my_image:
                MyApp.openActivity(getActivity(),MyNoticeActivity.class);
                break;
            case R.id.my_head:
                initpopuwin();
                break;
            case R.id.my_name:
                initpopuwin();
                break;
            case R.id.my_reg:
                if (!TextUtils.isEmpty(MyApp.access_token)){
                    Bundle bundle = new Bundle();
                    bundle.putString("url",url);
                    MyApp.openActivity(getActivity(),WebViewActivity.class,bundle);
                }
                break;
            case R.id.my_person://个人资料
                if (!TextUtils.isEmpty(MyApp.access_token))
                {
                    MyApp.openActivity(getActivity(),PersonActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp.openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_shop://购物车
                if (!TextUtils.isEmpty(MyApp.access_token))
                {
                    MyApp.openActivity(getActivity(),BookingCarActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp.openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_order://我的订单
                if (!TextUtils.isEmpty(MyApp.access_token)|| SharedPreferencesUtil.getSharePreBoolean(getActivity(),"isLogin"))
                {
                    MyApp.openActivity(getActivity(),AddRessActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp .openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_ress://收货地址
                if (!TextUtils.isEmpty(MyApp.access_token)|| SharedPreferencesUtil.getSharePreBoolean(getActivity(),"isLogin"))
                {
                    MyApp.openActivity(getActivity(),MyOrdersActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp .openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_course://我的课程
                if (!TextUtils.isEmpty(MyApp.access_token)|| SharedPreferencesUtil.getSharePreBoolean(getActivity(),"isLogin"))
                {
                    MyApp.openActivity(getActivity(),CollectActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp .openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_ection://我的收藏
                if (!TextUtils.isEmpty(MyApp.access_token)|| SharedPreferencesUtil.getSharePreBoolean(getActivity(),"isLogin"))
                {
                    MyApp.openActivity(getActivity(),CoursesActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp .openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_sulting://在线咨询
                if (!TextUtils.isEmpty(MyApp.access_token)|| SharedPreferencesUtil.getSharePreBoolean(getActivity(),"isLogin"))
                {
                    MyApp.openActivity(getActivity(),ConsultActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp .openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_custom://联系客服
                if (!TextUtils.isEmpty(MyApp.access_token)|| SharedPreferencesUtil.getSharePreBoolean(getActivity(),"isLogin"))
                {
                    MyApp.openActivity(getActivity(),RelationActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp .openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_about://关于我们
                if (!TextUtils.isEmpty(MyApp.access_token)|| SharedPreferencesUtil.getSharePreBoolean(getActivity(),"isLogin"))
                {
                    MyApp.openActivity(getActivity(),RegardActivity.class);
                }else
                {
                    Toast.makeText(getActivity(),"请进行登录",Toast.LENGTH_LONG).show();
                    MyApp .openActivity(getActivity(),LoginActivity.class);
                }
                break;
            case R.id.my_loga:
                initLogin();
                break;
        }
    }

    private void initname() {

    }

    private void initLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    private void initpopuwin() {

    }

    private void initphoto() {
        startActivity(new Intent(getActivity(),PhotoActivity.class));
    }
}
