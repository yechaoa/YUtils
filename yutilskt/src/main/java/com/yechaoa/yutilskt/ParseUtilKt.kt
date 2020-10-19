package com.yechaoa.yutilskt

import org.json.JSONException
import org.json.JSONObject

/**
 * Created by yechao on 2020/1/7.
 * Describe : 直接解析 Json
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object ParseUtilKt {
    /**
     * {
     * "code": "0",
     * "data": "修改成功",
     * "flag": true,
     * "info": null
     * }
     */

    /**
     * 解析Code
     */
    fun parseCode(response: String?): String {
        var code = ""
        try {
            val json = JSONObject(response)
            code = json.getString("code")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return code
    }

    /**
     * 解析Flag
     */
    fun parseFlag(response: String?): Boolean {
        var flag = false
        try {
            val json = JSONObject(response)
            flag = json.getBoolean("flag")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return flag
    }

    /**
     * 解析data
     */
    fun parseData(response: String?): String {
        var data = ""
        try {
            val json = JSONObject(response)
            data = json.getString("data")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    /**
     * 解析info
     */
    fun parseInfo(response: String?): String {
        var info = ""
        try {
            val json = JSONObject(response)
            info = json.getString("info")
        } catch (`var`: JSONException) {
            `var`.printStackTrace()
        }
        return info
    }

    /**
     * 根据key值解析，只支持json中的一级字段
     */
    fun parseByKey(response: String?, key: String?): String {
        var value = ""
        try {
            val json = JSONObject(response)
            value = json.getString(key)
        } catch (`var`: JSONException) {
            `var`.printStackTrace()
        }
        return value
    }
}