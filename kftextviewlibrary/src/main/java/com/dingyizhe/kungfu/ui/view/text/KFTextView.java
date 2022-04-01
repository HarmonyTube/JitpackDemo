package com.dingyizhe.kungfu.ui.view.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.dingyizhe.kungfu.R;


/****

 -1  绝对禁用
 0  特殊使用
 1 一般禁用
 * */

public class KFTextView extends AppCompatTextView {


    public KFTextView(Context context) {
        super(context);
    }

    public KFTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public KFTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

//    private void applyCustomFont(Context context) {
//
//
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CountdownView, 0, 0);
//
//        try {
//            int defaultColor = Color.parseColor("grey");
//            mText = a.getText(R.styleable.CountdownView_text);
//            mTextColor = a.getColor(R.styleable.CountdownView_text_color, Color.BLACK);
//            mTextSize = a.getDimension(R.styleable.CountdownView_text_size, DEFAULT_TEXT_SIZE);
//            mUpdateTime = a.getInteger(R.styleable.CountdownView_update_time, DEFAULT_TIME);
//            mTotalTime = a.getInteger(R.styleable.CountdownView_total_time, DEFAULT_TIME);
//            mProgressColor = a.getColor(R.styleable.CountdownView_progress_color, Color.RED);
//            mProgressWidth = a.getDimension(R.styleable.CountdownView_progress_width, DEFAULT_STOKE_WIDTH);
//            mProgressHintColor = a.getColor(R.styleable.CountdownView_progress_hint_color, defaultColor);
//            mCircleColor = a.getColor(R.styleable.CountdownView_bg_color, Color.WHITE);
//        } finally {
//            a.recycle();
//        }
//
////        Typeface customFont = FontCache.getTypeface("SourceSansPro-Regular.ttf", context);
////        Typeface customFont = FontCache.getTypeface("SourceHanSansCN-Regular.otf", context);
////        setTypeface(customFont);
//
//        /*
//         * 必须事先在assets底下创建一fonts文件夹，并放入要使用的字体文件(.ttf/.otf)
//         * 并提供相对路径给creatFromAsset()来创建Typeface对象
//         */
//        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceHanSansCN-Light.otf");
//        // 当使用外部字体却又发现字体没有变化的时候(以 Droid Sans代替)，通常是因为这个字体android没有支持,而非你的程序发生了错误
//        if (typeface != null) {
//            setTypeface(typeface);
//        }
//    }


    public void init(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.KFTextView, 0, 0);
        try {
            /*
             * 必须事先在assets底下创建一fonts文件夹，并放入要使用的字体文件(.ttf/.otf)
             * 并提供相对路径给creatFromAsset()来创建Typeface对象
             */
//            Typeface typeface = FontCache.getTypeface("fonts/SourceHanSansCN-Light.otf", context);


            String fontPath = a.getString(R.styleable.KFTextView_kftv_font);
//            mText = a.getInteger(R.styleable.CountdownView_text);
            Typeface typeface = FontCache.getTypeface(fontPath, context);
            System.out.println("=====fontPath" + fontPath);
            // 当使用外部字体却又发现字体没有变化的时候(以 Droid Sans代替)，通常是因为这个字体android没有支持,而非你的程序发生了错误
            if (typeface != null) {
                setTypeface(typeface);
            }

        } finally {
            a.recycle();
        }


    }

}