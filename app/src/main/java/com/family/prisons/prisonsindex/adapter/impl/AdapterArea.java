package com.family.prisons.prisonsindex.adapter.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;
import com.family.prisons.prisonsindex.entity.impl.EntityArea;
import com.family.prisons.prisonsindex.entity.impl.EntityPrisonArea;
import com.family.prisons.prisonsindex.holder.impl.HolderArea;

import java.util.List;

public class AdapterArea  extends BaseMultiItemQuickAdapter<EntityArea,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public List<EntityArea> mEntityAreas;
    public Context mContext;
    public Onareainterface mOnareainterface;
    public AdapterArea(Context context,List<EntityArea> data) {
        super(data);
        this.mEntityAreas=data;
        this.mContext=context;

    }


    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
           /**
            * 描述：监区
            */
        switch (viewType){
            case  EntityArea.TYPE_ONE:
                return  new HolderArea(mLayoutInflater.inflate(R.layout.holder_window_view,parent,false));
        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, final EntityArea item) {
        switch (helper.getItemViewType()){
            case EntityArea.TYPE_ONE:
            if (helper instanceof  HolderArea) {
                ((HolderArea)helper).attributeEntryId.setText(item.getPrisonName());
                ((HolderArea)helper).attributeEntryId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnareainterface!=null){
                            mOnareainterface.OnareaClick(v,item);
                        }
                    }
                });
            }
            break;

        }
    }

    public interface  Onareainterface{
        void OnareaClick(View view, EntityArea entityArea);
    }

    public void  setOnareainterfacea(Onareainterface onareainterface){
        this.mOnareainterface=onareainterface;
    }
}
