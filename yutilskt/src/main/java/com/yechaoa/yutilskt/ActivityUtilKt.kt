package com.yechaoa.yutilskt

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import android.text.TextUtils
import java.util.*

/**
 * Created by yechao on 2020/1/7.
 * Describe : Activity管理  thanks jude95
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object ActivityUtilKt {
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
     * 关闭当前Activity
     */
    fun finishActivity(activity: Activity?) {
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
            finishActivity(activity)
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
            finishActivity(activity)
            break
        }
    }

    fun getActivityStack(): Stack<Activity> {
        val stack = Stack<Activity>()
        stack.addAll(activityStack)
        return stack
    }

    private class MyActivityLifecycleCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {
            activityStack.remove(activity)
            activityStack.push(activity)
        }

        override fun onActivityStarted(activity: Activity) {}
        override fun onActivityResumed(activity: Activity) {}
        override fun onActivityPaused(activity: Activity) {}
        override fun onActivityStopped(activity: Activity) {}
        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
        override fun onActivityDestroyed(activity: Activity) {
            activityStack.remove(activity)
        }
    }
}