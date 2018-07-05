package com.yechaoa.yutils;

import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yechao on 2017/12/29.
 * Describe : toast 任意线程，不重复显示
 * * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

public class ToastUtil {

    private static Toast toast;

    /**
     * showToast 底部显示（默认）
     *
     * @param msg 需要显示的参数
     */
    public static void showToast(final String msg) {
        if ("main".equals(Thread.currentThread().getName())) {
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
    private static void createToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(YUtils.getApplication(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        LinearLayout linearLayout = (LinearLayout) toast.getView();
        TextView messageTextView = (TextView) linearLayout.getChildAt(0);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        messageTextView.setTextSize(15);
        toast.show();
    }

    /**
     * showCenterToast 居中显示
     *
     * @param msg 需要显示的参数
     */
    public static void showCenterToast(final String msg) {
        if ("main".equals(Thread.currentThread().getName())) {
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
    private static void createCenterToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(YUtils.getApplication(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        LinearLayout linearLayout = (LinearLayout) toast.getView();
        TextView messageTextView = (TextView) linearLayout.getChildAt(0);
        toast.setGravity(Gravity.CENTER, 0, 0);
        messageTextView.setTextSize(15);
        toast.show();
    }

    /**
     * 取消Toast
     * onDestroy时调用，或者onPause
     * 当前页面finish之后在下一个页面不会显示
     */
    public static void cancelToast() {
        if (toast != null) {
            toast.cancel();
        }
    }

}
