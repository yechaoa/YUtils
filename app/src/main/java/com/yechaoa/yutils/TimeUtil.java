package com.yechaoa.yutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yechao on 2017/12/29.
 * Describe :
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

public class TimeUtil {

    /**
     * 获取当前年月日
     */
    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 获取当前时分秒
     */
    public static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 获取当前年月日时分秒
     */
    public static String getDateAndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        return sdf.format(date);
    }

    /**
     * 获取当前时间，返回Long类型
     */
    public static Long getTimeForLong() {
        return System.currentTimeMillis();
    }

    /**
     * 转换为年月日
     */
    public static String formatDate(String mDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = null;
        try {
            date = sdf.parse(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
    }

}
