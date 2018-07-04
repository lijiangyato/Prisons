package com.family.prisons.prisonsmain.presenter;

import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entitycalllnformation.EntitySignIn;

import jx.vein.javajar.JXFVJavaInterface;

/**
 * Created by ThinkPad on 2018/6/14.
 */

public interface IPresenterMain {
    void displaypresenter();

    /**
     * 描述：登陆
     */

    void getSignIn(String token, String dwdm, String prisonAreaCode, String loginRole, String loginData);

    /**
     * 描述：检查指静脉是否存在
     */
    void jxIsFVDConnected(long usb, JXFVJavaInterface mJxfvJavaInterface);

    /**
     * 描述：连接设备是否成功
     */
    void jxConnFVD(long usb, JXFVJavaInterface mJxfvJavaInterface);

    /**
     * 描述：检查手指是否存在
     */
    void jxIsFingerDetected(long usb, JXFVJavaInterface mJxfvJavaInterface);

    /**
     * 描述：初始化
     */
    void jxInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface);

    /**
     * 描述复位
     */
    void jxDeInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface);

    /**
     * 描述：采集数据
     */
    void jxIsVeinImgOK(long usb, JXFVJavaInterface mJxfvJavaInterface);

    /**
     * 描述：收集样本
     */
    void jxLoadVeinSample(long usb, JXFVJavaInterface mJxfvJavaInterface);


}
