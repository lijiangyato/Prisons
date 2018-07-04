package com.family.prisons.prisonsfather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import butterknife.ButterKnife;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public abstract class BaseFragment extends Fragment {
    private View mview;

    protected abstract int getLayoutId();

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract void initData();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.openDebug();
        //初始化ARouter
        ARouter.getInstance().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (mview == null) {
            mview = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mview);
            initView(mview, savedInstanceState);
            initData();
        }
        ViewGroup mviewGroup = (ViewGroup) mview.getParent();
        if (mviewGroup != null) {
            mviewGroup.removeView(mview);
        }

        return mview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}