package com.family.prisons.prisonsui.uidialing.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;
import com.family.prisons.prisonsui.uidialing.entity.EntityDialing;
import com.family.prisons.prisonsui.uidialing.holder.HolderCustom;

import java.util.List;

import butterknife.BindView;

public class AdapterDialing extends BaseMultiItemQuickAdapter<EntityDialing, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public List<EntityDialing> mList;
    public Context mContext;
    public AdapterDialing(Context context,List<EntityDialing> data) {
        super(data);
        this.mContext=context;
        this.mList=data;
    }


    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            /**
             * 描述：拨打电话的记录
             */
            case EntityDialing.TYPE_ONE:
                return new HolderCustom(mLayoutInflater.inflate(R.layout.holder_custom_view, parent, false));
        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityDialing item) {
        switch (helper.getItemViewType()) {
            /**
             * 描述：拨打电话的记录
             */
            case EntityDialing.TYPE_ONE:
                break;
        }
    }
}
