# Android快速开发工具集合——YUtils

[![](https://jitpack.io/v/yechaoa/YUtils.svg)](https://jitpack.io/#yechaoa/YUtils)
![](https://img.shields.io/badge/language-Java%20&%20kotlin-orange.svg)
![](https://img.shields.io/hexpm/l/plug.svg)

最近更新 2020.1.26

### How to use

- Step 1  project：build.gradle

```
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```
- Step 2  app：build.gradle（以下3种引用方式，三选一即可）
```
dependencies {
    //kotlin 版本
    implementation 'com.github.yechaoa.YUtils:yutilskt:3.1.6'

    //java 版本
    implementation 'com.github.yechaoa.YUtils:yutils:3.1.6'

    //kotlin && java 版本
    implementation 'com.github.yechaoa:YUtils:3.1.6'
}
```


# 一、初始化
#### in your Application

```
//初始化
YUtils.init(this);

//打印开关（可选，默认false不打印）
LogUtil.setIsLog(true);
```

# 二、功能

> ## 1.YUtils（各种小工具）

* void init(Application app)<br>Application 中初始化

* Application getApp()<br>获取全局上下文

* void showLoading(Activity activity,String msg)<br>Loading加载框

* void hideLoading()<br>hideLoading

* boolean loadingIsShowing()<br>loading是否显示

* void finishBySleep(final long millis)<br>根据时间休眠然后关闭当前页面,比如：3秒自动返回

* String getVersionName()<br>获取版本名

* int getVersionCode()<br>获取版本号

* boolean checkPhoneNumber(String number)<br>校验手机号

* String MD5(String data)<br>MD5加密

* void copyToClipboard(String text)<br>复制文本到粘贴板

* View foreground(View view, int color, int start, int end)<br>字体高亮（TextView、EditText、Button）like this ---> YUtils.foreground(mEditText, Color.RED,1,2);

* void showSoftKeyboard(View view)<br>弹出软键盘

* void closeSoftKeyboard()<br>关闭软键盘

* Boolean hasSim()<br>是否有sim卡 即设备是否可以拨打电话等
 
> ## 2.ToastUtil（任意线程，不重复显示，可取消）.

* show(final String msg)<br>底部显示(默认)，任何线程且不会超长显示

* void showCenter(final String msg)<br>showCenter 居中显示

* void cancel()<br>取消Toast，onDestroy时调用，或onPause，当前页面finish之后在下一个页面不会再显示
 
 
> ## 3.LogUtil（日志打印，带方法行数链接，可超长打印）

* void setIsLog(boolean isLog)<br>是否打印

* setIsLog(boolean isLog, String tag)<br>带全局tag

* void i(String msg)<br>不带tag

* void i(String TAG, String msg)<br> 带tag

* void d(String msg)<br>

* void d(String TAG, String msg)<br>

* void e(String msg)<br> 

* void e(String TAG, String msg)<br> 


> ## 4.ActivityUtil（Activity管理）

* Activity getCurrentActivity()<br> 获得当前栈顶Activity

* String getCurrentActivityName()<br> 获得当前Activity名字

* void start(Class<?> targetActivity)<br> 启动指定Activity 无参

* void start(Class<?> targetActivity, Bundle bundle)<br> 启动指定Activity，带Bundle参数（kotlin调用参数可选）

* void finish(Activity activity)<br> 关闭指定Activity

* void closeAllActivity()<br> 关闭所有Activity


> ## 5.SpUtil（SharedPreferences）

* void setString(String key, String value)<br> String

* String getString(String key)<br>

* void setStringSet(String key, Set<String> value)<br> StringSet

* Set<String> getStringSet(String key)<br>

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


> ## 6.ShareUtil（调用系统分享）

* void shareImage(String title, Uri uri)<br> 分享图片

* void shareText(String title, String text)<br> 分享文字


> ## 7.TimeUtil

* String getDate()<br> 获取当前年月日

* String getTime()<br> 获取当前时分秒

* String getDateAndTime()<br> 获取当前年月日时分秒

* Long getTimeForLong()<br> 获取当前时间，返回Long类型

* String formatDate(String mDate)<br> 转换为年月日

> ## 8.ParseUtil（直接解析 Json）

2.0.8版本之后简化了解析方式，且不兼容更新

like this
```
{
     "code": "0",
     "data": "修改成功",
     "flag": true,
     "info": null
 }
```
* String parseCode(String response)<br> 解析Code

* boolean parseFlag(String response)<br> 解析Flag

* String parseData(String response)<br> 解析data

* String parseInfo(String response)<br> 解析info

* String parseByKey(String response, String key)<br> 根据key值解析，只支持json中的一级字段


> ## 9.GsonUtil

* String GsonString(Object object)<br> 转成json

* <T> T GsonToBean(String gsonString, Class<T> cls) <br> 转成bean

* <T> List<T> GsonToList(String gsonString, Class<T> cls)<br> 转成list

* <T> GsonToMaps(String gsonString)

> ## 10.DisplayUtil

* int dp2px(float dp)<br>dp2px

* float px2dp(int px)<br>px2dp

* int getScreenWidth()<br>获取屏幕宽度

* int getScreenHeight()<br>获取屏幕高度

* int getStatusBarHeight()<br>获取状态栏高度

* int getActionBarHeight()<br>获取ActionBar高度

* int getNavBarHeight()<br>获取导航栏高度


 <br> 
 
## 更新记录

#### 3.1.6（2021-01-26）
- targetSdkVersion 30
- ToastUtil适配Android 11

#### 3.1.5（2020-12-29）
- 初始化校验
- YUtils新增sim卡判断

#### 3.1.4（2020-12-26）
- SpUtil优化

#### 3.1.3（2020-10-30）
- 添加DisplayUtil
- 优化。

#### 3.1.2 (2020-10-22)
优化。

#### 3.1.1
优化引用方式，可以kotlin和java分开引用，也可以一起引用。

#### 3.1.0
简化了部分util原有的调用方式，属于兼容更新。

#### 3.0.0
- 3.0.0以后新增了`kotlin`版本；
- 此外，java版本和kotlin版本都删除了`ExitUtils`；
- kotlin版本没有`GsonUtil`；


### 混淆

```
#YUtils
-keep class com.yechaoa.yutils.**{*;}
```

 <br>  
 
# 关于
 
- 我的博客：http://blog.csdn.net/yechaoa  
- 我的邮箱：best_yc@163.com  


<br><br>


### License

```
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
```
