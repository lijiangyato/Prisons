package com.family.prisons.prisonutils;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;

import com.family.prisons.R;


public class UtilsDialoRg extends Dialog{

    private Context mContext;
    public UtilsDialoRg(@NonNull Context context) {
        super(context, R.style.LoadingDialog);
        this.mContext=context;
    }

    public UtilsDialoRg(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.mContext=context;
    }

    protected UtilsDialoRg(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View mview = LayoutInflater.from(mContext).inflate(R.layout.activity_register_dialog_view,null);
        setContentView(mview);
        //设置点击屏幕Dialog不消失
        setCancelable(false);


    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void setCanceledOnTouchOutside(boolean cancel) {
        //点击屏幕不消失
        super.setCanceledOnTouchOutside(false);
    }
}