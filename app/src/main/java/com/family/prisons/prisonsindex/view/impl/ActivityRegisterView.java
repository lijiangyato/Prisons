package com.family.prisons.prisonsindex.view.impl;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.family.library.librarythread.UtilsThread;
import com.family.prisons.R;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvince;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvincePrison;
import com.family.prisons.prisonsfather.BaseActivity;
import com.family.prisons.prisonshttp.constant.Constant;
import com.family.prisons.prisonsindex.adapter.AdapterRegister;
import com.family.prisons.prisonsindex.adapter.impl.AdapterArea;
import com.family.prisons.prisonsindex.adapter.impl.AdapterPrisonArea;
import com.family.prisons.prisonsindex.adapter.impl.AdapterUtilsWindow;
import com.family.prisons.prisonsindex.entity.EntityRegister;
import com.family.prisons.prisonsindex.entity.impl.EntityArea;
import com.family.prisons.prisonsindex.entity.impl.EntityPrisonArea;
import com.family.prisons.prisonsindex.entity.impl.EntityUtlisWindow;
import com.family.prisons.prisonsindex.presenter.IPresenterRegister;
import com.family.prisons.prisonsindex.presenter.impl.PresenterRegister;
import com.family.prisons.prisonsindex.view.IActivityRegisterView;
import com.family.prisons.prisonutils.UtilsDialoRg;
import com.family.prisons.prisonutils.UtilsDialoboang;
import com.family.prisons.prisonutils.UtilsPrisonArea;
import com.family.prisons.prisonutils.UtilsRecycler;
import com.family.prisons.prisonutils.UtilsWindow;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import butterknife.BindView;


/**
 * Created by ThinkPad on 2018/6/13.
 */

public class ActivityRegisterView extends BaseActivity implements IActivityRegisterView {
    @BindView(R.id.attribute_service_add)
    RecyclerView attributeServiceAdd;

    private AdapterRegister mAdapterRegister;

    private List<EntityRegister> mRegisterList = new ArrayList<>();

    private IPresenterRegister mIPresenterRegister;

    private UtilsWindow mUtilsWindow;

    private UtilsPrisonArea mCutilsPrisonArea;

    private UtilsPrisonArea mTilsPrisonArea;

    public AdapterUtilsWindow mAdapterUtilsWindow;

    public AdapterPrisonArea mAdapterPrisonArea;

    public AdapterArea mAdapterArea;

    public UtilsDialoboang utilsDialogt;

    public UtilsDialoRg mToolsLoadingDialog;

    private List<EntityUtlisWindow> mEntityUtlisWindows = new ArrayList<>();

    private List<EntityPrisonArea> mEntityPrisonAreas = new ArrayList<>();

    private List<EntityArea> mEntityAreas = new ArrayList<>();

    public EntityRegister register3 = new EntityRegister();

    public EntityRegister register4 = new EntityRegister();

    public EntityRegister register5 = new EntityRegister();

