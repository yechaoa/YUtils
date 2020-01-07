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
class YLoadingDialog private constructor(context: Context, theme: Int) : Dialog(context, theme) {

    companion object {

        private lateinit var mDialog: YLoadingDialog

        fun buildDialog(context: Context, msg: String): YLoadingDialog {
            mDialog = YLoadingDialog(context, R.style.yLoadingDialog)
            mDialog.setContentView(R.layout.dialog_y_loading)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window.attributes.gravity = Gravity.CENTER
            val lp = mDialog.window.attributes
            lp.dimAmount = 0.2f
            mDialog.window.attributes = lp
            val tvTitle = mDialog.findViewById<TextView>(R.id.tv_y_loading)
            tvTitle.text = msg
            return mDialog
        }
    }

    //显示加载框
    fun showLoading() {
        super.show()
        mDialog.show()
    }

    //关闭加载框
    fun hideLoading() {
        super.dismiss()
        mDialog.dismiss()
    }
}