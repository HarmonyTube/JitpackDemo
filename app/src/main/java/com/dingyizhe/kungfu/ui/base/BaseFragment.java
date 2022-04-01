package com.dingyizhe.kungfu.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.dingyizhe.kungfu.R;


public abstract class BaseFragment extends Fragment {

    protected static final String BUNDLE_KEY = "/bundle/key";
    protected View mContentView;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mContentView = inflater.inflate(getContentView(), container, false);
//        mContentView.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.background_dark));
        mContentView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.main_bankground_color));
        return mContentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(savedInstanceState);
    }

    @LayoutRes
    protected abstract int getContentView();

    protected abstract void init(Bundle savedInstanceState);

    protected View findViewById(@IdRes int id) {
        return mContentView.findViewById(id);
    }
}
