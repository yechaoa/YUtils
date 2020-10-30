package com.yechaoa.yutilskt

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import java.util.*

/**
 * Created by yechao on 2020/1/7.
 * Describe : Activity管理
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object ActivityUtil {
    //Stack(栈)，后进先出
    private val activityStack = Stack<Activity>()

    //Activity的生命周期回调，要求API14+（Android 4.0+）
    private val instance = MyActivityLifecycleCallbacks()

    val activityLifecycleCallbacks: ActivityLifecycleCallbacks
        get() = instance

    /**
     * 获得当前栈顶Activity
     */
    val currentActivity: Activity?
        get() {
            var activity: Activity? = null
            if (!activityStack.isEmpty()) activity = activityStack.peek()
            return activity
        }

    /**
     * 获得当前Activity名字
     */
    val currentActivityName: String
        get() {
            val activity = currentActivity
            var name = ""
            if (activity != null) {
                name = activity.componentName.className
            }
            return name
        }

    /**
     * 启动指定Activity 参数可选，intent.get***Extra 即可获取参数
     */
    fun start(clazz: Class<out Activity>, bundle: Bundle = Bundle()) {
        val intent = Intent(currentActivity, clazz)
        intent.putExtras(bundle)
        currentActivity?.startActivity(intent)
    }

    /**
     * 关闭指定Activity
     */
    @Deprecated("简化调用，使用ActivityUtil.finish(activity)即可", ReplaceWith("ActivityUtil.finish(activity)"))
    fun finishActivity(activity: Activity?) {
        if (activity != null) {
            activityStack.remove(activity)
            activity.finish()
        }
    }

    /**
     * 关闭指定Activity
     */
    fun finish(activity: Activity?) {
        if (activity != null) {
            activityStack.remove(activity)
            activity.finish()
        }
    }

    /**
     * 关闭所有Activity
     */
    fun closeAllActivity() {
        while (true) {
            val activity = currentActivity ?: break
            finish(activity)
        }
    }

    fun closeActivityByName(name: String?) {
        var index = activityStack.size - 1
        while (true) {
            val activity = activityStack[index] ?: break
            val activityName = activity.componentName.className
            if (!TextUtils.equals(name, activityName)) {
                index--
                if (index < 0) {
                    break
                }
                continue
            }
            finish(activity)
            break
        }
    }

    fun getActivityStack(): Stack<Activity> {
        val stack = Stack<Activity>()
        stack.addAll(activityStack)
        return stack
    }

    private class MyActivityLifecycleCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            activityStack.remove(activity)
            activityStack.push(activity)
        }

        override fun onActivityStarted(activity: Activity) {}
        override fun onActivityResumed(activity: Activity) {}
        override fun onActivityPaused(activity: Activity) {}
        override fun onActivityStopped(activity: Activity) {}
        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {}
        override fun onActivityDestroyed(activity: Activity) {
            activityStack.remove(activity)
        }
    }
}