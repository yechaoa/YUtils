package com.yechaoa.yutils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yechao on 2017/3/21.
 * Describe : 直接解析 Json
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

public class ParseUtil {

    /**
     * {
     * "code": "0",
     * "data": "修改成功",
     * "flag": true,
     * "info": null,
     * "infoValues": null
     * }
     */

    //解析Code
    public static String parseCode(String response) {
        String code = "";
        try {
            JSONObject json = new JSONObject(response);
            code = json.getString("code");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return code;
    }

    //解析Flag
    public static boolean parseFlag(String response) {
        boolean flag = false;
        try {
            JSONObject json = new JSONObject(response);
            flag = json.getBoolean("flag");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //解析data
    public static String parseData(String response, String key) {
        String data = "";
        try {
            JSONObject json = new JSONObject(response);
            data = json.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

}
