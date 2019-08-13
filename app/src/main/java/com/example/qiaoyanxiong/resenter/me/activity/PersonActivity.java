package com.example.qiaoyanxiong.resenter.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qiaoyanxiong.resenter.R;
import com.example.qiaoyanxiong.resenter.app.MyApp;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView mImgUsericon;
    private ImageView mIvRight1;
    private RelativeLayout mRelHeader;
    /**  */
    private TextView mTxtNickname;
    private RelativeLayout mRelNickname;
    /**
     * 暂无
     */
    private TextView mTxtSex;
    private RelativeLayout mRelSex;
    /**  */
    private TextView mTxtPhone;
    private RelativeLayout mRelPhone;
    /**  */
    private TextView mTxtChangePass;
    private RelativeLayout mRelChangePass;
    /**  */
    private TextView mTxtTime;
    private RelativeLayout mRelTime;
    /**  */
    private TextView mTxtSchool;
    private RelativeLayout mRelSchool;
    String title = "个人资料";
    /**
     * 返回
     */
    private TextView mNoticeRetu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        initView();
    }


    private void initView() {
        mImgUsericon = (CircleImageView) findViewById(R.id.img_usericon);
        mIvRight1 = (ImageView) findViewById(R.id.iv_right1);
        mRelHeader = (RelativeLayout) findViewById(R.id.rel_header);
        mTxtNickname = (TextView) findViewById(R.id.txt_nickname);
        mRelNickname = (RelativeLayout) findViewById(R.id.rel_nickname);
        mTxtSex = (TextView) findViewById(R.id.txt_sex);
        mRelSex = (RelativeLayout) findViewById(R.id.rel_sex);
        mTxtPhone = (TextView) findViewById(R.id.txt_phone);
        mRelPhone = (RelativeLayout) findViewById(R.id.rel_phone);
        mTxtChangePass = (TextView) findViewById(R.id.txt_change_pass);
        mRelChangePass = (RelativeLayout) findViewById(R.id.rel_change_pass);
        mTxtTime = (TextView) findViewById(R.id.txt_time);
        mRelTime = (RelativeLayout) findViewById(R.id.rel_time);
        mTxtSchool = (TextView) findViewById(R.id.txt_school);
        mRelSchool = (RelativeLayout) findViewById(R.id.rel_school);
        mTxtPhone.setText(MyApp.phnoe);
        if (!TextUtils.isEmpty(MyApp.sex)) {
            if (MyApp.sex.equals("0")) {
                mTxtSex.setText("女");
            } else {
                mTxtSex.setText("男");
            }
        }
        Glide.with(this).load(MyApp.u_pic).into(mImgUsericon);

        if (!TextUtils.isEmpty(MyApp.yu_bao_time)) {
            mTxtTime.setText(MyApp.yu_bao_time);
        }
        mTxtSchool.setText(MyApp.name);
        mNoticeRetu = (TextView) findViewById(R.id.notice_retu);
        mNoticeRetu.setOnClickListener(this);
        mRelNickname.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.notice_retu:
                finish();
                break;
            case R.id.rel_nickname:

                break;
        }
    }
}
