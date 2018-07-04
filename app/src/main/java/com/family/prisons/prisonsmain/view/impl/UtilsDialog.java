package com.family.prisons.prisonsmain.view.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import com.family.prisons.R;
import com.family.prisons.prisonsmain.entity.Entitymsg;
import com.flyco.animation.Attention.Swing;
import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;



import butterknife.BindView;
import butterknife.ButterKnife;

class UtilsDialog extends BaseDialog<UtilsDialog> {

    @BindView(R.id.attribut_egaoler_id)
    LinearLayout attributEgaolerId;
    @BindView(R.id.attribut_criminal_id)
    LinearLayout attributCriminalId;

    public  oNdialgueClick oNdialgueClick;

    public Entitymsg entitymsg;

    public UtilsDialog(Context context) {
        super(context);
    }

    public UtilsDialog(Context context, boolean isPopupStyle) {
        super(context, isPopupStyle);
    }

    @Override
    public View onCreateView() {
        widthScale(0.85f);
        showAnim(new Swing());
        View inflate = View.inflate(mContext, R.layout.utils_dialog_view, null);
        ButterKnife.bind(this, inflate);
        inflate.setBackgroundDrawable(
                CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));

        return inflate;
    }


    @Override
    public void setUiBeforShow() {
        attributEgaolerId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        attributCriminalId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // entitymsg=new Entitymsg();
               // entitymsg.setMong(10);
               // EventBus.getDefault().post(entitymsg);

                if (oNdialgueClick!=null){
                    oNdialgueClick.doSomeClick();
                }
            }
        });
    }


    public void setoNdialgueClick(oNdialgueClick oNdialgueClick){
        this.oNdialgueClick=oNdialgueClick;
    }
    public  interface oNdialgueClick{
          void doSomeClick();
    }


}