package com.family.prisons.prisonsui.uidialing.presenter.impl;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entitypplyform.EntityForm;
import com.family.prisons.prisonsdata.model.IModelApplyForm;
import com.family.prisons.prisonsdata.model.IModelRegistrationToken;
import com.family.prisons.prisonsui.uidialing.presenter.IPresenterDialing;
import com.family.prisons.prisonsui.uidialing.view.IActivityDialingView;

/**
 * Created by ThinkPad on 2018/6/15.
 */

public class PresenterDialing  implements IPresenterDialing {
    public IActivityDialingView mIActivityDialingView;
    @Autowired
    IModelApplyForm mModelApplyForm;


    public PresenterDialing(IActivityDialingView iActivityDialingView){
        this.mIActivityDialingView=iActivityDialingView;
        ARouter.getInstance().inject(this);
    }

    @Override
    public void getForm(String dwdm, String prisonerNo, String offset, String limit, String isDail, String status) {
        mModelApplyForm.getForm(dwdm, prisonerNo, offset, limit, isDail, status, new IUnifiedDataListener<EntityForm>() {
            @Override
            public void success(EntityForm response) {
                mIActivityDialingView.setForm(response);
            }

            @Override
            public void fail(int errCode, String msg) {

            }
        });
    }
}
