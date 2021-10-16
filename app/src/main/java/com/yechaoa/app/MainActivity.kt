package com.yechaoa.app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yechaoa.app.databinding.ActivityMainBinding
import com.yechaoa.yutilskt.*


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        findViewById<TextView>(R.id.text_view).setOnClickListener {
            YUtils.showLoading(this, "加载中")
        }

        mBinding.btnLog.setOnClickListener {
            LogUtil.d(getString(R.string.large_text))
        }

        val set = HashSet<String>()
        val array = arrayListOf("1", "2", "3")
        for (i in array.indices) {
            println(array[i])
            set.add("-----" + array[i])
        }

        mBinding.button.setOnClickListener {
            SpUtil.setStringSet("testStringSet", set)
            //SpUtil.getBoolean("111",true)
        }

        mBinding.button2.setOnClickListener {
            val stringSet = SpUtil.getStringSet("testStringSet")
            LogUtil.i(stringSet.toString())
        }

        mBinding.showLoading.setOnClickListener {
            YUtils.showLoading(this, "test")
            LogUtil.i("" + YUtils.loadingIsShowing())
        }

        mBinding.hideLoading.setOnClickListener {
            ToastUtil.show("取消loading")
            YUtils.hideLoading()
            LogUtil.i("" + YUtils.loadingIsShowing())
            LogUtil.i("" + ActivityUtil.currentActivityName)
        }

//        ActivityUtil.start(MainActivity::class.java)
//        ActivityUtil.finish(this)

        mBinding.btnDisplay.setOnClickListener {
            LogUtil.i("" + DisplayUtil.getStatusBarHeight() + "---" + DisplayUtil.getScreenHeight())
            LogUtil.i("" + DisplayUtil.getActionBarHeight() + "---" + DisplayUtil.getNavBarHeight())
        }

        mBinding.btnSim.setOnClickListener {
            ToastUtil.show(if (YUtils.hasSim()) "有sim卡" else "无sim卡")
        }
    }
}
