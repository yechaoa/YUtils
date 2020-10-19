package com.yechaoa.yutilskt.widget

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.widget.TextView
import com.yechaoa.yutilskt.R

/**
 * Created by yechao on 2020/1/7.
 * Describe : YLoadingDialog
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
class YLoadingDialog constructor(context: Context, msg: String, cancelable: Boolean = true, theme: Int = R.style.yLoadingDialog) : Dialog(context, theme) {

    init {
        setContentView(R.layout.dialog_y_loading)
        setCancelable(cancelable)
        setCanceledOnTouchOutside(cancelable)
        window?.attributes?.gravity = Gravity.CENTER
        val lp = window?.attributes
        lp?.dimAmount = 0.2f
        window?.attributes = lp
        val tvTitle = findViewById<TextView>(R.id.tv_y_loading)
        tvTitle?.text = msg
    }

}