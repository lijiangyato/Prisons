package com.family.prisons.prisonsmain.view.impl;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.arjinmc.recyclerviewdecoration.RecyclerViewItemDecoration;
import com.family.library.librarythread.UtilsThread;
import com.family.prisons.R;
import com.family.prisons.prisonsdata.entitycalllnformation.EntitySignIn;
import com.family.prisons.prisonsfather.BaseActivity;
import com.family.prisons.prisonsmain.adapter.AdapterMain;
import com.family.prisons.prisonsmain.entity.EntityMain;
import com.family.prisons.prisonsmain.entity.Entitymsg;
import com.family.prisons.prisonsmain.presenter.IPresenterMain;
import com.family.prisons.prisonsmain.presenter.impl.PresenterMain;
import com.family.prisons.prisonsmain.view.IActivityMainView;

import com.family.prisons.prisonsservice.BluetoothManager;
import com.family.prisons.prisonsservice.LinphoneService;
import com.family.prisons.prisonutils.AnimUtil;
import com.family.prisons.prisonutils.UtilsJxUtil;
import com.thinkcool.circletextimageview.CircleTextImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.linphone.mediastream.Version;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jx.vein.javajar.JXFVJavaInterface;


@Route(path = "/prisonsmain/activity/ActivityMainView", name = "主菜单加登陆页面")

public class ActivityMainView extends BaseActivity implements IActivityMainView, View.OnClickListener {

    @BindView(R.id.attribute_menu_id)
    RecyclerView attributeMenuId;
    public AdapterMain mAdapterMain;
    public IPresenterMain miPresenterMain;
    public JXFVJavaInterface mJxfvJavaInterface;

    public boolean aBoolean = true;
    public long USB;

    public List<EntityMain> mEntityMains = new ArrayList<>();
    public UtilsDialog utilsDialog;
    @BindView(R.id.name_imaveiwo_id)
    ImageView nameImaveiwoId;
    private Dialog mDownloadDialong;
    public CircleTextImageView mImageView;
    @Autowired
    String dwdm;
    @Autowired
    String prisonAreaCode;
    public ImageView mImageViewQih;
    public View mView;
    private boolean mIsShowBack = false;
    private AnimatorSet mLeftInSet;
    private AnimatorSet mRightOutSet;
    private int TIME = 1000;

    public LinearLayout mLinearLayout;
    public LinearLayout mFlCardFront;
    public FrameLayout mFrameLayout;
    private SharedPreferences sharedPreferencesx;
    public String mFingervein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        sharedPreferencesx = ActivityMainView.this.getSharedPreferences("information", Context.MODE_PRIVATE);
        mFingervein = sharedPreferencesx.getString("fingervein", "00");

        // utilsDialogt = new UtilsDialoboang(ActivityMainView.this);
        utilsDialog = new UtilsDialog(ActivityMainView.this);
        miPresenterMain = new PresenterMain(this);

