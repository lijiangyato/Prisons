package com.family.prisons.prisonsmain.presenter.impl;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.IUnifiedDataListenerUsb;
import com.family.prisons.prisonsdata.entitycalllnformation.EntitySignIn;
import com.family.prisons.prisonsdata.model.IModelCalllnformation;
import com.family.prisons.prisonsdata.model.IModelRegistrationToken;
import com.family.prisons.prisonsdata.model.IModelUsb;
import com.family.prisons.prisonshttp.IHttpCallInformation;
import com.family.prisons.prisonsmain.presenter.IPresenterMain;
import com.family.prisons.prisonsmain.view.IActivityMainView;

import jx.vein.javajar.JXFVJavaInterface;

/**
 * Created by ThinkPad on 2018/6/14.
 */

public class PresenterMain  implements IPresenterMain{
    public IActivityMainView mIActivityMainView;
    @Autowired
    IModelUsb mIodelUsb;
    @Autowired
    IModelCalllnformation mIHttpCallInformationl;

    public PresenterMain(IActivityMainView iActivityMainView){
        this.mIActivityMainView=iActivityMainView;
        ARouter.getInstance().inject(this);

    }
    @Override
    public void displaypresenter() {
        mIActivityMainView.displayview();
    }

    @Override
    public void getSignIn(String token, String dwdm, String prisonAreaCode, String loginRole, String loginData) {
        mIHttpCallInformationl.getSignIn(token, dwdm, prisonAreaCode, loginRole, loginData, new IUnifiedDataListener<EntitySignIn>() {
            @Override
            public void success(EntitySignIn response) {
                mIActivityMainView.setSignIn(response);
            }

            @Override
            public void fail(int errCode, String msg) {

            }
        });
    }

    @Override
    public void jxIsFVDConnected(long usb, JXFVJavaInterface mJxfvJavaInterface) {
       mIodelUsb.jxIsFVDConnected(usb, mJxfvJavaInterface, new IUnifiedDataListenerUsb<Long, JXFVJavaInterface>() {
           @Override
           public void success(Long response, JXFVJavaInterface jxm) {
               mIActivityMainView.jxIsFVDConnected(response,jxm);
           }

           @Override
           public void fail(int errCode, String msg) {

           }

           @Override
           public void byt(Long response, JXFVJavaInterface jxm, byte[] jxc) {

           }
       });
    }

    @Override
    public void jxConnFVD(final long usb, JXFVJavaInterface mJxfvJavaInterface) {
        mIodelUsb.jxConnFVD(usb, mJxfvJavaInterface, new IUnifiedDataListenerUsb<Long, JXFVJavaInterface>() {
            @Override
            public void success(Long response, JXFVJavaInterface jxm) {
                mIActivityMainView.jxConnFVD(usb,jxm);
            }

            @Override
            public void fail(int errCode, String msg) {

            }

            @Override
            public void byt(Long response, JXFVJavaInterface jxm, byte[] jxc) {

            }
        });
    }

    @Override
    public void jxIsFingerDetected(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        mIodelUsb.jxIsFingerDetected(usb, mJxfvJavaInterface, new IUnifiedDataListenerUsb<Long, JXFVJavaInterface>() {
            @Override
            public void success(Long response, JXFVJavaInterface jxm) {
                mIActivityMainView.jxIsFingerDetected(response,jxm);
            }

            @Override
            public void fail(int errCode, String msg) {

            }

            @Override
            public void byt(Long response, JXFVJavaInterface jxm, byte[] jxc) {

            }
        });
    }

    @Override
    public void jxInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        mIodelUsb.jxInitCapEnv(usb, mJxfvJavaInterface, new IUnifiedDataListenerUsb<Long, JXFVJavaInterface>() {
            @Override
            public void success(Long response, JXFVJavaInterface jxm) {
                mIActivityMainView.jxInitCapEnv(response,jxm);
            }

            @Override
            public void fail(int errCode, String msg) {

            }

            @Override
            public void byt(Long response, JXFVJavaInterface jxm, byte[] jxc) {

            }
        });
    }

    @Override
    public void jxDeInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        mIodelUsb.jxDeInitCapEnv(usb, mJxfvJavaInterface, new IUnifiedDataListenerUsb<Long, JXFVJavaInterface>() {
            @Override
            public void success(Long response, JXFVJavaInterface jxm) {
                mIActivityMainView.jxDeInitCapEnv(response,jxm);
            }

            @Override
            public void fail(int errCode, String msg) {

            }

            @Override
            public void byt(Long response, JXFVJavaInterface jxm, byte[] jxc) {

            }
        });
    }

    @Override
    public void jxIsVeinImgOK(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        mIodelUsb.jxIsVeinImgOK(usb, mJxfvJavaInterface, new IUnifiedDataListenerUsb<Long, JXFVJavaInterface>() {
            @Override
            public void success(Long response, JXFVJavaInterface jxm) {

            }

            @Override
            public void fail(int errCode, String msg) {

            }

            @Override
            public void byt(Long response, JXFVJavaInterface jxm, byte[] jxc) {
                    mIActivityMainView.jxIsVeinImgOK(response,jxm,jxc);
            }
        });
    }

    @Override
    public void jxLoadVeinSample(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        mIodelUsb.jxLoadVeinSample(usb, mJxfvJavaInterface, new IUnifiedDataListenerUsb<Long, JXFVJavaInterface>() {
            @Override
            public void success(Long response, JXFVJavaInterface jxm) {

            }

            @Override
            public void fail(int errCode, String msg) {

            }

            @Override
            public void byt(Long response, JXFVJavaInterface jxm, byte[] jxc) {
                mIActivityMainView.jxLoadVeinSample(response,jxm,jxc);
            }
        });
    }

/**
 * 描述：登陆

 */


}
