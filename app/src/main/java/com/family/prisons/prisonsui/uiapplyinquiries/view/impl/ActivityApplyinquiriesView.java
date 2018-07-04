package com.family.prisons.prisonsui.uiapplyinquiries.view.impl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.family.prisons.R;
import com.family.prisons.prisonsfather.BaseActivity;
import com.family.prisons.prisonsui.uiapplyinquiries.adapter.AdapterApplyinquiries;
import com.family.prisons.prisonsui.uiapplyinquiries.view.IActivityApplyinquiriesView;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import devlight.io.library.ntb.NavigationTabBar;


/**
 * Created by ThinkPad on 2018/6/15.
 */
@Route(path = "/prisonsui/activity/ActivityApplyinquiriesView", name = "申请查询")
public class ActivityApplyinquiriesView extends BaseActivity implements IActivityApplyinquiriesView {
    public ArrayList<NavigationTabBar.Model> models;
    @BindView(R.id.attribute_form_id)
    ViewPager attributeFormId;
    public List<Fragment> mListframgnet;
    public AdapterApplyinquiries mAdapterApplyinquiries;
    @BindView(R.id.name_TabBar_id)
    NavigationTabBar nameTabBarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyinquiries_view);
        initial();
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    public void initial() {


        mListframgnet = new ArrayList<>();
        mListframgnet.add((Fragment) ARouter.getInstance().build("/prisonsui/fragment/FragmentAdoptView").navigation());
        mListframgnet.add((Fragment) ARouter.getInstance().build("/prisonsui/fragment/FragmentWholeView").navigation());
        mListframgnet.add((Fragment) ARouter.getInstance().build("/prisonsui/fragment/FragmentNotThroughView").navigation());
        mAdapterApplyinquiries = new AdapterApplyinquiries(getSupportFragmentManager(), mListframgnet);

        attributeFormId.setOffscreenPageLimit(3);
        attributeFormId.setAdapter(mAdapterApplyinquiries);
        attributeFormId.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


        final String[] colors = getResources().getStringArray(R.array.homehui);
        models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        null,
                        Color.parseColor(colors[0]))
                        .title("全部")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(null, Color.parseColor(colors[1]))
                        .title("已通过")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(null,
                        Color.parseColor(colors[2]))
                        .title("未通过")
                        .build()
        );


        nameTabBarId.setModels(models);
        nameTabBarId.setViewPager(attributeFormId);
        nameTabBarId.setBehaviorEnabled(true);

        nameTabBarId.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(NavigationTabBar.Model model, int i) {
                model.hideBadge();
            }

            @Override
            public void onEndTabSelected(NavigationTabBar.Model model, int i) {

            }
        });


    }
}
