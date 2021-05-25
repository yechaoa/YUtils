package com.yechaoa.app

import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.yechaoa.yutilskt.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_view).setOnClickListener {
            YUtils.showLoading(this, "加载中")
        }

        btn_log.setOnClickListener {
            LogUtil.d(getString(R.string.large_text))
        }

        val set = HashSet<String>()
        val array = arrayListOf("1", "2", "3")
        for (i in array.indices) {
            println(array[i])
            set.add("-----" + array[i])
        }

        button.setOnClickListener {
            SpUtil.setStringSet("testStringSet", set)
        }

        button2.setOnClickListener {
            val stringSet = SpUtil.getStringSet("testStringSet")
            LogUtil.i(stringSet.toString())
        }

        showLoading.setOnClickListener {
            YUtils.showLoading(this, "test")
            LogUtil.i("" + YUtils.loadingIsShowing())
        }

        hideLoading.setOnClickListener {
            ToastUtil.show("取消loading")
            YUtils.hideLoading()
            LogUtil.i("" + YUtils.loadingIsShowing())
            LogUtil.i("" + ActivityUtil.currentActivityName)
        }

        btn_display.setOnClickListener {
            LogUtil.i("" + DisplayUtil.getStatusBarHeight() + "---" + DisplayUtil.getScreenHeight())
            LogUtil.i("" + DisplayUtil.getActionBarHeight() + "---" + DisplayUtil.getNavBarHeight())
        }

        btn_sim.setOnClickListener {
            ToastUtil.show(if (YUtils.hasSim()) "有sim卡" else "无sim卡")
        }

        btn_thread.setOnClickListener {
            LogUtil.d("" + mainLooper.isCurrentThread)
            LogUtil.d("" + Looper.myLooper()!!.isCurrentThread)
            val b = mainLooper == Looper.myLooper()
            LogUtil.d("" + b)
            thread {
                ToastUtil.show("213")
            }

        }

    }
}
