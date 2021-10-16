package com.yechaoa.yutilskt

import android.annotation.SuppressLint
import android.os.Looper
import android.view.Gravity
import android.widget.Toast

/**
 * Created by yechao on 2020/1/7.
 * Describe : toast 任意线程，不重复显示
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object ToastUtil {
    private var toast: Toast? = null

    /**
     * showToast 底部显示（默认）
     *
     * @param msg 需要显示的参数
     */
    @Deprecated("简化调用，使用show(msg)即可", ReplaceWith("ToastUtil.show(msg)"))
    fun showToast(msg: String) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createToast(msg)
        } else {
            ActivityUtil.currentActivity?.runOnUiThread { createToast(msg) }
        }
    }

    fun show(msg: String) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createToast(msg)
        } else {
            ActivityUtil.currentActivity?.runOnUiThread { createToast(msg) }
        }
    }

    /**
     * createToast
     *
     * @param msg 接收参数
     */
    @SuppressLint("ShowToast")
    private fun createToast(msg: String) {
        if (null == toast) {
            toast = Toast.makeText(YUtils.getApp().applicationContext, msg, Toast.LENGTH_SHORT)
        } else {
            toast?.setText(msg)
        }
        toast?.show()
    }

    /**
     * showCenterToast 居中显示
     *
     * @param msg 需要显示的参数
     */
    @Deprecated("简化调用，使用showCenter(msg)即可", ReplaceWith("ToastUtil.showCenter(msg)"))
    fun showCenterToast(msg: String) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createCenterToast(msg)
        } else {
            ActivityUtil.currentActivity?.runOnUiThread { createCenterToast(msg) }
        }
    }

    fun showCenter(msg: String) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createCenterToast(msg)
        } else {
            ActivityUtil.currentActivity?.runOnUiThread { createCenterToast(msg) }
        }
    }

    /**
     * createCenterToast
     *
     * @param msg 接收参数
     */
    @SuppressLint("ShowToast")
    private fun createCenterToast(msg: String) {
        if (null == toast) {
            toast = Toast.makeText(YUtils.getApp().applicationContext, msg, Toast.LENGTH_SHORT)
        } else {
            toast?.setText(msg)
        }
        toast?.setGravity(Gravity.CENTER, 0, 0)
        toast?.show()
    }

    /**
     * 取消Toast
     * onDestroy时调用，或者onPause
     * 当前页面finish之后在下一个页面不会显示
     */
    @Deprecated("简化调用，使用cancel()即可", ReplaceWith("ToastUtil.cancel()"))
    fun cancelToast() {
        toast?.cancel()
    }

    /**
     * 取消Toast
     * onDestroy时调用，或者onPause
     * 当前页面finish之后在下一个页面不会显示
     */
    fun cancel() {
        toast?.cancel()
    }

    /**
     * 回收Toast
     */
    fun release() {
        toast?.let {
            it.cancel()
            toast = null
        }
    }
}