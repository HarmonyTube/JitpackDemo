package com.dingyizhe.kungfu.ui.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.dingyizhe.kungfu.R;
import com.dingyizhe.kungfu.ui.base.BaseFragment;
import com.gyf.immersionbar.ImmersionBar;

public class ClassificationFragment extends BaseFragment {
    public static ClassificationFragment newInstance() {
        Bundle args = new Bundle();
        ClassificationFragment fragment = new ClassificationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        LottieAnimationView lottieAnimationView = mContentView.findViewById(R.id.home_lottie);
        lottieAnimationView.setAnimation(R.raw.classification);
        //设置无限重复
        //mTestLottie.loop(true);
        lottieAnimationView.setRepeatCount(ValueAnimator.INFINITE);
        //运行动画
        lottieAnimationView.playAnimation();
    }

    @Override
    public void onResume() {
        super.onResume();

        ImmersionBar.with(this)
                .transparentStatusBar()  //透明状态栏，不写默认透明色
                .statusBarDarkFont(true)
//                .statusBarColor(R.color.transparent,0)
//                .fitsSystemWindows(true)
                .navigationBarColor(R.color.navigationBarColor)
//                .autoNavigationBarDarkModeEnable(true,0.2f)
                .init();
    }
}
