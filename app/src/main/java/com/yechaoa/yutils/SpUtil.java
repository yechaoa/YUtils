package com.yechaoa.yutils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yechao on 2017/9/11.
 * Describe : SpUtil
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
public class SpUtil {

    private static final String FILE_NAME = "config";
    private static SharedPreferences sp = YUtils.getApplication().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

    /**
     * String
     */
    public static void setString(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    public static String getString(String key) {
        return sp.getString(key, "");
    }

    /**
     * Int
     */
    public static void setInt(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    public static int getInt(String key) {
        return sp.getInt(key, 0);
    }

    /**
     * Boolean
     */
    public static void setBoolean(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    /**
     * Float
     */
    public static void setFloat(String key, Float value) {
        sp.edit().putFloat(key, value).apply();
    }

    public static Float getFloat(String key) {
        return sp.getFloat(key, 0);
    }

    /**
     * Long
     */
    public static void setLong(String key, Long value) {
        sp.edit().putLong(key, value).apply();
    }

    public static Long getLong(String key) {
        return sp.getLong(key, 0);
    }

    /**
     * Remove
     */
    public static void removeByKey(String key) {
        sp.edit().remove(key).apply();
    }

    public static void removeAll() {
        sp.edit().clear().apply();
    }

}
