package com.dingyizhe.kungfu.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 快/慢滑动ScrollView
 *
 * @author 农民伯伯
 */
public class SlowScrollView extends ScrollView {
    public SlowScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SlowScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlowScrollView(Context context) {
        super(context);
    }

    /**
     * 滑动事件
     */
    @Override
    public void fling(int velocityY) {
        super.fling(velocityY / 4);
    }
}