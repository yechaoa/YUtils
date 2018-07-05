# YUtils
# Android快速开发工具集合——YUtils
	
[![](https://jitpack.io/v/yechaoa/YUtils.svg)](https://jitpack.io/#yechaoa/YUtils)
![](https://img.shields.io/github/release/bige-ye/YUtils.svg)
![](https://img.shields.io/badge/language-java-orange.svg)
![](https://img.shields.io/hexpm/l/plug.svg)
![](https://img.shields.io/badge/to%20be%20happy-%E5%BC%80%E5%BF%83%E5%B0%B1%E5%A5%BD-green.svg)

How to use

Step 1  project：build.gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2  app：build.gradle

	dependencies {
	        implementation 'com.github.yechaoa:YUtils:2.0.9'
	}
  

## 一、初始化（init）
#### in your Application

> //初始化<br>
        YUtils.initialize(this);<br>
        //设置打印开关<br>
        LogUtil.setIsLog(true);<br>
        //注册Activity生命周期<br>
        registerActivityLifecycleCallbacks(ActivityUtil.getActivityLifecycleCallbacks());<br>

## 二、使用（use）

> ### 1.YUtils（各种小工具）

* void initialize(Application app)<br>Application 中初始化

* Application getApplication()<br>获取全局上下文  

* int getScreenWidth()<br>获取屏幕宽度

* int getScreenHeight()<br>获取屏幕高度

* void showLoading(String msg)<br>Loading加载框

* void showLoading(Activity activity,String msg)<br>比第一种多个参数，在不确定是否还有其他dialog的情况下，使用第二种

* void dismissLoading()<br>dismissLoading

* void finishBySleep(final long millis)<br>根据时间休眠然后关闭当前页面,比如：3秒自动返回

* String getVersionName()<br>获取版本名

* int getVersionCode()<br>获取版本号

* boolean checkPhoneNumber(String mobiles)<br>校验手机号

* String MD5(String data)<br>MD5加密

* int dp2px(float dp)<br>dp2px

* float px2dp(int px)<br>px2dp

* void copyToClipboard(String text)<br>复制文本到粘贴板

* View Foreground(View view, int color, int start, int end)<br>字体高亮（TextView、EditText、Button）like this ---》 YUtils.Foreground(mEditText, Color.RED,1,2);

* boolean isNetWorkAvailable()<br>判断网络状态

* void closeSoftKeyboard()<br>关闭软键盘
 
> ### 2.ToastUtil（任意线程，不重复显示，可取消）.

* showToast(final String msg)<br>底部显示(默认)，任何线程且不会超长显示

* void showCenterToast(final String msg)<br>showCenterToast 居中显示

* void cancelToast()<br>取消Toast，onDestroy时调用，或onPause，当前页面finish之后在下一个页面不会再显示
 
> ### 3.LogUtil（日志打印，带方法行数链接，可超长打印）

* void setIsLog(boolean isLog)<br>是否打印

* setIsLog(boolean isLog, String tag)<br>带全局tag

* void i(String msg)<br>不带tag

* void i(String TAG, String msg)<br> 带tag

* void d(String msg)<br>

* void d(String TAG, String msg)<br>

* void e(String msg)<br> 

* void e(String TAG, String msg)<br> 

> ### 4.ActivityUtil（Activity管理）

* Activity getCurrentActivity()<br> 获得当前栈顶Activity

* String getCurrentActivityName()<br> 获得当前Activity名字

* void finishActivity(Activity activity)<br> 关闭当前Activity

* void closeAllActivity()<br> 关闭所有Activity

> ### 5.SpUtil（SharedPreferences）

* void setString(String key, String value)<br> String

* String getString(String key)<br> 

* void setInt(String key, String value)<br> Int

* String getInt(String key)<br> 

* void setBoolean(String key, String value)<br> Boolean

* String getBoolean(String key)<br> 

* void setFloat(String key, String value)<br> Float

* String getFloat(String key)<br> 

* void setLong(String key, String value)<br> Long

* String getLong(String key)<br> 

* void removeByKey(String key)<br> 根据key移除

* void removeAll()<br> 移除所有

> ### 6.ShareUtil（调用系统分享）

* void shareImage(String title, Uri uri)<br> 分享图片

* void shareText(String title, String text)<br> 分享文字

> ### 7.TimeUtil

* String getDate()<br> 获取当前年月日

* String getTime()<br> 获取当前时分秒

* String getDateAndTime()<br> 获取当前年月日时分秒

* Long getTimeForLong()<br> 获取当前时间，返回Long类型

* String formatDate(String mDate)<br> 转换为年月日

> ### 8.ParseUtil（直接解析 Json）

like this
```
{
     "code": "0",
     "data": "修改成功",
     "flag": true,
     "info": null,
     "infoValues": null
 }
```
* String parseCode(String response)<br> 解析Code

* boolean parseFlag(String response)<br> 解析Flag

* String parseData(String response)<br> 解析data

* String parseInfo(String response)<br> 解析info

* String parseByKey(String response, String key)<br> 根据key值解析，只支持json中的一级字段

> ### 9.GsonUtil

* String GsonString(Object object)<br> 转成json

* <T> T GsonToBean(String gsonString, Class<T> cls) <br> 转成bean

* <T> List<T> GsonToList(String gsonString, Class<T> cls)<br> 转成list

* <T> GsonToMaps(String gsonString)

> ### 10.ExitUtils

like this 

```
 private ExitUtils exit = new ExitUtils();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            pressAgainExit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 双击返回键退出
     */
    private void pressAgainExit() {
        if (exit.isExit()) {
            ActivityUtil.closeAllActivity();
        } else {
            YUtils.showToast("再按一次退出");
            exit.doExitAction();
        }
    }
```


 <br>  
 
 我的博客：http://blog.csdn.net/yechaoa  
 
 	我的邮箱：best_yc@163.com  
<br><br>
#### License

   Copyright 2017 yechaoa

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
