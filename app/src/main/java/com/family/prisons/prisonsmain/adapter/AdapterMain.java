package com.family.prisons.prisonsmain.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;
import com.family.prisons.prisonsmain.entity.EntityMain;
import com.family.prisons.prisonsmain.holder.HolderApply;
import com.family.prisons.prisonsmain.holder.HolderApproval;
import com.family.prisons.prisonsmain.holder.HolderBillingInquiries;
import com.family.prisons.prisonsmain.holder.HolderDial;
import com.family.prisons.prisonsmain.holder.HolderFullName;
import com.family.prisons.prisonsmain.holder.HolderTitle;
import com.family.prisons.prisonsmain.holder.HolderUpgrade;
import com.family.prisons.prisonsmain.holder.HolderUrgent;

import java.util.List;

/**
 * Created by ThinkPad on 2018/6/14.
 */

public class AdapterMain extends BaseMultiItemQuickAdapter<EntityMain, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
 public onFamilyAffectionInterface mOnFamilyAffectionInterface;
    public List<EntityMain> mEntityMains;
    public Context mContext;

    public AdapterMain(List<EntityMain> data, Context context) {
        super(data);
        this.mEntityMains = data;
        this.mContext = context;
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            /**
             * 描述：监狱头
             */
            case EntityMain.TYPE_ONE:
                return new HolderTitle(mLayoutInflater.inflate(R.layout.holder_title_veiw, parent, false));
            /**
             * 描述：监狱犯人的姓名
             */
            case EntityMain.TYPE_TWO:
                return new HolderFullName(mLayoutInflater.inflate(R.layout.holder_full_name_view, parent, false));
            /**
             * 描述：拨打电话
             */
            case EntityMain.TYPE_THREE:
                return new HolderDial(mLayoutInflater.inflate(R.layout.holder_dial_view, parent, false));
            /**
             * 描述：申请单查询
             */
            case EntityMain.TYPE_FOUR:
                return new HolderApply(mLayoutInflater.inflate(R.layout.holder_apply_view, parent, false));
            /**
             * 描述：电话审批
             */
            case EntityMain.TYPE_FIVE:
                return new HolderApproval(mLayoutInflater.inflate(R.layout.holder_approval_view, parent, false));
            /**
             * 描述：紧急拨打
             */
            case EntityMain.TYPE_SIX:
                return new HolderUrgent(mLayoutInflater.inflate(R.layout.holder_urgent_view, parent, false));
            /**
             * 描述：账单查询
             */
            case EntityMain.TYPE_SEVEN:
                return new HolderBillingInquiries(mLayoutInflater.inflate(R.layout.holder_billing_inquiries_view, parent, false));
            /**
             * 描述：应用升级
             */
            case EntityMain.TYPE_EIGHT:
                return new HolderUpgrade(mLayoutInflater.inflate(R.layout.holder_upgrade_view, parent, false));

        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, final EntityMain item) {
                      switch (helper.getItemViewType()){
                          /**
                           * 描述：拨打电话
                           */
                          case EntityMain.TYPE_THREE:
                              if (helper instanceof  HolderDial ){
                                  ((HolderDial)helper).itemView.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (mOnFamilyAffectionInterface!=null){
                                              mOnFamilyAffectionInterface.OnDialClick(v,item.getAddress(),item);
                                          }
                                      }
                                  });
                              }
                              break;

                              /**
                               * 描述账单申请
                               */
                          case EntityMain.TYPE_FOUR:
                              if(helper instanceof  HolderApply){
                                  ((HolderApply)helper).itemView.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (mOnFamilyAffectionInterface!=null){
                                              mOnFamilyAffectionInterface.OnApplyClick(v,item.getAddress(),item);
                                          }
                                      }
                                  });
                              }
                              break;
                          /**
                           * 描述：电话审批
                           */
                          case EntityMain.TYPE_FIVE:
                              if (helper instanceof HolderApproval ){
                                  ((HolderApproval)helper).itemView.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (mOnFamilyAffectionInterface!=null){
                                              mOnFamilyAffectionInterface.OnApproveClick(v,item.getAddress(),item);
                                          }
                                      }
                                  });
                              }
                              break;
                          /**
                           * 描述：紧急拨打
                           */
                          case EntityMain.TYPE_SIX:
                              if (helper instanceof HolderUrgent ){
                                  ((HolderUrgent)helper).itemView.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (mOnFamilyAffectionInterface!=null){
                                              mOnFamilyAffectionInterface.OnUrgentClick(v,item.getAddress(),item);
                                          }
                                      }
                                  });
                              }
                              break;

                          /**
                           * 描述：账单查询
                           */
                          case EntityMain.TYPE_SEVEN:
                              if (helper instanceof HolderBillingInquiries){
                                  ((HolderBillingInquiries)helper).itemView.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                         if (mOnFamilyAffectionInterface!=null){
                                             mOnFamilyAffectionInterface.OnBillClick(v,item.getAddress(),item);
                                         }
                                      }
                                  });
                              }
                              break;
                      }
    }

public void setOnFamilyAffectionInterface(onFamilyAffectionInterface onFamilyAffectionInterface){
        this.mOnFamilyAffectionInterface=onFamilyAffectionInterface;
}

    public interface  onFamilyAffectionInterface{
        /**
         * 描述：拨打电话
         */
        void  OnDialClick(View view, String Address,EntityMain entityMain);
        /**
         * 描述：申请单查询
         */
        void OnApplyClick(View view,String address,EntityMain entityMain);
        /**
         * 描述：电话审批
         */
        void OnApproveClick(View view,String address,EntityMain entityMain);
        /**
         * 描述：紧急拨打
         */
        void OnUrgentClick(View view,String address,EntityMain entityMain);
        /**
         * 描述：账单查询
         */
        void OnBillClick(View view,String address,EntityMain entityMain);
        /**
         * 描述：应用升级
         */
        void OnUpdateClick(View view,String addrsss,EntityMain entityMain);
    }
}
