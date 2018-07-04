package com.family.prisons.prisonsindex.holder;

/**
 * Created by ThinkPad on 2018/6/13.
 */

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 描述：选择当前监区
 * 邮箱：1755036940@qq.com
 * 创建时间：2018/6/11
 * 姓名：李江
 */
public class HolderCurrentArea extends BaseViewHolder {
    @BindView(R.id.attribute_omit_id)
    public TextView attributeOmitId;
    public HolderCurrentArea(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
