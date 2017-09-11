package com.yechaoa.yutils;

import android.util.Log;

/**
 * Created by yechao on 2017/9/8.
 * Describe : 日志管理
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 *
 */

public class LogUtil {

    private static String TAG = "LogUtil";
    private static boolean IS_LOG = false;
    private static int MAX_LENGTH = 4000;

    public static void setIsLog(boolean isLog) {
        IS_LOG = isLog;
    }

    public static void setIsLog(boolean isLog, String tag) {
        TAG = tag;
        IS_LOG = isLog;
    }

    public static void i(String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;
            for (int i = 0; i < 100; i++) {
                if (strLength > end) {
                    Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                    start = end;
                    end = end + MAX_LENGTH;
                } else {
                    Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }
            }
        }
    }

    public static void i(String TAG, String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;
            for (int i = 0; i < 100; i++) {
                if (strLength > end) {
                    Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                    start = end;
                    end = end + MAX_LENGTH;
                } else {
                    Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }
            }

        }
    }

    public static void e(String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;
            for (int i = 0; i < 100; i++) {
                if (strLength > end) {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                    start = end;
                    end = end + MAX_LENGTH;
                } else {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }
            }
        }
    }

    public static void e(String TAG, String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;
            for (int i = 0; i < 100; i++) {
                if (strLength > end) {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                    start = end;
                    end = end + MAX_LENGTH;
                } else {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }
            }
        }
    }

    /**
     * 获取打印信息所在方法名，行号等信息
     */
    private static String[] getAutoJumpLogInfos() {
        String[] infos = new String[]{"", "", ""};
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        infos[0] = elements[4].getClassName().substring(elements[4].getClassName().lastIndexOf(".") + 1);
        infos[1] = elements[4].getMethodName();
        infos[2] = "(" + elements[4].getFileName() + ":" + elements[4].getLineNumber() + ")";
        return infos;
    }

}
