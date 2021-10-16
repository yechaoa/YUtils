package com.yechaoa.yutilskt

import android.app.Activity
import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.TelephonyManager
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Base64
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import com.yechaoa.yutilskt.widget.YLoadingDialog
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by yechao on 2020/1/7.
 * Describe : 快速开发工具集合
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object YUtils {

    private lateinit var mApp: Application
    private var yLoadingDialog: YLoadingDialog? = null

    @Deprecated("简化调用，使用init(app)即可", ReplaceWith("YUtils.init(app)"))
    fun initialize(app: Application) {
        mApp = app
        app.registerActivityLifecycleCallbacks(ActivityUtil.activityLifecycleCallbacks)
    }

    fun init(app: Application) {
        mApp = app
        app.registerActivityLifecycleCallbacks(ActivityUtil.activityLifecycleCallbacks)
    }

    @Deprecated("简化调用，使用getApp()即可", ReplaceWith("YUtils.getApp()"))
    fun getApplication(): Application {
        return mApp
    }

    fun getApp(): Application {
        if (this::mApp.isInitialized) {
            return mApp
        } else {
            throw UninitializedPropertyAccessException("YUtils is not initialized in application")
        }
    }

    fun getAppContext(): Context {
        return getApp().applicationContext
    }

    /**
     * 获取屏幕宽度
     */
    @Deprecated("拆分处理，使用DisplayUtil.getScreenWidth()即可", ReplaceWith("DisplayUtil.getScreenWidth()"))
    fun getScreenWidth(): Int {
        val dm = DisplayMetrics()
        ActivityUtil.currentActivity!!.windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }

    /**
     * 获取屏幕高度
     */
    @Deprecated("拆分处理，使用DisplayUtil.getScreenHeight()即可", ReplaceWith("DisplayUtil.getScreenHeight()"))
    fun getScreenHeight(): Int {
        val dm = DisplayMetrics()
        ActivityUtil.currentActivity!!.windowManager.defaultDisplay.getMetrics(dm)
        return dm.heightPixels
    }

    /**
     * Loading加载框
     */
    fun showLoading(activity: Activity, msg: String, cancelable: Boolean = true) {
        yLoadingDialog = YLoadingDialog(activity, msg, cancelable)
        yLoadingDialog?.show()
    }

    /**
     * dismissLoading
     */
    fun hideLoading() {
        if (null != yLoadingDialog && yLoadingDialog?.isShowing!!) {
            yLoadingDialog?.dismiss()
            yLoadingDialog = null
        }
    }

    /**
     * loading是否显示，需在showLoading()之后调用，否则为null
     */
    fun loadingIsShowing(): Boolean? = yLoadingDialog?.isShowing

    /**
     * 根据时间休眠然后关闭当前页面
     * 比如：5秒自动返回
     * 或者只需要后台给一个结果而已
     */
    fun finishBySleep(millis: Long) {
        object : Thread() {
            override fun run() {
                try {
                    sleep(millis)
                    ActivityUtil.currentActivity?.finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    /**
     * 获取版本名
     */
    fun getVersionName(): String? {
        return try {
            val packageManager = getApp().packageManager
            val packageInfo = packageManager.getPackageInfo(getApp().packageName, 0)
            packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            null
        }
    }

    /**
     * 获取版本号
     */
    fun getVersionCode(): Int {
        return try {
            val packageManager = getApp().packageManager
            val packageInfo = packageManager.getPackageInfo(getApp().packageName, 0)
            packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            0
        }
    }

    /**
     * 检验手机号
     */
    fun checkPhoneNumber(number: String?): Boolean {
        var p: Pattern? = null
        var m: Matcher? = null
        var b = false
        p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$")
        m = p.matcher(number)
        b = m.matches()
        return b
    }

    /**
     * MD5加密
     */
    fun MD5(data: String): String {
        var md5: MessageDigest? = null
        try {
            md5 = MessageDigest.getInstance("MD5")
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        md5!!.update(data.toByteArray())
        val m = md5.digest()
        return Base64.encodeToString(m, Base64.DEFAULT)
    }

    /**
     * dp2px
     */
    @Deprecated("拆分处理，使用DisplayUtil.dp2px()即可", ReplaceWith("DisplayUtil.dp2px(dp)"))
    fun dp2px(dp: Float): Int {
        val density = getApp().resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }

    /**
     * px2dp
     */
    @Deprecated("拆分处理，使用DisplayUtil.px2dp()即可", ReplaceWith("DisplayUtil.px2dp(px)"))
    fun px2dp(px: Int): Float {
        val density = getApp().resources.displayMetrics.density
        return px / density
    }

    /**
     * 复制文本到粘贴板
     */
    fun copyToClipboard(text: String?) {
        val cm = getApp().getSystemService(Activity.CLIPBOARD_SERVICE) as ClipboardManager
        cm.setPrimaryClip(ClipData.newPlainText(getApp().packageName, text))
    }

    /**
     * 字体高亮
     */
    fun foreground(view: View?, color: Int, start: Int, end: Int): View? {
        if (view is Button) {
            val btn = view
            // 获取文字
            val span: Spannable = SpannableString(btn.text.toString())
            //设置颜色和起始位置
            span.setSpan(ForegroundColorSpan(color), start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
            btn.text = span
            return btn
        } else if (view is TextView) { //EditText extends TextView
            val text = view
            val span: Spannable = SpannableString(text.text.toString())
            span.setSpan(ForegroundColorSpan(color), start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
            text.text = span
            return text
        }
        return null
    }

    /**
     * 弹出软键盘
     */
    fun showSoftKeyboard(view: View) {
        val inputManger = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManger.showSoftInput(view, InputMethodManager.SHOW_FORCED)
    }

    /**
     * 关闭软键盘
     */
    fun closeSoftKeyboard() {
        val inputManger =
            ActivityUtil.currentActivity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManger.hideSoftInputFromWindow(ActivityUtil.currentActivity!!.window.decorView.windowToken, 0)
    }

    /**
     * 是否有sim卡 即设备是否可以拨打电话等
     */
    fun hasSim(): Boolean {
        val telephonyManager = getApp().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        var result = true
        when (telephonyManager.simState) {
            TelephonyManager.SIM_STATE_ABSENT -> result = false
            TelephonyManager.SIM_STATE_UNKNOWN -> result = false
        }
        return result
    }
}
