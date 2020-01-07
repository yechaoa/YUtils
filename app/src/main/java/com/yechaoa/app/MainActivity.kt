package com.yechaoa.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.yechaoa.yutils.YUtils
import com.yechaoa.yutilskt.YUtilsKt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_view).setOnClickListener {
            YUtilsKt.showLoading(this,"加载中")
        }

    }
}
