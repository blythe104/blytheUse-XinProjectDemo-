package com.xin.xinprojectsdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * ==============================================
 * <p/>
 * 版权：欣
 * <p/>
 * 作者：孟欣
 * <p/>
 * 版本： 1.0
 * <p/>
 * 创建日期：
 * <p/>
 * 描述：sp的工具类，缓存数据工具类
 * <p/>
 * 修订历史：
 * <p/>
 * ==============================================
 **/
public class SharedPreferencesUtils {
    //将可变的内容设置到一块，这这样可以更简便的更改
    public static final String SP_NAME = "config";
    private static SharedPreferences sp;

    public static void saveString(Context context, String key, String value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getString(key, defValue);
    }


    public static void saveBoolean(Context context, String key, boolean value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getBoolean(key, defValue);
    }


    public static void saveInt(Context context, String key, int value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getInt(key, defValue);
    }
}
