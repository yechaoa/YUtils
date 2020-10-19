package com.yechaoa.yutilskt

import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
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
    @Deprecated("简化调用，使用show(msg)即可", ReplaceWith("ToastUtilKt.show(msg)"))
    fun showToast(msg: String) {
        if ("main" == Thread.currentThread().name) {
            createToast(msg)
        } else {
            ActivityUtil.currentActivity?.runOnUiThread { createToast(msg) }
        }
    }

    fun show(msg: String) {
        if ("main" == Thread.currentThread().name) {
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
    private fun createToast(msg: String) {
        if (toast == null) {
            toast = Toast.makeText(YUtils.getApp(), msg, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(msg)
        }
        val linearLayout = toast!!.view as LinearLayout
        val messageTextView = linearLayout.getChildAt(0) as TextView
        messageTextView.textSize = 15f
        toast!!.show()
    }

    /**
     * showCenterToast 居中显示
     *
     * @param msg 需要显示的参数
     */
    @Deprecated("简化调用，使用showCenter(msg)即可", ReplaceWith("ToastUtilKt.showCenter(msg)"))
    fun showCenterToast(msg: String) {
        if ("main" == Thread.currentThread().name) {
            createCenterToast(msg)
        } else {
            ActivityUtil.currentActivity!!.runOnUiThread { createCenterToast(msg) }
        }
    }

    fun showCenter(msg: String) {
        if ("main" == Thread.currentThread().name) {
            createCenterToast(msg)
        } else {
            ActivityUtil.currentActivity!!.runOnUiThread { createCenterToast(msg) }
        }
    }

    /**
     * createCenterToast
     *
     * @param msg 接收参数
     */
    private fun createCenterToast(msg: String) {
        if (toast == null) {
            toast = Toast.makeText(YUtils.getApplication(), msg, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(msg)
        }
        val linearLayout = toast!!.view as LinearLayout
        val messageTextView = linearLayout.getChildAt(0) as TextView
        toast!!.setGravity(Gravity.CENTER, 0, 0)
        messageTextView.textSize = 15f
        toast!!.show()
    }

    /**
     * 取消Toast
     * onDestroy时调用，或者onPause
     * 当前页面finish之后在下一个页面不会显示
     */
    @Deprecated("简化调用，使用cancel()即可", ReplaceWith("ToastUtilKt.cancel()"))
    fun cancelToast() {
        if (toast != null) {
            toast!!.cancel()
        }
    }

    fun cancel() {
        if (toast != null) {
            toast!!.cancel()
        }
    }
}