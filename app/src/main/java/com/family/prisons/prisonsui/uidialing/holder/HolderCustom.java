package com.family.prisons.prisonsui.uidialing.holder;

import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HolderCustom extends BaseViewHolder {
    @BindView(R.id.attribute_number_id)
    public   Button attributeNumberId;
    public HolderCustom(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
