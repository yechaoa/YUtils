package com.yechaoa.yutilskt

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue

/**
 * Created by yechao on 2020/10/30.
 * Describe : 屏幕相关
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object DisplayUtil {

    /**
     * dp2px
     */
    fun dp2px(dp: Float): Int {
        val density = YUtils.getApp().resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }

    /**
     * px2dp
     */
    fun px2dp(px: Int): Float {
        val density = YUtils.getApp().resources.displayMetrics.density
        return px / density
    }

    /**
     * 获取屏幕宽度
     */
    fun getScreenWidth(): Int {
        val dm = DisplayMetrics()
        ActivityUtil.currentActivity!!.windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }

    /**
     * 获取屏幕高度
     */
    fun getScreenHeight(): Int {
        val dm = DisplayMetrics()
        ActivityUtil.currentActivity!!.windowManager.defaultDisplay.getMetrics(dm)
        return dm.heightPixels
    }

    /**
     * 获取状态栏高度 px
     */
    fun getStatusBarHeight(): Int {
        val resources = YUtils.getApp().resources
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

    /**
     * 获取ActionBar高度 px
     */
    fun getActionBarHeight(): Int {
        val tv = TypedValue()
        return if (YUtils.getApp().theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            TypedValue.complexToDimensionPixelSize(tv.data, YUtils.getApp().resources.displayMetrics)
        } else 0
    }

    /**
     * 获取导航栏高度 px
     */
    fun getNavBarHeight(): Int {
        val res: Resources = YUtils.getApp().resources
        val resourceId: Int = res.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId != 0) {
            res.getDimensionPixelSize(resourceId)
        } else {
            0
        }
    }
}