        iniview();
        miPresenterMain.displaypresenter();


    }

    /**
     * 描述：初始化
     */
    public void iniview() {

    }

    /**
     * 描述：初始化适配和滚动条
     */
    @Override
    public void initView() {
        attributeMenuId.setLayoutManager(new GridLayoutManager(this, 2));
        attributeMenuId.addItemDecoration(new RecyclerViewItemDecoration.Builder(this)

                .dashGap(20)
                .thickness(19)
                /* .gridBottomVisible(true) //control bottom border
                 .gridTopVisible(true) //control top border
                 .gridLeftVisible(true) //control left border
                 .gridRightVisible(true) //control right border*/
                .gridHorizontalSpacing(30)
                .gridVerticalSpacing(30)
                .create());
        //attributeMenuId.setHasFixedSize(true);

        mAdapterMain = new AdapterMain(null, this);
        attributeMenuId.setAdapter(mAdapterMain);
    }

    /**
     * 描述：父类方法
     */
    @Override
    public void initData() {

        initLinePhoneData();
        mAdapterMain.setOnFamilyAffectionInterface(new AdapterMain.onFamilyAffectionInterface() {
            @Override
            public void OnDialClick(View view, String Address, EntityMain entityMain) {

                Tiao(Address);
            }

            @Override
            public void OnApplyClick(View view, String address, EntityMain entityMain) {
                Tiao(address);
            }

            @Override
            public void OnApproveClick(View view, String address, EntityMain entityMain) {
                Tiao(address);
            }

            @Override
            public void OnUrgentClick(View view, String address, EntityMain entityMain) {
                Tiao(address);
            }

            @Override
            public void OnBillClick(View view, String address, EntityMain entityMain) {
                Tiao(address);
            }

            @Override
            public void OnUpdateClick(View view, String addrsss, EntityMain entityMain) {

            }
        });
    }

    /**
     * 描述：页面跳转
     */
    public void  Tiao(String addrsss){
        if (mFingervein=="00"){

        }
        else {
            ejectview();
            //ARouter.getInstance().build(addrsss).navigation();
        }
    }
    /**
     * 描述：加载视图
     */
    @Override
    public void displayview() {

        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 描述：犯人个人信息
                 */
               /* EntityMain entityMain2=new EntityMain();
                entityMain2.setItemType(EntityMain.TYPE_TWO);
                mEntityMains.add(entityMain2);*/

                /**
                 * 描述：拨打电话
                 */
                EntityMain entityMain3 = new EntityMain();
                entityMain3.setItemType(EntityMain.TYPE_THREE);
                entityMain3.setAddress("/prisonsui/activity/ActivityDialingView");
                mEntityMains.add(entityMain3);

                /**
                 * 描述：申请单查询
                 */
                EntityMain entityMain4 = new EntityMain();
                entityMain4.setItemType(EntityMain.TYPE_FOUR);
                entityMain4.setAddress("/prisonsui/activity/ActivityApplyinquiriesView");
                mEntityMains.add(entityMain4);
                /**
                 * 描述：电话审批
                 */
                EntityMain entityMain5 = new EntityMain();
                entityMain5.setItemType(EntityMain.TYPE_FIVE);
                entityMain5.setAddress("/prisonsui/activity/ActivityApprovalView");
                mEntityMains.add(entityMain5);
                /**
                 * 描述：紧急拨打
                 */
                EntityMain entityMain6 = new EntityMain();
                entityMain6.setItemType(EntityMain.TYPE_SIX);
                entityMain6.setAddress("/prisonsui/activity/ActivityUrgentView");
                mEntityMains.add(entityMain6);
                /**
                 * 描述：账单查询
                 */
                EntityMain entityMain7 = new EntityMain();
                entityMain7.setItemType(EntityMain.TYPE_SEVEN);
                entityMain7.setAddress("/prisonsui/activity/ActivityBillingInquiriesView");
                mEntityMains.add(entityMain7);
                /**
                 * 描述：应用升级
                 */
                EntityMain entityMain8 = new EntityMain();
                entityMain8.setItemType(EntityMain.TYPE_EIGHT);
                entityMain8.setAddress("未添加");
                mEntityMains.add(entityMain8);
                mAdapterMain.setNewData(mEntityMains);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onbitm(Entitymsg entitymsg) {

    }

    /**
     * 描述：登录弹出框
     */
    @Override
    public void ejectview() {
        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                utilsDialog.setCanceledOnTouchOutside(false);
                utilsDialog.setCancelable(false);
                utilsDialog.show();
                utilsDialog.setoNdialgueClick(new UtilsDialog.oNdialgueClick() {
                    @Override
                    public void doSomeClick() {

                        UtilsThread.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMainView.this);
                                mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_vein_layout, null);

                                mImageView = mView.findViewById(R.id.name_zhijiangmai_id);
                                //指静脉
                                mLinearLayout = mView.findViewById(R.id.attribute_linearlayout_id);
                                //输入密码
                                mFlCardFront = mView.findViewById(R.id.attribute_linearlayo_id);
                                //主人布局
                                mFrameLayout = mView.findViewById(R.id.main_fl_container);
                                //切换按钮
                                //imageView=mView.findViewById(R.id.name_view);
                                //设置监听
                                mFrameLayout.setOnClickListener(ActivityMainView.this);

                                setAnimators(ActivityMainView.this, mFrameLayout);
                                setCameraDistance(ActivityMainView.this, mLinearLayout, mFlCardFront);
                                builder.setView(mView);
                                mDownloadDialong = builder.create();
                                mDownloadDialong.show();

                                if (aBoolean != false) {
                                    jxfvview();
                                    aBoolean = false;
                                } else {
                                    miPresenterMain.jxIsVeinImgOK(USB, mJxfvJavaInterface);
                                }

                            }
                        });


                    }
                });

            }
        });
    }


    /**
     * 描述：初始化USB
     */
    @Override
    public void jxfvview() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (mJxfvJavaInterface == null) {
                    mJxfvJavaInterface = new JXFVJavaInterface();
                    /**
                     * 描述：初始USB驱动
                     */
                    long usb = mJxfvJavaInterface.jxInitUSBDriver();
                    USB = usb;
                    miPresenterMain.jxIsFVDConnected(usb, mJxfvJavaInterface);

                }
            }
        }).start();


    }

    @Override
    public void setLoad() {

    }

    @Override
    public void setCloseLoad(int cod) {

    }

    /**
     * 描述：检查指静脉
     */
    @Override
    public void jxIsFVDConnected(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        miPresenterMain.jxConnFVD(usb, mJxfvJavaInterface);
    }

    /**
     * 描述：连接设备
     */
    @Override
    public void jxConnFVD(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        miPresenterMain.jxIsFingerDetected(usb, mJxfvJavaInterface);
    }

    /**
     * 描述：检查手指
     */
    @Override
    public void jxIsFingerDetected(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        miPresenterMain.jxInitCapEnv(usb, mJxfvJavaInterface);
    }

    /**
     * 描述：初始话
     */
    @Override
    public void jxInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        miPresenterMain.jxDeInitCapEnv(usb, mJxfvJavaInterface);
    }

    /**
     * 描述：复位
     */
    @Override
    public void jxDeInitCapEnv(long usb, JXFVJavaInterface mJxfvJavaInterface) {
        miPresenterMain.jxIsVeinImgOK(usb, mJxfvJavaInterface);
    }

    /**
     * 描述：采集手里值原图
     */
    @Override
    public void jxIsVeinImgOK(long usb, JXFVJavaInterface mJxfvJavaInterface, final byte[] jxc) {
        miPresenterMain.jxLoadVeinSample(usb, mJxfvJavaInterface);
        final Bitmap bitmap = UtilsJxUtil.veinDataToBitmap(jxc);
        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (bitmap != null) {
                    mImageView.setImageBitmap(bitmap);
                    SharedPreferences.Editor editor = sharedPreferencesx.edit();
                    //保持指静脉数据
                    editor.putString("fingervein", UtilsJxUtil.bytes2string(jxc));
                    editor.commit();
                }

            }
        });

    }

    /**
     * 描述：样本
     */
    @Override
    public void jxLoadVeinSample(long usb, JXFVJavaInterface mJxfvJavaInterface, final byte[] jxc) {
        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = UtilsJxUtil.veinDataToBitmap(jxc);
                String loginData = Base64.encodeToString(jxc, Base64.DEFAULT);
                // miPresenterMain.getSignIn("123",dwdm,prisonAreaCode,"4",loginData);
            }
        });
    }

    @Override
    public void setSignIn(EntitySignIn entitySignIn) {

    }


    // 设置动画
    public void setAnimators(Context context, final FrameLayout mFlContainer) {
        mLeftInSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.anim_in);
        mRightOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.anim_out);

        // 设置点击事件
        mRightOutSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mFlContainer.setClickable(false);
            }
        });
        mLeftInSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mFlContainer.setClickable(true);
            }
        });
    }

    // 改变视角距离, 贴近屏幕
    public static void setCameraDistance(Context context, LinearLayout mFlCardFront_, LinearLayout mFlCardBack_) {
        int distance = 16000;
        float scale = context.getResources().getDisplayMetrics().density * distance;
        mFlCardFront_.setCameraDistance(scale);
        mFlCardBack_.setCameraDistance(scale);
    }

    public void setFlipCard() {
        // 正面朝上
        if (mIsShowBack == true) {


            mRightOutSet.setTarget(mFlCardFront);
            mLeftInSet.setTarget(mLinearLayout);
            mRightOutSet.start();
            mLeftInSet.start();
            mIsShowBack = false;
        } else { // 背面朝上
            mRightOutSet.setTarget(mLinearLayout);
            mLeftInSet.setTarget(mFlCardFront);
            mRightOutSet.start();
            mLeftInSet.start();
            mIsShowBack = true;
        }
    }


    @Override
    public void onClick(View v) {

        setFlipCard();
    }



    ServiceWaitThread mThread;
    public void initLinePhoneData() {
        mHandler = new Handler();
        if (LinphoneService.isReady()) {
            onServiceReady();
        } else {
            // start linphone as background
            startService(new Intent(this,LinphoneService.class));
            mThread = new ServiceWaitThread();
            mThread.start();
        }
    }

    private Handler mHandler;

    private class ServiceWaitThread extends Thread {
        public void run() {
            while (!LinphoneService.isReady()) {
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException("waiting thread sleep() has been interrupted");
                }
            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onServiceReady();
                }
            });
            mThread = null;
        }
    }

    protected void onServiceReady() {
        // We need LinphoneService to start bluetoothManagerr
        UtilsThread.getInstance().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (Version.sdkAboveOrEqual(Version.API11_HONEYCOMB_30)) {
                    BluetoothManager.getInstance().initBluetooth();
                }
            }
        });


    }
}
