package com.yechaoa.app

import android.app.Application
import com.yechaoa.yutilskt.ActivityUtilKt
import com.yechaoa.yutilskt.LogUtilKt
import com.yechaoa.yutilskt.YUtilsKt

/**
 * Created by yechao on 2020/1/7/007.
 * Describe :
 */
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        YUtilsKt.init(this)
        LogUtilKt.setIsLog(true)
    }

}