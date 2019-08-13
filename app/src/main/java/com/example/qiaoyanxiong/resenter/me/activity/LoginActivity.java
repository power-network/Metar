package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.activity.EditInfoActivity;
import com.example.qiaoyanxiong.resenter.activity.MainActivity;
import com.example.qiaoyanxiong.resenter.api.MyShopService;
import com.example.qiaoyanxiong.resenter.app.MyApp;
import com.example.qiaoyanxiong.resenter.app.SharedPreferencesUtil;
import com.example.qiaoyanxiong.resenter.me.bean.UserLoginBean;
import com.example.qiaoyanxiong.resenter.utils.StrCallback;
import com.zhy.http.okhttp.OkHttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private View view_quick, view_pass;
    private LinearLayout ll_quick, ll_pass;
    //快速登录
    private EditText et_quick_phone, et_quick_code;

    private EditText et_phone;
    private EditText et_pass;
    private TextView tv_quick_get_code;
    private ImageView mIvBack;
    /**
     * 手机号快速登录
     */
    private TextView mTvQuickLogin;
    /**
     * 账号密码登录
     */
    private TextView mTvPassLogin;
    /**
     * 获取验证码
     */
    private TextView mTvQuickGetCode;
    /**
     * 登录
     */
    private TextView mTvSubmitQuickLogin;
    /**
     * 用户注册
     */
    private TextView mTvQuickRegister;
    /**
     * 登录
     */
    private TextView mTvLogin;
    /**
     * 忘记密码
     */
    private TextView mTvFindPass;
    /**
     * 用户注册
     */
    private TextView mTvRegister;
    /**
     * +86
     */
    private TextView mTxt1;
    /**
     * 请输入手机号
     */
    private EditText mEtQuickPhone;
    /**
     * 请输入验证码
     */
    private EditText mEtQuickCode;
    /**
     * 请输入用户名/手机号
     */
    private EditText mEtPhone;
    /**
     * 请输入密码
     */
    private EditText mEtPass;

    private String quickphone;
    private String quickcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mTvQuickLogin = (TextView) findViewById(R.id.tv_quick_login);
        mTvQuickLogin.setOnClickListener(this);
        view_quick = (View) findViewById(R.id.view_quick);
        view_pass = (View) findViewById(R.id.pos_view);
        mIvBack.setOnClickListener(this);
        mTvPassLogin = (TextView) findViewById(R.id.tv_pass_login);
        tv_quick_get_code = (TextView) findViewById(R.id.tv_quick_get_code);
        mTvSubmitQuickLogin = (TextView) findViewById(R.id.tv_submit_quick_login);
        mTvQuickRegister = (TextView) findViewById(R.id.tv_quick_register);
        mTvLogin = (TextView) findViewById(R.id.tv_login);
        mTvFindPass = (TextView) findViewById(R.id.tv_find_pass);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        view_quick = (View) findViewById(R.id.view_quick);
        mTvPassLogin.setOnClickListener(this);
        view_pass = (View) findViewById(R.id.view_pass);
        mTxt1 = (TextView) findViewById(R.id.txt1);
        et_quick_phone = (EditText) findViewById(R.id.et_quick_phone);
        et_quick_code = (EditText) findViewById(R.id.et_quick_code);
        tv_quick_get_code.setOnClickListener(this);
        mTvSubmitQuickLogin.setOnClickListener(this);
        mTvQuickRegister.setOnClickListener(this);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pass = (EditText) findViewById(R.id.et_pass);
        mTvLogin.setOnClickListener(this);
        mTvFindPass.setOnClickListener(this);
        mTvRegister.setOnClickListener(this);
        ll_quick = (LinearLayout) findViewById(R.id.ll_quick);
        ll_pass = (LinearLayout) findViewById(R.id.ll_pass);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv_quick_get_code.setText("获取验证码");
    }

    Handler getHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    timesl = 0;
                    tv_quick_get_code.setText("获取验证码");
                    handler.removeCallbacks(runnable);
                    break;
            }

        }
    };

    private long timesl = 0;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            timesl = timesl - 100;
            if (timesl > 0) {
                //倒计时展示效果
                tv_quick_get_code.setText(timesl / 1000 + "秒重新获取");
                //每秒执行一次
                handler.postDelayed(this, 1000);
            } else {
                //倒计时结束，处理业务逻辑
                //发送信息，结束倒计时
                Message message = new Message();
                message.what = 1;
                getHandler.sendMessage(message);
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_quick_login:
                view_pass.setVisibility(View.GONE);
                view_quick.setVisibility(View.VISIBLE);
                ll_pass.setVisibility(View.GONE);
                ll_quick.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_pass_login:
                view_pass.setVisibility(View.VISIBLE);
                view_quick.setVisibility(View.GONE);
                ll_pass.setVisibility(View.VISIBLE);
                ll_quick.setVisibility(View.GONE);
                break;
            case R.id.tv_quick_get_code:
                quickphone = et_quick_phone.getText().toString();
                if (TextUtils.isEmpty(quickphone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                timesl = 60000;
                handler.postDelayed(runnable, 0);
                getCodes(quickphone);
                break;
            case R.id.tv_submit_quick_login:
                quickphone = et_quick_phone.getText().toString();
                if (TextUtils.isEmpty(quickphone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                quickcode = et_quick_code.getText().toString();
                if (TextUtils.isEmpty(quickcode)) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                quickcodes(quickphone, quickcode);
                break;
            case R.id.tv_quick_register:
                timesl = 0;
                handler.removeCallbacks(runnable);
                MyApp.openActivity(this, RegisterActivity.class);
                break;
            case R.id.tv_login:
                String phone = et_phone.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                String pass = et_pass.getText().toString();
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                submit(phone, pass);
                break;
            case R.id.tv_find_pass:
                MyApp.openActivity(this, FindPassActivity.class);
                break;
            case R.id.tv_register:
                handler.removeCallbacks(runnable);
                MyApp.openActivity(this, RegisterActivity.class);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    private void submit(final String phone, final String pass) {
        new Retrofit.Builder()
                .baseUrl(MyShopService.courUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MyShopService.class)
                .testLogin(phone,pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("qiao", "onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(UserLoginBean userLoginBean) {
                        if (userLoginBean.ret.equals("200")) {
                            MyApp.id = userLoginBean.info.user_info.id;
                            MyApp.pass = userLoginBean.info.user_info.pass;
                            MyApp.u_name = userLoginBean.info.user_info.u_name;
                            MyApp.u_pic = userLoginBean.info.user_info.u_pic;
                            MyApp.phnoe = userLoginBean.info.user_info.phnoe;
                            MyApp.sex = userLoginBean.info.user_info.sex;
                            MyApp.yu_bao_ming = userLoginBean.info.user_info.yu_bao_ming;
                            MyApp.xinxi = userLoginBean.info.user_info.xinxi;

                            MyApp.access_token = userLoginBean.info.token.access_token;
                            MyApp.expires = userLoginBean.info.token.expires;
                            MyApp.refreshTokenExpires = userLoginBean.info.token.refreshTokenExpires;
                            MyApp.refresh_token = userLoginBean.info.token.refresh_token;
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "phone", phone);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "isLogin", true);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "u_name", userLoginBean.info.user_info.u_name);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "u_pic", userLoginBean.info.user_info.u_pic);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "access_token", userLoginBean.info.token.access_token);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "expires", userLoginBean.info.token.expires);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "refresh_token", userLoginBean.info.token.refresh_token);
                            if (TextUtils.isEmpty(userLoginBean.info.user_info.yu_bao_ming)) {
                                MyApp.openActivity(LoginActivity.this, EditInfoActivity.class);
                            } else {
                                MyApp.openActivity(LoginActivity.this, MainActivity.class);
                                finish();
                            }
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "pass", pass);
                        } else {
                            Toast.makeText(LoginActivity.this, userLoginBean.mas, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("qiao", "onError: " + e.getMessage());
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getCodes(String quickphone) {
        OkHttpUtils.post().url(MyShopService.url + "index.php/paywx/massage")
                .addParams("type", "6")
                .addParams("phnoe", quickphone)
                .build().execute(new StrCallback() {
            @Override
            public void onResponse(String response, int id) {
                super.onResponse(response, id);
                Log.e("短信验证码。。。", response);
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void quickcodes(final String quickphone, String quickcode) {
        new Retrofit.Builder()
                .baseUrl(MyShopService.courUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MyShopService.class)
                .testPhones("1",quickphone,quickcode)
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("qiao", "onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(UserLoginBean userLoginBean) {
                        if (userLoginBean.ret.equals("200")) {
                            MyApp.id = userLoginBean.info.user_info.id;
                            MyApp.pass = userLoginBean.info.user_info.pass;
                            MyApp.u_name = userLoginBean.info.user_info.u_name;
                            MyApp.u_pic = userLoginBean.info.user_info.u_pic;
                            MyApp.phnoe = userLoginBean.info.user_info.phnoe;
                            MyApp.sex = userLoginBean.info.user_info.sex;
                            MyApp.yu_bao_ming = userLoginBean.info.user_info.yu_bao_ming;
                            MyApp.xinxi = userLoginBean.info.user_info.xinxi;

                            MyApp.access_token = userLoginBean.info.token.access_token;
                            MyApp.expires = userLoginBean.info.token.expires;
                            MyApp.refreshTokenExpires = userLoginBean.info.token.refreshTokenExpires;
                            MyApp.refresh_token = userLoginBean.info.token.refresh_token;
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "phone", quickphone);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "isLogin", true);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "u_name", userLoginBean.info.user_info.u_name);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "u_pic", userLoginBean.info.user_info.u_pic);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "access_token", userLoginBean.info.token.access_token);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "expires", userLoginBean.info.token.expires);
                            SharedPreferencesUtil.putSharePre(LoginActivity.this, "refresh_token", userLoginBean.info.token.refresh_token);
                            if (TextUtils.isEmpty(userLoginBean.info.user_info.yu_bao_ming)) {
                                MyApp.openActivity(LoginActivity.this, EditInfoActivity.class);
                            } else {
                                MyApp.openActivity(LoginActivity.this, MainActivity.class);
                                finish();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, userLoginBean.mas, Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("qiao", "onError: " +e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
