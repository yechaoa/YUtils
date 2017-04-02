# YUtils
# Android快速开发工具集合——YUtils

How to

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}Copy
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.bige-ye:YUtils:1.0'
	}
  
  
#### 1.初始化
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YUtils.setActivity(this);
       
只需要在onCreate中添加YUtils.setActivity(this);即可（类似ButterKnife.bind(this);）。<br>
  一次即可，如果继承的是BaseActivity，只需要添加一次。
#### 2.使用
一行代码即可<br>
比如：<br>
YUtils.setString("YUtils","android快速开发工具集合");<br>
YUtils.i(YUtils.getScreenWidth()+"");
#### 3.功能
* void setActivity(Activity act)<br>初始化，传入当前Activity   

* Activity getActivity()<br>获取当前Activity对象  

* void setString(String key, String value)<br>setString
* String getString(String key)<br>getString
* void setInt(String key, int value)<br>setInt
* int getInt(String key)<br>getInt
* void setBoolean(String key, boolean value)<br>setBoolean
* boolean getBoolean(String key)<br>getBoolean
* void removeString(String key)<br>根据key值移除value
* void removeAll(String key)<br>移除所有
* void i(String msg)<br>Log 打印  不带Tag参数的
* void e(String msg)<br>
* void i(String tag,String msg)<br>Log 打印  带Tag参数的
* void e(String tag,String msg)<br>
* int getScreenWidth()<br>获取屏幕宽度
* int getScreenHeight()<br>获取屏幕高度
* void showLoading(String msg)<br>Loading加载框
* void dismissLoading()<br>dismissLoading
* void finishBySleep(final long millis)<br>根据时间休眠然后关闭当前页面,比如：5秒自动返回,或者只需要后台给一个结果而已
* String getVersionName()<br>获取版本名
* int getVersionCode()<br>获取版本号
* boolean checkPhoneNumber(String mobiles)<br>校验手机号
* String MD5(String data)<br>MD5加密
* int dp2px(float dp)<br>dp2px
* float px2dp(int px)<br>px2dp
* void copyToClipboard(String text)<br>复制文本到粘贴板
* boolean isNetWorkAvailable()<br>判断网络状态
* void showCenterToast(final String msg)<br>showCenterToast 居中显示，短时间显示
* void showTopToast(final String msg)<br>顶部显示
* void showBottomToast(final String msg)<br>底部显示(默认)
* void showCenterLongToast(final String msg)<br>showCenterLongToast，长时间显示
* void showTopLongToast(final String msg)<br>showTopLongToast
* void showBottomLongToast(final String msg)<br>showBottomLongToast
* void cancelToast()<br>取消Toast，onDestroy时调用，或者onPause，当前页面finish之后在下一个页面不会再显示
 <br>  
 
 我的博客：http://blog.csdn.net/yechaoa  
 
 	我的邮箱：best_yc@163.com  
<br><br>
#### MIT License

Copyright (c) 2017 bige-ye

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
