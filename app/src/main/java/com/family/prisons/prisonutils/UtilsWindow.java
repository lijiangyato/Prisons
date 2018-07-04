package com.family.prisons.prisonutils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.family.prisons.R;
import com.family.prisons.prisonsindex.adapter.impl.AdapterUtilsWindow;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UtilsWindow extends PopupWindow implements AdapterView.OnItemClickListener {
    public Context mConstant;
    @BindView(R.id.attribute_provinceject_id)
    RecyclerView attributeProvincejectId;
    private OnItemClickListener mOnItemClickListener;
    public AdapterUtilsWindow mAdapterUtilsWindow;

    public UtilsWindow(Context context) {
        super(context);
        this.mConstant = context;
        init();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    public void setAdapter(AdapterUtilsWindow adapter){
        this.mAdapterUtilsWindow = adapter;
        attributeProvincejectId.setAdapter(mAdapterUtilsWindow);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dismiss();
        if (null != mOnItemClickListener){
            mOnItemClickListener.onClick((int)id);
        }

    }

    /**
     * 描述：初始话视图
     */
    private void init() {
        View view = LayoutInflater.from(mConstant).inflate(R.layout.utils_window_view, null);

        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        setContentView(view);

        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        ButterKnife.bind(this, view);
        attributeProvincejectId.setLayoutManager(new LinearLayoutManager(mConstant));
        attributeProvincejectId.addItemDecoration(new UtilsRecycler(mConstant,UtilsRecycler.VERTICAL_LIST, UtilsRecycler.DividerType.TYPE_F2F2F2));
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
