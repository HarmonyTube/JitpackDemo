package com.dingyizhe.kungfu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.dingyizhe.kungfu.MainActivity;
import com.dingyizhe.kungfu.R;
import com.dingyizhe.kungfu.ui.view.Action;
import com.dingyizhe.kungfu.ui.view.CountdownView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.tencent.mmkv.MMKV;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 启动页面
 */
public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.iv_splash_logo)
    AppCompatImageView ivSplashLogo;
    @BindView(R.id.countdown)
    CountdownView mCountdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this)
//                // 有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
                .fullScreen(true)
//                // 透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
                .transparentBar()
//                // 隐藏状态栏 导航栏
                .hideBar(BarHide.FLAG_HIDE_BAR)
                .init();
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


        String rootDir = MMKV.initialize(this);
        System.out.println("mmkv root: " + rootDir);
        MMKV.defaultMMKV().putString("key", "23234234234234");
        mCountdownView.start();
        mCountdownView.setOnFinishAction(new Action() {
            @Override
            public void onAction() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
        mCountdownView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountdownView.end();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
