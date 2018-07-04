package com.family.prisons.prisonsui.uiapplyinquiries.view.impl;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.prisons.R;
import com.family.prisons.prisonsfather.BaseFragment;
@Route(path = "/prisonsui/fragment/FragmentNotThroughView", name = "未通过")

public class FragmentNotThroughView extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_not_through_view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
