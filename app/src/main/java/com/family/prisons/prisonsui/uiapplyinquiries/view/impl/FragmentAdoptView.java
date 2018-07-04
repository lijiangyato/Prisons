package com.family.prisons.prisonsui.uiapplyinquiries.view.impl;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.arjinmc.recyclerviewdecoration.RecyclerViewItemDecoration;
import com.family.library.librarythread.UtilsThread;
import com.family.prisons.R;
import com.family.prisons.prisonsdata.entitypplyform.EntityForm;
import com.family.prisons.prisonsfather.BaseFragment;
import com.family.prisons.prisonsmain.adapter.AdapterMain;
import com.family.prisons.prisonsui.uiapplyinquiries.adapter.AdapterWhole;
import com.family.prisons.prisonsui.uiapplyinquiries.entity.Entitywhole;
import com.family.prisons.prisonsui.uiapplyinquiries.presenter.IPresenterAdopt;
import com.family.prisons.prisonsui.uiapplyinquiries.view.IFragmentAdoptView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@Route(path = "/prisonsui/fragment/FragmentAdoptView", name = "全部")
public class FragmentAdoptView extends BaseFragment implements IFragmentAdoptView {
    @BindView(R.id.attribute_wholerecycler_id)
    RecyclerView attributeWholerecyclerId;
    @BindView(R.id.attribute_refreshLayout_id)
    SmartRefreshLayout attributeRefreshLayoutId;
    public AdapterWhole mAdapterWhole;

    public List<Entitywhole> mEntitywholes;
    public IPresenterAdopt mIPresenterAdopt;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_adopt_view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        inidata();
    }

    @Override
    protected void initData() {

    }


    public void inidata() {
        attributeWholerecyclerId.setLayoutManager(new GridLayoutManager(getContext(), 2));
        attributeWholerecyclerId.addItemDecoration(new RecyclerViewItemDecoration.Builder(getContext())

                .dashGap(12)
                .thickness(10)
                /* .gridBottomVisible(true) //control bottom border
                 .gridTopVisible(true) //control top border
                 .gridLeftVisible(true) //control left border
                 .gridRightVisible(true) //control right border*/
                .gridHorizontalSpacing(30)
                .gridVerticalSpacing(30)
                .create());
        //attributeMenuId.setHasFixedSize(true);

        mAdapterWhole = new AdapterWhole(null, getContext());
        attributeWholerecyclerId.setAdapter(mAdapterWhole);

    }


    @Override
    public void setForm(EntityForm entityForm) {
        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Entitywhole entitywhole0=new Entitywhole();
                entitywhole0.setItemType(Entitywhole.TYPE_ONE);
                mEntitywholes.add(entitywhole0);
                mAdapterWhole.setNewData(mEntitywholes);

            }
        });
    }
}
