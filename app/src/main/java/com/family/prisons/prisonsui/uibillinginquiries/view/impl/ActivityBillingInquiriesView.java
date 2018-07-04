package com.family.prisons.prisonsui.uibillinginquiries.view.impl;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.prisons.R;
import com.family.prisons.prisonsfather.BaseActivity;

/**
 * Created by ThinkPad on 2018/6/15.
 */
@Route(path = "/prisonsui/activity/ActivityBillingInquiriesView", name = "账单查询")

public class ActivityBillingInquiriesView extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billinglnquiries_view);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
