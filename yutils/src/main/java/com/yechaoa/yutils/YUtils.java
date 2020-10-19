package com.yechaoa.yutils;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yechao on 2017/4/2.
 * Describe : 快速开发工具集合
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

public class YUtils {

    private static Toast toast;
    private static ProgressDialog progressDialog;
    private static Application mApplicationContext;

    /**
     * 使用init()即可
     */
    @Deprecated
    public static void initialize(Application app) {
        mApplicationContext = app;
        app.registerActivityLifecycleCallbacks(ActivityUtil.getActivityLifecycleCallbacks());
    }


    public static void init(Application app) {
        mApplicationContext = app;
        app.registerActivityLifecycleCallbacks(ActivityUtil.getActivityLifecycleCallbacks());
    }

    /**
     * 使用getApp()即可
     */
    @Deprecated
    public static Application getApplication() {
        return mApplicationContext;
    }

    public static Application getApp() {
        return mApplicationContext;
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        ActivityUtil.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        ActivityUtil.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }


    /**
     * Loading加载框
     */
    public static void showLoading(String msg) {
        progressDialog = ProgressDialog.show(ActivityUtil.getCurrentActivity(), "", msg, true, true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public static void showLoading(Activity activity, String msg) {
        progressDialog = ProgressDialog.show(activity, "", msg, true, true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    /**
     * hideLoading
     */
    public static void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    /**
     * loading是否显示，需在showLoading()之后调用，否则为false
     */
    public static boolean loadingIsShowing() {
        if (progressDialog == null) {
            return false;
        } else {
            return progressDialog.isShowing();
        }
    }


    /**
     * 根据时间休眠然后关闭当前页面
     * 比如：5秒自动返回
     * 或者只需要后台给一个结果而已
     */
    public static void finishBySleep(final long millis) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(millis);
                    ActivityUtil.getCurrentActivity().finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    /**
     * 获取版本名
     */
    public static String getVersionName() {
        try {
            PackageManager packageManager = YUtils.getApplication().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(YUtils.getApplication().getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取版本号
     */
    public static int getVersionCode() {
        try {
            PackageManager packageManager = YUtils.getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(YUtils.getApplication().getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * 检验手机号
     */
    public static boolean checkPhoneNumber(String number) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");
        m = p.matcher(number);
        b = m.matches();
        return b;
    }


    /**
     * MD5加密
     */
    public static String MD5(String data) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(data.getBytes());
        byte[] m = md5.digest();
        return Base64.encodeToString(m, Base64.DEFAULT);
    }


    /**
     * dp2px
     */
    public static int dp2px(float dp) {
        float density = YUtils.getApp().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

    /**
     * px2dp
     */
    public static float px2dp(int px) {
        float density = YUtils.getApp().getResources().getDisplayMetrics().density;
        return px / density;
    }


    /**
     * 复制文本到粘贴板
     */
    public static void copyToClipboard(String text) {
        ClipboardManager cm = (ClipboardManager) YUtils.getApp().getSystemService(Activity.CLIPBOARD_SERVICE);
        cm.setPrimaryClip(ClipData.newPlainText(YUtils.getApp().getPackageName(), text));
    }

    /**
     * 字体高亮
     */
    public static View foreground(View view, int color, int start, int end) {
        if (view instanceof Button) {
            Button btn = (Button) view;
            // 获取文字
            Spannable span = new SpannableString(btn.getText().toString());
            //设置颜色和起始位置
            span.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            btn.setText(span);
            return btn;
        } else if (view instanceof TextView) {//EditText extends TextView
            TextView text = (TextView) view;
            Spannable span = new SpannableString(text.getText().toString());
            span.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            text.setText(span);
            return text;
        }
        return null;
    }

    /**
     * 弹出软键盘
     */
    public static void showSoftKeyboard(View view) {
        InputMethodManager inputManger = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManger.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    /**
     * 关闭软键盘
     */
    public static void closeSoftKeyboard() {
        InputMethodManager inputManger = (InputMethodManager) ActivityUtil.getCurrentActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManger.hideSoftInputFromWindow(ActivityUtil.getCurrentActivity().getWindow().getDecorView().getWindowToken(), 0);
    }

}
