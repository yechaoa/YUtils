package com.yechaoa.yutils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by yechao on 2017/3/21.
 * Describe : ExitUtils
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

public class GsonUtil {

    private static Gson gson = null;

    public GsonUtil() {
    }

    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }

        return gsonString;
    }

    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }

        return t;
    }

    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = (List) gson.fromJson(gsonString, (new TypeToken<List<T>>() {
            }).getType());
        }

        return list;
    }

    public <T> List<T> jsonToList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList();
        JsonArray array = (new JsonParser()).parse(json).getAsJsonArray();
        Iterator var6 = array.iterator();

        while (var6.hasNext()) {
            JsonElement elem = (JsonElement) var6.next();
            list.add(gson.fromJson(elem, cls));
        }

        return list;
    }

    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = (Map) gson.fromJson(gsonString, (new TypeToken<Map<String, T>>() {
            }).getType());
        }

        return map;
    }

    static {
        if (gson == null) {
            gson = new Gson();
        }

    }
}
