package com.yechaoa.yutilskt

import android.util.Log

/**
 * Created by yechao on 2020/1/7.
 * Describe : 日志管理
 *
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */
object LogUtil {
    private var TAG = "LogUtil"
    private var IS_LOG = false
    private const val MAX_LENGTH = 4000

    /**
     * 设置是否开启打印
     */
    fun setIsLog(isLog: Boolean) {
        IS_LOG = isLog
    }

    fun setIsLog(isLog: Boolean, tag: String) {
        TAG = tag
        IS_LOG = isLog
    }

    fun i(msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfos
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun i(tag: String?, msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfos
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.i(tag, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.i(tag, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun d(msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfos
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.d(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.d(TAG, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun d(tag: String?, msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfos
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.d(tag, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.d(tag, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun e(msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfos
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun e(tag: String?, msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfos
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.e(tag, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.e(tag, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    /**
     * 获取打印信息所在方法名，行号等信息
     */
    private val autoJumpLogInfos: Array<String>
        get() {
            val infos = arrayOf("", "", "")
            val elements = Thread.currentThread().stackTrace
            infos[0] = elements[4].className.substring(elements[4].className.lastIndexOf(".") + 1)
            infos[1] = elements[4].methodName
            infos[2] = "(" + elements[4].fileName + ":" + elements[4].lineNumber + ")"
            return infos
        }
}