package com.family.prisons.prisonsindex.holder.impl;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HolderPrisonArea extends BaseViewHolder {
    @BindView(R.id.attribute_entry_id)
    public TextView attributeEntryId;
    public HolderPrisonArea(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
