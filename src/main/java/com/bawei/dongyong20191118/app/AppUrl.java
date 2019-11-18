package com.bawei.dongyong20191118.app;

import android.app.Application;
import android.content.Context;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 8:53
 * @Description:
 */
public class AppUrl extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
