package com.family.prisons.prisonutils;

/**
 * Created by ThinkPad on 2018/6/14.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import com.family.prisons.R;
import com.flyco.animation.Attention.Swing;
import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UtilsDialoboang extends BaseDialog<UtilsDialoboang> {


    @BindView(R.id.name_zhijiangmai_id)
    ImageView nameZhijiangmaiId;

    public UtilsDialoboang(Context context) {
        super(context);
    }

    public UtilsDialoboang(Context context, boolean isPopupStyle) {
        super(context, isPopupStyle);
    }

    @Override
    public View onCreateView() {
        widthScale(0.85f);
        showAnim(new Swing());
        View inflate = View.inflate(mContext, R.layout.dialog_vein_layout, null);
        ButterKnife.bind(this, inflate);
        inflate.setBackgroundDrawable(
                CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));

        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        nameZhijiangmaiId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  button.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
              //  nameZhijiangmaiId.setBackgroundResource(R.drawable.ic_launcher);
                dismiss();
            }
        });
    }

    /**
     * 描述：更新指静脉传来的数据
     */
    public void  Refresh(Bitmap bitmap){
        nameZhijiangmaiId.setImageBitmap(bitmap);
    }


}