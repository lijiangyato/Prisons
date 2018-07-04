package com.family.prisons.prisonsui.uidialing.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.library.librarythread.UtilsThread;
import com.family.prisons.R;
import com.family.prisons.prisonsdata.entitypplyform.EntityForm;
import com.family.prisons.prisonsfather.BaseActivity;
import com.family.prisons.prisonsservice.BluetoothManager;
import com.family.prisons.prisonsservice.LinphoneManager;
import com.family.prisons.prisonsservice.LinphonePreferences;
import com.family.prisons.prisonsservice.LinphoneService;
import com.family.prisons.prisonsservice.LinphoneUtils;
import com.family.prisons.prisonsui.uidialing.adapter.AdapterDialing;
import com.family.prisons.prisonsui.uidialing.presenter.IPresenterDialing;
import com.family.prisons.prisonsui.uidialing.presenter.impl.PresenterDialing;
import com.family.prisons.prisonsui.uidialing.view.IActivityDialingView;
import com.family.prisons.prisonutils.UtilsRecycler;
import com.socks.library.KLog;

import org.linphone.core.LinphoneAccountCreator;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListenerBase;
import org.linphone.mediastream.Version;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ThinkPad on 2018/6/15.
 */
@Route(path = "/prisonsui/activity/ActivityDialingView", name = "拨打电话")
public class ActivityDialingView extends BaseActivity implements IActivityDialingView {


    @BindView(R.id.attribute_custom_id)
    RecyclerView attributeCustomId;
    public AdapterDialing mAdapterDialing;
    public IPresenterDialing mIPresenterDialing;
    @BindView(R.id.name_long_id)
    Button nameLongId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialing_view);
        mIPresenterDialing = new PresenterDialing(this);
    }




    @Override
    public void initView() {
        /**
         * 描述：加载视图
         */
        attributeCustomId.setLayoutManager(new LinearLayoutManager(this));
        attributeCustomId.addItemDecoration(new UtilsRecycler(this, UtilsRecycler.VERTICAL_LIST, UtilsRecycler.DividerType.TYPE_E4E4E4));
        mAdapterDialing = new AdapterDialing(this, null);
    }

    @Override
    public void initData() {
       initLinephoneCore();
    }

    @Override
    public void setForm(EntityForm entityForm) {
        UtilsThread.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @OnClick(R.id.name_long_id)
    public void Ooclidog() {
        Tis();
    }



    private LinphoneCall mCall;
    public void  Tis(){

        UtilsThread.getInstance().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
                if (lc != null) {
                    lc.addListener(mListener);
                }
                // Only one call ringing at a time is allowed
                if (LinphoneManager.getLcIfManagerNotDestroyedOrNull() != null) {
                    List<LinphoneCall> calls = LinphoneUtils.getLinphoneCalls(LinphoneManager.getLc());
                    for (LinphoneCall call : calls) {
                        if (LinphoneCall.State.IncomingReceived == call.getState()) {
                            mCall = call;
                            break;
                        }
                    }
                }
                initSIPDialConfig("552010008", "lecent552010008",
                        "192.168.1.8","17684064738", "QQDH515520180611144958086447");
            }
        });
    }

    //Linephone config
    private LinphonePreferences mPrefs;
    private LinphonePreferences.AccountBuilder builder;
    private LinphoneAccountCreator accountCreator;
    private LinphoneCoreListenerBase mListener;

    public void initSIPDialConfig(String userName,String password,String proxy,String phone,String header) {
        LinphonePreferences.instance().setContext(this);
        mPrefs = LinphonePreferences.instance();
        builder = new LinphonePreferences.AccountBuilder(LinphoneManager.getLc());
        accountCreator = LinphoneCoreFactory.instance().createAccountCreator(LinphoneManager.getLc()
                , LinphonePreferences.instance().getXmlrpcUrl());
        builder.setUsername(userName);
        builder.setUserId("");
        builder.setPassword(password);
        builder.setDomain(proxy);
        builder.setTransport(LinphoneAddress.TransportType.LinphoneTransportUdp);
        builder.setExpires("3600");
        builder.setAvpfEnabled( false);
        try {
            builder.saveNewAccount();
            LinphoneManager.getLc().refreshRegisters();
            LinphoneManager.getInstance().newOutgoingCall("sip:"+phone+"@"+proxy,"",header);
        } catch (LinphoneCoreException e) {
            e.printStackTrace();
        }
    }


    private LinphoneCall.State phoneState;
    public void initLinephoneCore() {
        //电话拨打状态的回调
        mListener = new LinphoneCoreListenerBase(){
            @Override
            public void callState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State state, String message) {
                phoneState = state;
                if( LinphoneCall.State.CallEnd == state) {
                    finish();
                   KLog.a("lanzhu","CallEnd");

                }else if(LinphoneCall.State.Connected == state){
                    KLog.a("lanzhu","Connected");
                }else if(LinphoneCall.State.OutgoingRinging == state){
                    KLog.a("lanzhu","OutgoingRinging");
                }

                if (state == LinphoneCall.State.StreamsRunning) {
                    // The following should not be needed except some devices need it (e.g. Galaxy S).
                    LinphoneManager.getLc().enableSpeaker(LinphoneManager.getLc().isSpeakerEnabled());
                }
            }
        };
    }



}
