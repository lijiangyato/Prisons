package com.family.prisons.prisonsui.uiapplyinquiries.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;
import com.family.prisons.prisonsui.uiapplyinquiries.entity.Entitywhole;
import com.family.prisons.prisonsui.uiapplyinquiries.holder.HolderWhole;

import java.util.List;

public class AdapterWhole extends BaseMultiItemQuickAdapter<Entitywhole,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public List<Entitywhole> mListentitywhole;
    public Context mContext;
    public AdapterWhole(List<Entitywhole> data, Context context) {
        super(data);
        this.mListentitywhole=data;
        this.mContext=context;
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            /**
             * 描述：全部列表对象
             */
            case Entitywhole.TYPE_ONE:
                return new HolderWhole(mLayoutInflater.inflate(R.layout.holder_whole_view,parent,false));
        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, Entitywhole item) {
        /**
         * 描述：全部列表数据的填充
         */
        switch (helper.getItemViewType()){
            case Entitywhole.TYPE_ONE:
                break;
        }
    }
}
