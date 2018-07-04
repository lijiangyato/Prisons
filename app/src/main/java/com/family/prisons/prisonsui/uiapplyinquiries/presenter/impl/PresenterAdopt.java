package com.family.prisons.prisonsui.uiapplyinquiries.presenter.impl;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.family.prisons.prisonsdata.model.IModelApplyForm;
import com.family.prisons.prisonsui.uiapplyinquiries.presenter.IPresenterAdopt;
import com.family.prisons.prisonsui.uiapplyinquiries.view.IFragmentAdoptView;

public class PresenterAdopt implements IPresenterAdopt {

    @Autowired
    IModelApplyForm mIModelApplyForm;

    public IFragmentAdoptView mIFragmentAdoptView;

    public PresenterAdopt(IFragmentAdoptView iFragmentAdoptView) {
        this.mIFragmentAdoptView=iFragmentAdoptView;
        ARouter.getInstance().inject(this);
    }

    @Override
    public void getForm(String dwdm, String prisonerNo, String offset, String limit, String isDail, String status) {

    }
}
