package com.family.prisons.prisonsindex.presenter.impl;

import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityphoneregister.EntityRegister;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonArea;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvince;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvincePrison;
import com.family.prisons.prisonsdata.model.IModelPhoneRegister;
import com.family.prisons.prisonsdata.model.IModelRegistrationToken;
import com.family.prisons.prisonsindex.presenter.IPresenterRegister;
import com.family.prisons.prisonsindex.view.IActivityRegisterView;
import com.socks.library.KLog;

/**
 * Created by ThinkPad on 2018/6/13.
 */

public class PresenterRegister implements IPresenterRegister {
    public IActivityRegisterView mIActivityRegisterView;
    @Autowired
    IModelRegistrationToken miModelRegistrationToken;

    @Autowired
    IModelPhoneRegister mModelPhoneRegister;

    public PresenterRegister(IActivityRegisterView iActivityRegisterView) {
        this.mIActivityRegisterView = iActivityRegisterView;
        ARouter.getInstance().inject(this);
    }

    @Override
    public void displaypresenter() {
        mIActivityRegisterView.displayview();
    }

    /**
     * 描述：监狱省份
     */
    @Override
    public void getProvince(String token) {
        miModelRegistrationToken.getProvince(token, new IUnifiedDataListener<EntityProvince>() {
            @Override
            public void success(EntityProvince response) {
                mIActivityRegisterView.setProvince(response);
            }

            @Override
            public void fail(int errCode, String msg) {
                mIActivityRegisterView.setCloseLoad(-1,null,null);
            }
        });
    }

    /**
     * 描述：具体监狱省份
     */
    @Override
    public void getProvincePrison(String token, String prisonCode) {
        miModelRegistrationToken.getProvincePrison(token, prisonCode, new IUnifiedDataListener<EntityProvincePrison>() {
            @Override
            public void success(EntityProvincePrison response) {
                mIActivityRegisterView.setProvincePrison(response);
            }

            @Override
            public void fail(int errCode, String msg) {
                mIActivityRegisterView.setCloseLoad(-1,null,null);
                KLog.a(msg,errCode+"");
            }
        });
    }

    /**
     * 描述：监区
     */
    @Override
    public void getPrisonArea(String token, final String dwdm) {
        miModelRegistrationToken.getPrisonArea(token, dwdm, new IUnifiedDataListener<EntityPrisonArea>() {
            @Override
            public void success(EntityPrisonArea response) {
                mIActivityRegisterView.setPrisonArea(response);
            }

            @Override
            public void fail(int errCode, String msg) {

            }
        });
    }

    /**
     * 描述：注册
     */
    @Override
    public void getRegister(String token, String phoneNo, String ip, String mac, String dwdm, String dwdmName, String prisonCode, String prisonName, String prisonAreaCode, String prisonAreaName) {
        mModelPhoneRegister.getRegister(token, phoneNo, ip, mac, dwdm, dwdmName, prisonCode, prisonName, prisonAreaCode, prisonAreaName, new IUnifiedDataListener<EntityRegister>() {
            @Override
            public void success(EntityRegister response) {
                mIActivityRegisterView.getRegister(response);
            }

            @Override
            public void fail(int errCode, String msg) {

            }
        });
    }
}
