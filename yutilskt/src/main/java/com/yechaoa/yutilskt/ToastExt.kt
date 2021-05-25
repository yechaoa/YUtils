package com.yechaoa.yutilskt

import android.widget.Toast

/**
 * Created by yechao on 2021/5/25.
 * Describe : Toast 扩展
 *  "111".show() -> 111
 *  111.show() -> 111
 *  111.show("222") -> 222
 */
fun Any.show(msg: String = this.toString(), duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(YUtils.getAppContext(), msg, duration).show()
}