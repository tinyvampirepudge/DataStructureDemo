package com.tongtong.tiny.datastructureapplication.app;

import android.app.Application;
import android.content.Context;

import com.tongtong.tiny.datastructureapplication.util.LogUtils;


/**
 * Desc:
 *
 * @author tiny
 * @date 2018/5/29 下午9:11
 */

public class MyApplication extends Application {
    private static Context instance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance = this;
    }

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        LogUtils.openLog(true);
    }
}
