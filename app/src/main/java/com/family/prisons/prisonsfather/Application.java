package com.family.prisons.prisonsfather;

import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public class Application extends BaseApplication {
    public static Application mApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
    }
    /*@坚决依赖太多:超出65536*/
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    /** 获取Application */
    public static Application getInstance() {
        return mApplication;
    }
}
