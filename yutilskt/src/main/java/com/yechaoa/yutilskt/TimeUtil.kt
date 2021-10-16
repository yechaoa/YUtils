package com.yechaoa.yutilskt

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by yechao on 2020/1/7.
 * Describe : 日期
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object TimeUtil {
    /**
     * 获取当前年月日
     */
    val date: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = Date()
            return sdf.format(date)
        }

    /**
     * 获取当前时分秒
     */
    val time: String
        get() {
            val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val date = Date()
            return sdf.format(date)
        }

    /**
     * 获取当前年月日时分秒
     */
    val dateAndTime: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val date = Date(System.currentTimeMillis())
            return sdf.format(date)
        }

    /**
     * 获取当前时间，返回Long类型
     */
    val timeForLong: Long
        get() = System.currentTimeMillis()

    /**
     * 转换为年月日
     */
    fun formatDate(mDate: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        var date: Date? = null
        try {
            date = sdf.parse(mDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return if (null != date) sdf.format(date) else ""
    }
}