package com.family.prisons.prisonsdata.model;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.IUnifiedDataListenerUsb;
import com.family.prisons.prisonsdata.entityupload.EntityToUpdate;

import jx.vein.javajar.JXFVJavaInterface;

public interface IModelUsb extends IProvider {

    /**
     * 描述：检查指静脉是否存在
     */
    void jxIsFVDConnected(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener);

    /**
     * 描述：连接设备是否成功
     */
    void jxConnFVD(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener);

    /**
     * 描述：检查手指是否存在
     */
    void jxIsFingerDetected(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener);

    void jxIsFingerTouched(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener);

    /**
     * 描述：初始化
     */
    void jxInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener);

    /**
     * 描述复位
     */
    void jxDeInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener);

    /**
     * 描述：采集数据
     */
    void jxIsVeinImgOK(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener);

    /**
     * 描述：收集样本
     */
    void jxLoadVeinSample(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener);
}
