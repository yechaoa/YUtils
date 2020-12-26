package com.yechaoa.yutilskt

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by yechao on 2020/1/7.
 * Describe : SpUtilKt
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object SpUtil {
    private const val FILE_NAME = "config"
    private val sp: SharedPreferences = YUtils.getApp().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    /**
     * String
     */
    fun setString(key: String?, value: String?) {
        sp.edit().putString(key, value).apply()
    }

    fun getString(key: String?, defValue: String = ""): String {
        return sp.getString(key, defValue)
    }

    /**
     * StringSet
     */
    fun setStringSet(key: String?, value: Set<String>?) {
        sp.edit().putStringSet(key, value).apply()
    }

    fun getStringSet(key: String?): Set<String> {
        return HashSet<String>(sp.getStringSet(key, HashSet<String>()))
    }

    /**
     * Int
     */
    fun setInt(key: String?, value: Int) {
        sp.edit().putInt(key, value).apply()
    }

    fun getInt(key: String?, defValue: Int = 0): Int {
        return sp.getInt(key, defValue)
    }

    /**
     * Boolean
     */
    fun setBoolean(key: String?, value: Boolean) {
        sp.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String?, defValue: Boolean = false): Boolean {
        return sp.getBoolean(key, defValue)
    }

    /**
     * Float
     */
    fun setFloat(key: String?, value: Float?) {
        sp.edit().putFloat(key, value!!).apply()
    }

    fun getFloat(key: String?, defValue: Float = 0f): Float {
        return sp.getFloat(key, defValue)
    }

    /**
     * Long
     */
    fun setLong(key: String?, value: Long?) {
        sp.edit().putLong(key, value!!).apply()
    }

    fun getLong(key: String?, defValue: Long = 0): Long {
        return sp.getLong(key, defValue)
    }

    /**
     * Remove
     */
    fun removeByKey(key: String?) {
        sp.edit().remove(key).apply()
    }

    fun removeAll() {
        sp.edit().clear().apply()
    }
}