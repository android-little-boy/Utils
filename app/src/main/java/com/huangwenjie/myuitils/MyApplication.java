package com.huangwenjie.myuitils;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static MyApplication application;

    //region 公有方法

    public static MyApplication getInstance() {
        return application;
    }
    @Override
    public void onCreate() {
        application = this;
        super.onCreate();
    }
    /**
     * 获取context
     *
     * @return Context上下文
     */
    public static Context getContext() {
        return application.getApplicationContext();
    }

}
