package com.yechaoa.yutils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by yechao on 2020/10/30.
 * Describe : 屏幕相关
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

public class DisplayUtil {

    /**
     * dp2px
     */
    public static int dp2px(float dp) {
        float density = YUtils.getApp().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

    /**
     * px2dp
     */
    public static float px2dp(int px) {
        float density = YUtils.getApp().getResources().getDisplayMetrics().density;
        return px / density;
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        ActivityUtil.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        ActivityUtil.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * 获取状态栏高度 px
     */
    public static int getStatusBarHeight() {
        Resources resources = YUtils.getApp().getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    /**
     * 获取ActionBar高度 px
     */
    public static int getActionBarHeight() {
        TypedValue tv = new TypedValue();
        if (YUtils.getApp().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            return TypedValue.complexToDimensionPixelSize(tv.data, YUtils.getApp().getResources().getDisplayMetrics());
        }
        return 0;
    }

    /**
     * 获取导航栏高度 px
     */
    public static int getNavBarHeight() {
        Resources res = YUtils.getApp().getResources();
        int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId != 0) {
            return res.getDimensionPixelSize(resourceId);
        } else {
            return 0;
        }
    }
}
