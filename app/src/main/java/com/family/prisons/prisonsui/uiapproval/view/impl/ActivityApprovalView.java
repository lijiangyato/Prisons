package com.family.prisons.prisonsui.uiapproval.view.impl;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.prisons.R;
import com.family.prisons.prisonsfather.BaseActivity;

/**
 * Created by ThinkPad on 2018/6/15.
 */
@Route(path = "/prisonsui/activity/ActivityApprovalView", name = "电话审批")

public class ActivityApprovalView extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval_view);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
