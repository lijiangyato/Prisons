package com.family.prisons.prisonsdata.model.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.library.librarylog.Rlog;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityphoneregister.EntityRegister;
import com.family.prisons.prisonsdata.entityphoneregister.EntitySipAccount;
import com.family.prisons.prisonsdata.model.IModelPhoneRegister;
import com.family.prisons.prisonshttp.manager.HttpmanPhoneRegister;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ThinkPad on 2018/6/12.
 */
@Route(path = "/prisonsdata/model/ModelPhoneRegister",name = "")

public class ModelPhoneRegister implements IModelPhoneRegister {

    @Override
    public void getRegister(String token, String phoneNo, String ip, String mac, String dwdm, String dwdmName, String prisonCode, String prisonName, String prisonAreaCode, String prisonAreaName, final IUnifiedDataListener<EntityRegister> iUnifiedDataListener) {
        HttpmanPhoneRegister.getHttpmanPhoneRegister().getRegister(token,phoneNo,ip,mac,dwdm,dwdmName,prisonCode,prisonName,prisonAreaCode,prisonAreaName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityRegister>() {
                    @Override
                    public void accept(EntityRegister entityRegister) throws Exception {
                        Rlog.Log("话机注册","成功","0");
                        iUnifiedDataListener.success(entityRegister);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityRegister>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityRegister entityRegister) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("话机注册","失败","-1");
                        iUnifiedDataListener.fail(1,"注册失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getSipAccount(String token, String phoneNo, String dwdm, IUnifiedDataListener<EntitySipAccount> iUnifiedDataListener) {
               HttpmanPhoneRegister.getHttpmanPhoneRegister().getSipAccount(token,phoneNo,dwdm)
                       .subscribeOn(Schedulers.newThread())
                       .observeOn(Schedulers.io())
                       .doOnNext(new Consumer<EntitySipAccount>() {
                           @Override
                           public void accept(EntitySipAccount entitySipAccount) throws Exception {
                               Rlog.Log("获取SIP账号","成功","0");
                           }
                       })
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(new Subscriber<EntitySipAccount>() {
                           @Override
                           public void onSubscribe(Subscription s) {

                           }

                           @Override
                           public void onNext(EntitySipAccount entitySipAccount) {

                           }

                           @Override
                           public void onError(Throwable t) {
                               Rlog.Log("获取SIP账号","失败","-1");
                           }

                           @Override
                           public void onComplete() {

                           }
                       });
    }

    @Override
    public void init(Context context) {

    }
}
