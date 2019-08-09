package com.example.qiaoyanxiong.resenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qiaoyanxiong.resenter.R;

public class AnimActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBg;
    /**
     * 3s 跳过
     */
    private TextView mTxtSkip;
    private CountDownTimer start;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        initView();

        animation = AnimationUtils.loadAnimation(this, R.anim.main_anim_set);
        mIvBg.setAnimation(animation);
        animation.start();

        start = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTxtSkip.setText(millisUntilFinished / 1000 + "");
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(AnimActivity.this, MainActivity.class));
                finish();
            }
        }.start();
    }

    private void initView() {
        mIvBg = (ImageView) findViewById(R.id.iv_bg);
        mTxtSkip = (TextView) findViewById(R.id.txt_skip);
        mTxtSkip.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (start != null) {
            start.cancel();
        }
        if (animation != null) {
            animation.cancel();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.txt_skip:
                startActivity(new Intent(AnimActivity.this,MainActivity.class));
                finish();
                break;
        }
    }
}
