package com.yechaoa.yutils;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by yechao on 2017/12/29.
 * Describe : toast 任意线程，不重复显示
 * * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

public class ToastUtil {

    private static Toast toast = null;

    /**
     * showToast 底部显示（默认） 直接用show()即可
     *
     * @param msg 需要显示的参数
     */
    @Deprecated
    public static void showToast(final String msg) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createToast(msg);
        } else {
            ActivityUtil.getCurrentActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    createToast(msg);
                }
            });
        }
    }

    /**
     * showToast 底部显示（默认）
     *
     * @param msg 需要显示的参数
     */
    public static void show(final String msg) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createToast(msg);
        } else {
            ActivityUtil.getCurrentActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    createToast(msg);
                }
            });
        }
    }

    /**
     * createToast
     *
     * @param msg 接收参数
     */
    @SuppressLint("ShowToast")
    private static void createToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(YUtils.getApp().getApplicationContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * showCenterToast 居中显示  直接用showCenter()即可
     *
     * @param msg 需要显示的参数
     */
    @Deprecated
    public static void showCenterToast(final String msg) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createCenterToast(msg);
        } else {
            ActivityUtil.getCurrentActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    createCenterToast(msg);
                }
            });
        }
    }

    /**
     * showCenterToast 居中显示
     *
     * @param msg 需要显示的参数
     */
    public static void showCenter(final String msg) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            createCenterToast(msg);
        } else {
            ActivityUtil.getCurrentActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    createCenterToast(msg);
                }
            });
        }
    }

    /**
     * createCenterToast
     *
     * @param msg 接收参数
     */
    @SuppressLint("ShowToast")
    private static void createCenterToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(YUtils.getApp().getApplicationContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 取消Toast 直接用cancel()即可
     * onDestroy时调用，或者onPause
     * 当前页面finish之后在下一个页面不会显示
     */
    @Deprecated
    public static void cancelToast() {
        if (toast != null) {
            toast.cancel();
        }
    }

    /**
     * 取消Toast
     * onDestroy时调用，或者onPause
     * 当前页面finish之后在下一个页面不会显示
     */
    public static void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }

    /**
     * 回收Toast
     */
    public static void release() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

}
