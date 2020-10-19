package com.yechaoa.app

import android.app.Application
import com.yechaoa.yutilskt.LogUtil
import com.yechaoa.yutilskt.YUtils

/**
 * Created by yechao on 2020/1/7/007.
 * Describe :
 */
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        YUtils.init(this)
        LogUtil.setIsLog(true)
    }

}