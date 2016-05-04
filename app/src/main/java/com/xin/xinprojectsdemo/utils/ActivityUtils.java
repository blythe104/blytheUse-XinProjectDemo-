package com.xin.xinprojectsdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class ActivityUtils {

    private final static String PARAMS = "keyvalue";

    private static List<Activity> mActivityList = new ArrayList<Activity>();

    public static void startActivityLeftOutRightInWithFinish(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
        ((Activity) context).finish();
    }

    public static void startActivityLeftOutRightIn(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    public static void startActivityLeftInRightOutWithFinish(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
        ((Activity) context).finish();
    }

    public static void startActivityLeftInRightOut(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    public static void finishActivityLeftInRightOutWithFinish(Context context) {
        ((Activity) context).finish();
    }

    public static void finishActivityRightInLeftOutWithFinish(Context context) {
        ((Activity) context).finish();
    }

    public static void finishActivityLeftInRightOut(Context context) {
    }

    /**
     * 收集开启的Activity
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.add(activity);
        }
    }

    /**
     * 回收开启的Activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        if (mActivityList.contains(activity)) {
            mActivityList.remove(activity);
        }
    }

    /**
     * 销毁所有的Activity
     */
    public static void finishAllActivity() {
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing())
                activity.finish();
        }
    }
}
