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
object SpUtilKt {
    private const val FILE_NAME = "config"
    private val sp: SharedPreferences = YUtilsKt.getApplication()!!.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    /**
     * String
     */
    fun setString(key: String?, value: String?) {
        sp.edit().putString(key, value).apply()
    }

    fun getString(key: String?): String {
        return sp.getString(key, "")
    }

    /**
     * Int
     */
    fun setInt(key: String?, value: Int) {
        sp.edit().putInt(key, value).apply()
    }

    fun getInt(key: String?): Int {
        return sp.getInt(key, 0)
    }

    /**
     * Boolean
     */
    fun setBoolean(key: String?, value: Boolean) {
        sp.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String?): Boolean {
        return sp.getBoolean(key, false)
    }

    /**
     * Float
     */
    fun setFloat(key: String?, value: Float?) {
        sp.edit().putFloat(key, value!!).apply()
    }

    fun getFloat(key: String?): Float {
        return sp.getFloat(key, 0f)
    }

    /**
     * Long
     */
    fun setLong(key: String?, value: Long?) {
        sp.edit().putLong(key, value!!).apply()
    }

    fun getLong(key: String?): Long {
        return sp.getLong(key, 0)
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