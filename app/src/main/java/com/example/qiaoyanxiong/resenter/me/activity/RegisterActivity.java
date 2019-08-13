package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.api.MyShopService;
import com.example.qiaoyanxiong.resenter.app.MyApp;
import com.example.qiaoyanxiong.resenter.app.SharedPreferencesUtil;
import com.example.qiaoyanxiong.resenter.me.bean.UserLoginBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;
    /**
     * 请输入手机号
     */
    private EditText mEtPhone;
    /**
     * 请输入验证码
     */
    private EditText mEtCode;
    /**
     * 获取验证码
     */
    private TextView mTvGetCode;
    /**
     * 请输入6-12位密码
     */
    private EditText mEtPass;
    /**
     * 快速注册
     */
    private TextView mTvSubmit;
    /**
     * 我已阅读并接受
     */
    private CheckBox mCheckboxRegister;
    /**  */
    private TextView mTvAgreement;
    private String phone;
    private String code;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtCode = (EditText) findViewById(R.id.et_code);
        mTvGetCode = (TextView) findViewById(R.id.tv_get_code);
        mTvGetCode.setOnClickListener(this);
        mEtPass = (EditText) findViewById(R.id.et_pass);
        mTvSubmit = (TextView) findViewById(R.id.tv_submit);
        mTvSubmit.setOnClickListener(this);
        mCheckboxRegister = (CheckBox) findViewById(R.id.checkbox_register);
        mTvAgreement = (TextView) findViewById(R.id.tv_agreement);
        mTvAgreement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_get_code:
                phone = mEtPhone.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_LONG).show();
                    return;
                }
                getCodes(phone);
                break;
            case R.id.tv_submit:
                code = mEtCode.getText().toString();
                pass = mEtPass.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!mCheckboxRegister.isChecked()) {
                    Toast.makeText(this, "请阅读并同意医研梦注册条款", Toast.LENGTH_LONG).show();
                    return;
                }
                if (pass.length() < 6 || pass.length() > 12) {
                    Toast.makeText(this, "请输入6-12位密码", Toast.LENGTH_LONG).show();
                    return;
                }
                submit(phone, code, pass);
                break;
            case R.id.tv_agreement:
                Bundle bundle = new Bundle();
                bundle.putInt("false", 2);
                MyApp.openActivity(this, WebViewActivity.class);
                break;
        }
    }

    private void submit(final String phone, String code, final String pass) {
        new Retrofit.Builder()
                .baseUrl(MyShopService.courUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MyShopService.class)
                .testResaig("1",phone,code,pass)
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("qiao", "onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(UserLoginBean userLoginBean) {
                        String ret = userLoginBean.ret;
                        if (ret.equals("200")){
                            MyApp.openActivity(RegisterActivity.this,LoginActivity.class);
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
                            SharedPreferencesUtil.putSharePre(RegisterActivity.this, "phone", phone);
                            SharedPreferencesUtil.putSharePre(RegisterActivity.this, "isLogin", true);
                            SharedPreferencesUtil.putSharePre(RegisterActivity.this, "u_name", userLoginBean.info.user_info.u_name);
                            SharedPreferencesUtil.putSharePre(RegisterActivity.this, "u_pic", userLoginBean.info.user_info.u_pic);
                            SharedPreferencesUtil.putSharePre(RegisterActivity.this, "access_token", userLoginBean.info.token.access_token);
                            SharedPreferencesUtil.putSharePre(RegisterActivity.this, "expires", userLoginBean.info.token.expires);
                            SharedPreferencesUtil.putSharePre(RegisterActivity.this, "refresh_token", userLoginBean.info.token.refresh_token);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("qiao", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getCodes(String phone) {
        new Retrofit.Builder()
                .baseUrl(MyShopService.courUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MyShopService.class)
                .testRegis(phone,"1")
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("qiao", "onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(UserLoginBean userLoginBean) {
                        if (userLoginBean.ret.equals("200")){
                            Toast.makeText(RegisterActivity.this, "验证码发送成功", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, userLoginBean.mas, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("qiao", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
