package com.yechaoa.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.yechaoa.yutilskt.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_view).setOnClickListener {
            YUtilsKt.showLoading(this, "加载中")
        }


        val set = HashSet<String>()
        val array = arrayListOf("1", "2", "3")
        for (i in array.indices) {
            println(array[i])
            set.add("-----" + array[i])
        }

        button.setOnClickListener {
            SpUtilKt.setStringSet("testStringSet", set)
        }

        button2.setOnClickListener {
            val stringSet = SpUtilKt.getStringSet("testStringSet")
            LogUtilKt.i(stringSet.toString())
        }

        showLoading.setOnClickListener {
            YUtilsKt.showLoading(this, "test")
            LogUtilKt.i("" + YUtilsKt.loadingIsShowing())
        }

        hideLoading.setOnClickListener {
            ToastUtilKt.show("取消loading")
            YUtilsKt.hideLoading()
            LogUtilKt.i("" + YUtilsKt.loadingIsShowing())
            LogUtilKt.i("" + ActivityUtilKt.currentActivityName)
        }
    }
}
