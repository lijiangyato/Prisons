package com.family.prisons.prisonsui.uiapplyinquiries.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

public class AdapterApplyinquiries extends FragmentStatePagerAdapter {
    private List<Fragment>mFragments;
    private String [] mTitleStrings;

    public AdapterApplyinquiries(FragmentManager fm, List<Fragment> mfragments) {
        super(fm);
        this.mFragments=mfragments;

    }

    @Override
    public Fragment getItem(int position) {


        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }






}