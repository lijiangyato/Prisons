package com.family.prisons.prisonsindex.holder;

import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HolderSubmission extends BaseViewHolder{
    @BindView(R.id.attribute_determine_id)
    public Button attributeDetermineId;
    public HolderSubmission(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
