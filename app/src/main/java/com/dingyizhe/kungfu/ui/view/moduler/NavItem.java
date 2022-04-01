package com.dingyizhe.kungfu.ui.view.moduler;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxin 2019/12/18 上午 11:46
 * @version V1.0.0
 * @name NavItem
 * @mail godfeer@aliyun.com
 * @description TODO
 */
public class NavItem {
    private int titleResId;
    private int iconResId;
    private int textColor;
    private Fragment fragment;

    public NavItem(@StringRes int titleResId, int iconResId, @ColorRes int textColor) {
        this.titleResId = titleResId;
        this.iconResId = iconResId;
        this.textColor = textColor;
    }

    public NavItem(@StringRes int titleResId, int iconResId, @ColorRes int textColor, Fragment fragment) {
        this.titleResId = titleResId;
        this.iconResId = iconResId;
        this.textColor = textColor;
        this.fragment = fragment;
    }

    //获取标题资源ID
    int getTitleResId() {
        return titleResId;
    }

    //获取图标资源ID
    int getIconResId() {
        return iconResId;
    }

    //获取当前资源值
    int getTextColor() {
        return textColor;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public NavItem setFragment(Fragment fragment) {
        this.fragment = fragment;
        return this;
    }
}
