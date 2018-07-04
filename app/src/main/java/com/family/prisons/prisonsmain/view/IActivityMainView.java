package com.family.prisons.prisonsmain.view;

import com.family.prisons.prisonsdata.entitycalllnformation.EntitySignIn;

import jx.vein.javajar.JXFVJavaInterface;

/**
 * Created by ThinkPad on 2018/6/13.
 */

public interface IActivityMainView {
    /**
     * 描述：加载视图
     */
    void displayview();

    /**
     * 描述：弹出框
     */

    void ejectview();

    /**
     * 描述：初始化usb
     */
    void jxfvview();

    /**
     * 描述：加载
     */

    void setLoad();
    /**
     * 描述：关闭加载
     */
    void setCloseLoad(int cod);
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
    void jxIsVeinImgOK(long usb, JXFVJavaInterface mJxfvJavaInterface, byte[] jxc);

    /**
     * 描述：收集样本
     */
    void jxLoadVeinSample(long usb, JXFVJavaInterface mJxfvJavaInterface, byte[] jxc);
    /**
     * 描述：登陆
     */
    void setSignIn(EntitySignIn entitySignIn);
}
