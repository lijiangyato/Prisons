package com.family.prisons.prisonsindex.adapter.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;
import com.family.prisons.prisonsindex.entity.impl.EntityUtlisWindow;
import com.family.prisons.prisonsindex.holder.impl.HolderWindow;
import com.family.prisons.prisonutils.UtilsWindow;
import com.socks.library.KLog;

import java.util.List;

import butterknife.BindView;
/**
 * 描述：监狱省份的数据适配器
 * 邮箱：1755036940@qq.com
 * 创建时间：2018/6/11
 * 姓名：李江
 */
public class AdapterUtilsWindow extends BaseMultiItemQuickAdapter<EntityUtlisWindow, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Context mContext;
    public List<EntityUtlisWindow> mEntityUtlisWindows;
    public onSublistinterface mOnSublistinterface;

    public AdapterUtilsWindow(Context context, List<EntityUtlisWindow> data) {
        super(data);
        this.mContext = context;
        this.mEntityUtlisWindows = data;
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            /**
             * 描述：选择监狱省份:子布局
             */
            case EntityUtlisWindow.TYPE_ONE:
                return new HolderWindow(mLayoutInflater.inflate(R.layout.holder_window_view, parent, false));
        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, final EntityUtlisWindow item) {
        switch (helper.getItemViewType()) {
            /**
             * 描述：描述：选择监狱省份:子数据列表
             */
            case EntityUtlisWindow.TYPE_ONE:
                if (helper instanceof  HolderWindow){
                    ((HolderWindow)helper).attributeEntryId.setText(item.getPrisonName());
                    ((HolderWindow)helper).attributeEntryId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOnSublistinterface!=null){
                                mOnSublistinterface.OnSublistClick(v,item);

                                KLog.a("事件触发","成功");
                            }
                        }
                    });
                }
                break;
        }
    }

public interface  onSublistinterface{
        void OnSublistClick(View view,EntityUtlisWindow entityUtlisWindow);
}


public void  setonSublistinterfacea(onSublistinterface onSublistinterface){
        this.mOnSublistinterface=onSublistinterface;
}
}
