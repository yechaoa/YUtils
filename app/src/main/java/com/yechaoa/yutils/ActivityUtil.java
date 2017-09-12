package com.yechaoa.yutils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.Stack;

/**
 * Created by yechao on 2017/9/11.
 * Describe : Activity管理  thanks jude95
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

@TargetApi(14)
public class ActivityUtil {

    //Stack(栈)，后进先出
    private static Stack<Activity> activityStack = new Stack<>();
    //Activity的生命周期回调，要求API14+（Android 4.0+）
    private static final MyActivityLifecycleCallbacks instance = new MyActivityLifecycleCallbacks();

    private static class MyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            activityStack.remove(activity);
            activityStack.push(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            activityStack.remove(activity);
        }
    }

    public static Application.ActivityLifecycleCallbacks getActivityLifecycleCallbacks() {
        return instance;
    }

    /**
     * 获得当前栈顶Activity
     */
    public static Activity getCurrentActivity() {
        Activity activity = null;
        if (!activityStack.isEmpty())
            activity = activityStack.peek();
        return activity;
    }

    /**
     * 获得当前Activity名字
     */
    public static String getCurrentActivityName() {
        Activity activity = getCurrentActivity();
        String name = "";
        if (activity != null) {
            name = activity.getComponentName().getClassName();
        }
        return name;
    }

    /**
     * 关闭当前Activity
     */
    public static void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }
    /**
     * 关闭所有Activity
     */
    public static void closeAllActivity() {
        while (true) {
            Activity activity = getCurrentActivity();
            if (null == activity) {
                break;
            }
            finishActivity(activity);
        }
    }

    public static void closeActivityByName(String name) {
        int index = activityStack.size() - 1;
        while (true) {
            Activity activity = activityStack.get(index);
            if (null == activity) {
                break;
            }
            String activityName = activity.getComponentName().getClassName();
            if (!TextUtils.equals(name, activityName)) {
                index--;
                if (index < 0) {
                    break;
                }
                continue;
            }
            finishActivity(activity);
            break;
        }
    }

    public static Stack<Activity> getActivityStack() {
        Stack<Activity> stack = new Stack<>();
        stack.addAll(activityStack);
        return stack;
    }

}
