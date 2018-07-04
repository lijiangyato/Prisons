package com.family.prisons.prisonsindex.adapter;

/**
 * Created by ThinkPad on 2018/6/13.
 */

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.family.prisons.R;
import com.family.prisons.prisonsindex.entity.EntityRegister;
import com.family.prisons.prisonsindex.holder.HolderCurrentArea;
import com.family.prisons.prisonsindex.holder.HolderCurrentPrison;
import com.family.prisons.prisonsindex.holder.HolderInstall;
import com.family.prisons.prisonsindex.holder.HolderPort;
import com.family.prisons.prisonsindex.holder.HolderPrisonProvince;
import com.family.prisons.prisonsindex.holder.HolderRemarks;
import com.family.prisons.prisonsindex.holder.HolderServerAddress;
import com.family.prisons.prisonsindex.holder.HolderSubmission;
import com.family.prisons.prisonsindex.holder.HolderToConfigure;
import com.socks.library.KLog;

import java.util.List;

import butterknife.BindView;

/**
 * 描述：注册适配器
 * 邮箱：1755036940@qq.com
 * 创建时间：2018/6/11
 * 姓名：李江
 */
public class AdapterRegister extends BaseMultiItemQuickAdapter<EntityRegister, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */

    public List<EntityRegister> mData;
    public Context mContext;
    public onClickoterminal mOnClickoterminal;
    public String mAdd;


    public AdapterRegister(List<EntityRegister> data, Context context) {
        super(data);
        this.mContext = context;
        this.mData = data;
    }


    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            /**
             * 描述：终端配置
             */
            case EntityRegister.TYPE_EIGHT:
                return new HolderToConfigure(mLayoutInflater.inflate(R.layout.holder_to_configure_view, parent, false));
            /**
             * 描述：服务器地址
             */
            case EntityRegister.TYPE_ONE:
                return new HolderServerAddress(mLayoutInflater.inflate(R.layout.holder_server_address_view, parent, false));
            /**
             * 描述：服务器端口
             */
            case EntityRegister.TYPE_TWO:
                return new HolderPort(mLayoutInflater.inflate(R.layout.holder_port_view, parent, false));

            /**
             * 描述：选择当前监狱的省份 布局复用
             */
            case EntityRegister.TYPE_THREE:
                return new HolderPrisonProvince(mLayoutInflater.inflate(R.layout.holder_prison_province_view, parent, false));
            /**
             * 描述：选择当前监狱 布局复用
             */
            case EntityRegister.TYPE_FOUR:
                return new HolderCurrentPrison(mLayoutInflater.inflate(R.layout.holder_prison_province_view, parent, false));

            /**
             * 描述：选择当前监狱区 布局复用
             */
            case EntityRegister.TYPE_FIVE:
                return new HolderCurrentArea(mLayoutInflater.inflate(R.layout.holder_prison_province_view, parent, false));
            /**
             * 描述：选择安装位置
             */
            case EntityRegister.TYPE_SIX:
                return new HolderInstall(mLayoutInflater.inflate(R.layout.holder_install_view, parent, false));
            /**
             * 描述：备注
             */
            case EntityRegister.TYPE_SEVEN:
                return new HolderRemarks(mLayoutInflater.inflate(R.layout.holder_remarks_view, parent, false));
            /**
             * 描述：完成注册
             */
            case EntityRegister.TYPE_NINE:
                return new HolderSubmission(mLayoutInflater.inflate(R.layout.holder_submission_view, parent, false));
        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final EntityRegister item) {
        switch (helper.getItemViewType()) {
            /**
             * 描述：服务器地址
             */
            case EntityRegister.TYPE_ONE:
                if (helper instanceof HolderServerAddress) {

                    if (((HolderServerAddress) helper).attributeIpId.getText().toString() != null) {

                        ((HolderServerAddress) helper).attributeIpId.addTextChangedListener(watcher);
                        KLog.a("服务器地址为：", mAdd);
                    } else {
                        KLog.a("服务器地址为:", "空");
                    }
                }

                break;
            /**
             * 描述：端口号
             */
            case EntityRegister.TYPE_TWO:
                if (helper instanceof HolderPort) {
                    if (((HolderPort) helper).attributePortId.getText().toString() != null) {
                        ((HolderPort) helper).attributeDetermineId.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mOnClickoterminal != null) {

                                    mOnClickoterminal.onschemaClick(mAdd, ((HolderPort) helper).attributePortId.getText().toString());


                                }
                            }
                        });
                    } else {
                        KLog.a("端口号为:", "空");
                    }
                }
                break;
            /**
             * 描述：监狱省份
             */
            case EntityRegister.TYPE_THREE:
                if (helper instanceof HolderPrisonProvince) {
                    ((HolderPrisonProvince) helper).attributeOmitId.setText(item.getProvince());
                    ((HolderPrisonProvince) helper).attributeOmitId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOnClickoterminal != null) {
                                mOnClickoterminal.OnomitClick(v, ((HolderPrisonProvince) helper).attributeOmitId, item);
                            }
                        }
                    });
                }
                break;
            /**
             * 描述：选择当前的监狱
             */
            case EntityRegister.TYPE_FOUR:
                if (helper instanceof HolderCurrentPrison) {
                    ((HolderCurrentPrison) helper).attributeOmitId.setText(item.getPrison());
                    ((HolderCurrentPrison) helper).attributeOmitId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOnClickoterminal != null) {
                                mOnClickoterminal.OnPrisonClick(v, ((HolderCurrentPrison) helper).attributeOmitId, null);
                            }
                        }
                    });
                }
                break;

            /**
             * 描述：选择当前监区
             */
            case EntityRegister.TYPE_FIVE:
                if (helper instanceof HolderCurrentArea) {
                    ((HolderCurrentArea) helper).attributeOmitId.setText(item.getPrisonArea());
                    ((HolderCurrentArea) helper).attributeOmitId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOnClickoterminal != null) {
                                mOnClickoterminal.OnPrisonAreaClick(v, ((HolderCurrentArea) helper).attributeOmitId, item);
                            }
                        }
                    });
                }
                break;

            /**
             * 描述：选择安装位置
             */
            case EntityRegister.TYPE_SIX:
                if (helper instanceof HolderInstall) {
                    // ((HolderInstall)helper).attributeInstallId.setHint(item.getPosition());
                }
                break;


            case EntityRegister.TYPE_NINE:

                if (helper instanceof HolderSubmission) {
                    ((HolderSubmission) helper).attributeDetermineId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOnClickoterminal!=null){
                                mOnClickoterminal.OnDetermineClick(v, ((HolderSubmission) helper).attributeDetermineId,item);
                            }

                        }
                    });
                }
                break;
        }


    }

    public void setOnClickoterminal(onClickoterminal onClickoterminal) {
        this.mOnClickoterminal = onClickoterminal;

    }

    public interface onClickoterminal {
        /**
         * 描述：地址：端口号
         */
        void onschemaClick(String add, String prot);

        /**
         * 描述：监狱省份
         */
        void OnomitClick(View view, TextView textView, EntityRegister entityRegister);

        /**
         * 描述：当前监狱
         */
        void OnPrisonClick(View view, TextView textView, EntityRegister entityRegister);

        /**
         * 描述：当前监区
         */
        void OnPrisonAreaClick(View view, TextView textView, EntityRegister entityRegister);

        /**
         * 描述：提交注册
         */
        void OnDetermineClick(View view,Button button, EntityRegister entityRegister);


    }

    private TextWatcher watcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub

            mAdd = s.toString();
            KLog.a("内容监听", s.toString());

        }
    };
}