    public String mDwdm;//监狱

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        mIPresenterRegister = new PresenterRegister(this);
        utilsDialogt = new UtilsDialoboang(ActivityRegisterView.this);
        iniview();
        mIPresenterRegister.displaypresenter();


    }


    @Override
    public void initView() {
        /**
         * 描述：注册页面初始化
         */
        attributeServiceAdd.setLayoutManager(new LinearLayoutManager(this));
        attributeServiceAdd.addItemDecoration(new UtilsRecycler(this, UtilsRecycler.VERTICAL_LIST, UtilsRecycler.DividerType.TYPE_E4E4E4));
        mAdapterRegister = new AdapterRegister(null, this);
        attributeServiceAdd.setAdapter(mAdapterRegister);
        /**
         * 描述：监狱省份的页面初始化
         */
        mUtilsWindow = new UtilsWindow(ActivityRegisterView.this);
        mUtilsWindow.setBackgroundDrawable(new ColorDrawable());
        mAdapterUtilsWindow = new AdapterUtilsWindow(ActivityRegisterView.this, null);
        mUtilsWindow.setAdapter(mAdapterUtilsWindow);

        /**
         * 描述：具体省份的具体监狱
         */
        mCutilsPrisonArea = new UtilsPrisonArea(ActivityRegisterView.this);
        mCutilsPrisonArea.setBackgroundDrawable(new ColorDrawable());
        mAdapterPrisonArea = new AdapterPrisonArea(ActivityRegisterView.this, null);
        mCutilsPrisonArea.setAdapter(mAdapterPrisonArea);

        /**
         * 描述：具体监区
         */
        mTilsPrisonArea = new UtilsPrisonArea(ActivityRegisterView.this);
        mTilsPrisonArea.setBackgroundDrawable(new ColorDrawable());
        mAdapterArea = new AdapterArea(ActivityRegisterView.this, null);
        mTilsPrisonArea.setAdpterprea(mAdapterArea);

    }


    @Override
    public void initData() {
        /**
         * 描述：父亲类适配器
         */
        mAdapterRegister.setOnClickoterminal(new AdapterRegister.onClickoterminal() {
            @Override
            public void onschemaClick(String add, String prot) {
                KLog.a("服务器地址", add, "端口号" + prot);
                Constant.URL = "http://" + add + ":" + prot + "/";
                mIPresenterRegister.getProvince("123");

                setLoad();
            }

            @Override
            public void OnomitClick(View view, final TextView textView, EntityRegister entityRegister) {

                UtilsThread.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mUtilsWindow.showAsDropDown(textView);

                    }
                });


            }

            @Override
            public void OnPrisonClick(View view, TextView textView, EntityRegister entityRegister) {
                mCutilsPrisonArea.showAsDropDown(textView);

            }

            @Override
            public void OnPrisonAreaClick(View view, TextView textView, EntityRegister entityRegister) {
                mTilsPrisonArea.showAsDropDown(textView);
            }

            @Override
            public void OnDetermineClick(View view, Button button, EntityRegister entityRegister) {
                setLoad();
                mIPresenterRegister.getRegister(
                        "123",
                        "8",
                        "192.168.1.7",
                        "ae.a4.eb.c",
                        "5155",
                        "达州监狱",
                        "5100",
                        "四川省监狱管理局",
                        "2961",
                        "一监区"
                );
            }
        });

        /**
         * 描述：监狱省份适配器
         */
        mAdapterUtilsWindow.setonSublistinterfacea(new AdapterUtilsWindow.onSublistinterface() {
            @Override
            public void OnSublistClick(View view, EntityUtlisWindow entityUtlisWindow) {
                mIPresenterRegister.getProvincePrison("123", entityUtlisWindow.getPrisonCode());
                register3.setProvince(entityUtlisWindow.getPrisonName());
                mAdapterRegister.notifyDataSetChanged();
                mUtilsWindow.dismiss();

            }
        });
        /**
         * 描述：当前监狱适配器
         */
        mAdapterPrisonArea.setonSublistinterfacea(new AdapterPrisonArea.onSublistinterface() {
            @Override
            public void OnSublistClick(View view, EntityPrisonArea entityPrisonArea) {
                mDwdm="5155";
                mIPresenterRegister.getPrisonArea("123", "5155");
                register4.setPrison(entityPrisonArea.getPrisonName());
                mAdapterRegister.notifyDataSetChanged();
                mCutilsPrisonArea.dismiss();
            }
        });

        /**
         * 描述：当前监区适配器
         */
        mAdapterArea.setOnareainterfacea(new AdapterArea.Onareainterface() {
            @Override
            public void OnareaClick(View view, EntityArea entityArea) {
                register5.setPrisonArea(entityArea.getPrisonName());
                mAdapterRegister.notifyDataSetChanged();
                mTilsPrisonArea.dismiss();
            }
        });
    }

    /**
     * 描述：初始化
     */
    public void iniview() {

    }

    /**
     * 描述：显示注册页面视图
     */
    @Override
    public void displayview() {
        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 描述：终端配置
                 */
                EntityRegister register0 = new EntityRegister();
                register0.setItemType(EntityRegister.TYPE_EIGHT);
                mRegisterList.add(register0);

                EntityRegister register1 = new EntityRegister();
                register1.setItemType(EntityRegister.TYPE_ONE);
                mRegisterList.add(register1);

                EntityRegister register2 = new EntityRegister();
                register2.setItemType(EntityRegister.TYPE_TWO);
                mRegisterList.add(register2);
                /**
                 * 描述：请选择监狱省份
                 */
                // EntityRegister register3 = new EntityRegister();
                register3.setItemType(EntityRegister.TYPE_THREE);
                register3.setProvince("请选择监狱省份");
                mRegisterList.add(register3);
                /**
                 * 描述：请选择当前监狱
                 */
                // EntityRegister register4 = new EntityRegister();
                register4.setItemType(EntityRegister.TYPE_FOUR);
                register4.setPrison("请选择当前监狱");
                mRegisterList.add(register4);

                /**
                 * 描述：请选择当前监区
                 */
                // EntityRegister register5 = new EntityRegister();
                register5.setItemType(EntityRegister.TYPE_FIVE);
                register5.setPrisonArea("请选择当前监区");
                mRegisterList.add(register5);

                EntityRegister register6 = new EntityRegister();
                register6.setItemType(EntityRegister.TYPE_SIX);
                register6.setPosition("请选择安装位置");
                mRegisterList.add(register6);

                EntityRegister register7 = new EntityRegister();
                register7.setItemType(EntityRegister.TYPE_SEVEN);
                mRegisterList.add(register7);


                EntityRegister entityRegister9 = new EntityRegister();
                entityRegister9.setItemType(EntityRegister.TYPE_NINE);
                mRegisterList.add(entityRegister9);

                mAdapterRegister.setNewData(mRegisterList);
            }
        });
    }

    /**
     * 描述：监狱省份回调数据
     */
    @Override
    public void setProvince(final EntityProvince entityProvince) {

        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setCloseLoad(0,null,null);
                if (mEntityUtlisWindows == null) {
                    for (int i = 0; i < entityProvince.getData().size(); i++) {
                        EntityUtlisWindow entityUtlisWindow0 = new EntityUtlisWindow();
                        entityUtlisWindow0.setItemType(EntityUtlisWindow.TYPE_ONE);
                        entityUtlisWindow0.setPrisonName(entityProvince.getData().get(i).getPrisonName());
                        entityUtlisWindow0.setPrisonCode(entityProvince.getData().get(i).getPrisonCode());
                        KLog.a("prisoncode", entityProvince.getData().get(i).getPrisonCode());
                        mEntityUtlisWindows.add(entityUtlisWindow0);
                    }
                    mAdapterUtilsWindow.setNewData(mEntityUtlisWindows);
                } else {
                    mEntityUtlisWindows.clear();
                    for (int i = 0; i < entityProvince.getData().size(); i++) {
                        EntityUtlisWindow entityUtlisWindow0 = new EntityUtlisWindow();
                        entityUtlisWindow0.setItemType(EntityUtlisWindow.TYPE_ONE);
                        entityUtlisWindow0.setPrisonName(entityProvince.getData().get(i).getPrisonName());
                        entityUtlisWindow0.setPrisonCode(entityProvince.getData().get(i).getPrisonCode());
                        mEntityUtlisWindows.add(entityUtlisWindow0);
                    }
                    mAdapterUtilsWindow.setNewData(mEntityUtlisWindows);
                }

            }
        });


    }

    /**
     * 描述：具体监狱省份回调数据
     */
    @Override
    public void setProvincePrison(EntityProvincePrison entityProvincePrison) {


        if (mEntityPrisonAreas == null) {
            for (int i = 0; i < entityProvincePrison.getData().size(); i++) {
                EntityPrisonArea entityPrisonArea0 = new EntityPrisonArea();
                entityPrisonArea0.setItemType(EntityUtlisWindow.TYPE_ONE);
                entityPrisonArea0.setPrisonName(entityProvincePrison.getData().get(i).getDwdmName());
                entityPrisonArea0.setDwdm(entityProvincePrison.getData().get(i).getDwdm());
                mEntityPrisonAreas.add(entityPrisonArea0);
            }
            mAdapterPrisonArea.setNewData(mEntityPrisonAreas);
        } else {
            mEntityPrisonAreas.clear();
            for (int i = 0; i < entityProvincePrison.getData().size(); i++) {
                EntityPrisonArea mentityPrisonArea0 = new EntityPrisonArea();
                mentityPrisonArea0.setItemType(EntityUtlisWindow.TYPE_ONE);
                mentityPrisonArea0.setDwdm(entityProvincePrison.getData().get(i).getDwdm());
                mentityPrisonArea0.setPrisonName(entityProvincePrison.getData().get(i).getDwdmName());
                mEntityPrisonAreas.add(mentityPrisonArea0);
            }
            mAdapterPrisonArea.setNewData(mEntityPrisonAreas);
        }


    }

    /**
     * 描述：监区返回数据
     */
    @Override
    public void setPrisonArea(final com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonArea response) {
        KLog.a("当前监区的信息", response.getData().size() + "");

        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < response.getData().size(); i++) {
                    EntityArea entityArea0 = new EntityArea();
                    entityArea0.setItemType(EntityRegister.TYPE_ONE);

                    entityArea0.setPrisonName(response.getData().get(i).getPrisonAreaName());
                    mEntityAreas.add(entityArea0);
                }


                mAdapterArea.setNewData(mEntityAreas);

            }
        });


    }

    @Override
    public void getRegister(com.family.prisons.prisonsdata.entityphoneregister.EntityRegister entityRegister) {
        setCloseLoad(1,"5155","2961");
    }


    @Override
    public void setLoad() {

        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mToolsLoadingDialog = new UtilsDialoRg(mContext);
                mToolsLoadingDialog.show();
            }
        });

    }

    @Override
    public void setCloseLoad(final int cod, final String dwdm, final String prisonAreaCode) {
        new Handler(getMainLooper()).postDelayed(new TimerTask() {
            @Override
            public void run() {
                //utilsDialogt.dismiss();
                mToolsLoadingDialog.dismiss();
                switch (cod) {
                    case 0:
                        break;
                    case 1:
                        ARouter.getInstance().build("/prisonsmain/activity/ActivityMainView")
                                .withString("dwdm",dwdm)
                                .withString("prisonAreaCode",prisonAreaCode)
                                .navigation();
                        break;
                }

            }
        }, 4000);
    }


}
