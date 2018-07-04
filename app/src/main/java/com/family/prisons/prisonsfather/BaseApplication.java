package com.family.prisons.prisonsfather;


import android.support.multidex.MultiDexApplication;
import com.alibaba.android.arouter.launcher.ARouter;
import com.family.prisons.prisonshttp.HttpRetrofit;



/**
 * Created by ThinkPad on 2018/6/11.
 */

public class BaseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //路由
        initARouter();
        //网络
        initNet();
        //activity右滑动
        initBGASwipeBackManager();
    }

    /*初始化activity右滑关闭页面*/
    private void initBGASwipeBackManager() {
     //   BGASwipeBackManager.getInstance().init(this);
    }

    /*初始化ARouter*/
    private void initARouter() {
        //打印日志
        ARouter.openLog();
        if (true){
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
            ARouter.init(this);
        }
    }
    /*初始化网络*/
    private void initNet() {
       HttpRetrofit.init((Application) this);
    }

}
