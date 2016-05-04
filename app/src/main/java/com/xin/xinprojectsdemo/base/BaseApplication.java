package com.xin.xinprojectsdemo.base;

import android.app.Activity;
import android.app.Application;

import com.xin.xinprojectsdemo.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;


public class BaseApplication extends Application {

    // define mActivityList to restore activities
    public List<BaseActivity> mActivityList = new ArrayList<BaseActivity>();

    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        if (null == instance) {
            instance = new BaseApplication();
        }
        return instance;
    }

    // add Activity to mActivityList
    public void addActivity(BaseActivity activity) {
        ActivityUtils.addActivity(activity);
    }

    public void removeActivity(BaseActivity activity){
        ActivityUtils.removeActivity(activity);
    }

    // finish activity from mActivityList
    public void finishActivities() {
        ActivityUtils.finishAllActivity();
    }

    // exit application to destory activities
    public void exit() {
        try {
            for (Activity activity : mActivityList) {
                if (null != activity)
                    activity.finish();
            }
        } catch (Exception e) {

        } finally {
            System.exit(0);
        }
    }

}
