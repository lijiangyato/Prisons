package com.family.prisons.prisonsindex.adapter.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;
import com.family.prisons.prisonsindex.entity.impl.EntityPrisonArea;
import com.family.prisons.prisonsindex.holder.impl.HolderPrisonArea;
import com.socks.library.KLog;

import java.util.List;

public class AdapterPrisonArea  extends BaseMultiItemQuickAdapter<EntityPrisonArea, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Context mContext;
    public List<EntityPrisonArea> mEntityUtlisWindows;
    public onSublistinterface mOnSublistinterface;
    public AdapterPrisonArea(Context context,List<EntityPrisonArea> data) {
        super(data);
        this.mEntityUtlisWindows=data;
        this.mContext=context;
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            /**
             * 描述：选择监狱省份:子布局
             */
            case EntityPrisonArea.TYPE_ONE:
                return new HolderPrisonArea(mLayoutInflater.inflate(R.layout.holder_window_view, parent, false));
        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, final EntityPrisonArea item) {
        switch (helper.getItemViewType()) {
            /**
             * 描述：描述：选择监狱省份:子数据列表
             */
            case EntityPrisonArea.TYPE_ONE:
                if (helper instanceof  HolderPrisonArea){
                    ((HolderPrisonArea)helper).attributeEntryId.setText(item.getPrisonName());
                    ((HolderPrisonArea)helper).attributeEntryId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOnSublistinterface!=null){
                                mOnSublistinterface.OnSublistClick(v,item);

                                KLog.a("事件触发","成功");
                            }
                        }
                    });
                }
                break;
        }
    }

    public interface  onSublistinterface{
        void OnSublistClick(View view,EntityPrisonArea entityPrisonArea);
    }


    public void  setonSublistinterfacea(onSublistinterface onSublistinterface){
        this.mOnSublistinterface=onSublistinterface;
    }
}
