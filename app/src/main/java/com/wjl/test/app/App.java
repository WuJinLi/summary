package com.wjl.test.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * author: WuJinLi
 * time  : 2018/12/26
 * desc  :
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }
}
