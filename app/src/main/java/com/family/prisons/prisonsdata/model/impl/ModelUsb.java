package com.family.prisons.prisonsdata.model.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.library.librarythread.UtilsThread;
import com.family.prisons.prisonsdata.IUnifiedDataListenerUsb;
import com.family.prisons.prisonsdata.model.IModelUsb;
import com.socks.library.KLog;

import jx.vein.javajar.JXFVJavaInterface;

@Route(path = "/prisonsdata/model/ModelUsb", name = "")
public class ModelUsb implements IModelUsb {

    @Override
    public void init(Context context) {

    }

    @Override
    public void jxIsFVDConnected(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener) {
        if (mJxfvJavaInterface.jxIsFVDConnected(usb) == 1) {
            iUnifiedDataListener.success(usb, mJxfvJavaInterface);
        } else {
            iUnifiedDataListener.fail(mJxfvJavaInterface.jxIsFVDConnected(usb), "未检测到手指静脉设备 ");
        }
    }

    @Override
    public void jxConnFVD(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener) {
        if (mJxfvJavaInterface.jxConnFVD(usb) == 0) {
            iUnifiedDataListener.success(usb, mJxfvJavaInterface);
        } else {
            iUnifiedDataListener.fail(mJxfvJavaInterface.jxConnFVD(usb), "未检测到手指静脉设备 ");
        }
    }

    @Override
    public void jxIsFingerDetected(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener) {
        mJxfvJavaInterface.jxIsFingerDetected(usb);
        iUnifiedDataListener.success(usb, mJxfvJavaInterface);
    }

    @Override
    public void jxIsFingerTouched(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener) {

    }

    @Override
    public void jxInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener) {

        if (mJxfvJavaInterface.jxInitCapEnv(usb) == 0) {
            iUnifiedDataListener.success(usb, mJxfvJavaInterface);
        } else {
            iUnifiedDataListener.fail(mJxfvJavaInterface.jxInitCapEnv(usb), "出现错误");
        }
    }

    @Override
    public void jxDeInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener) {
        if (mJxfvJavaInterface.jxDeInitCapEnv(usb) == 0) {
            iUnifiedDataListener.success(usb, mJxfvJavaInterface);
        } else {
            iUnifiedDataListener.fail(mJxfvJavaInterface.jxDeInitCapEnv(usb), "出现错误");
        }
    }

    @Override
    public void jxIsVeinImgOK(final long usb, final JXFVJavaInterface mJxfvJavaInterface, final IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener) {

        int featuresize = mJxfvJavaInterface.veinImgSize;
        final byte[] featuredata = new byte[featuresize];
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    boolean biang = true;
                    while (biang == true) {
                        int eru = mJxfvJavaInterface.jxIsVeinImgOK(usb, featuredata);
                        switch (eru) {
                            case 0:
                                KLog.a("00000000000000", "0000000000000000");
                                break;
                            case 1:
                                KLog.a("00000000000000", "1111111111111111");
                                break;
                            case 2:
                                if (featuredata != null) {
                                    iUnifiedDataListener.byt(usb, mJxfvJavaInterface, featuredata);
                                    biang = false;
                                    KLog.a("22222222222222222", "22222222222222222222222222");
                                }
                                break;
                            case 3:
                                KLog.a("00000000000000", "33333333333333333333333");
                                break;
                            case -100:
                                KLog.a("00000000000000", "10000000000000000000");
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
    @Override
    public void jxLoadVeinSample(long usb, JXFVJavaInterface mJxfvJavaInterface, IUnifiedDataListenerUsb<Long, JXFVJavaInterface> iUnifiedDataListener) {
        int featuresize = mJxfvJavaInterface.veinSampleSize;
        byte[] featuredata = new byte[featuresize];
        try {
            mJxfvJavaInterface.jxLoadVeinSample(usb, featuredata);
            if (featuredata != null) {
                iUnifiedDataListener.byt(usb, mJxfvJavaInterface, featuredata);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
