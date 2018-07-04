package com.family.prisons.prisonsdata.model.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.library.librarylog.Rlog;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityCalllnformation;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityPrisonGuardSignin;
import com.family.prisons.prisonsdata.entitycalllnformation.EntitySignIn;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityUrgent;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.model.IModelCalllnformation;
import com.family.prisons.prisonshttp.manager.HttpmanCalllnformation;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ThinkPad on 2018/6/12.
 */
@Route(path = "/prisonsdata/model/ModelCalllnformation",name = "")
public class ModelCalllnformation implements IModelCalllnformation {

    @Override
    public void getCalllnformation(String token, String dwdm, String prisonerNo, IUnifiedDataListener<EntityCalllnformation> iUnifiedDataListener) {
        HttpmanCalllnformation.getHttpmanCalllnformation().getCalllnformation(token,dwdm,prisonerNo)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityCalllnformation>() {
                    @Override
                    public void accept(EntityCalllnformation entityCalllnformation) throws Exception {
                        Rlog.Log("获取犯人通话信息","成功","0");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityCalllnformation>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityCalllnformation entityCalllnformation) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("获取犯人通话信息","失败","-1");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getSignIn(String token, String dwdm, String prisonAreaCode, String loginRole, String loginData, IUnifiedDataListener<EntitySignIn> iUnifiedDataListener) {
           HttpmanCalllnformation.getHttpmanCalllnformation().getSignIn(token,dwdm,prisonAreaCode,loginRole,loginData)
                   .subscribeOn(Schedulers.newThread())
                   .observeOn(Schedulers.io())
                   .doOnNext(new Consumer<EntitySignIn>() {
                       @Override
                       public void accept(EntitySignIn entitySignIn) throws Exception {
                           Rlog.Log("登陆","成功","0");
                       }
                   })
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new Subscriber<EntitySignIn>() {
                       @Override
                       public void onSubscribe(Subscription s) {

                       }

                       @Override
                       public void onNext(EntitySignIn entitySignIn) {

                       }

                       @Override
                       public void onError(Throwable t) {
                           Rlog.Log("登陆","失败","-1");
                       }

                       @Override
                       public void onComplete() {

                       }
                   });
    }

    @Override
    public void getPrisonGuardSignin(String token, String dwdm, String prisonAreaCode, String loginRole, String loginData, IUnifiedDataListener<EntityPrisonGuardSignin> iUnifiedDataListener) {
         HttpmanCalllnformation.getHttpmanCalllnformation().getPrisonGuardSignin(token,dwdm,prisonAreaCode,loginRole,loginData)
                 .subscribeOn(Schedulers.newThread())
                 .observeOn(Schedulers.io())
                 .doOnNext(new Consumer<EntityPrisonGuardSignin>() {
                     @Override
                     public void accept(EntityPrisonGuardSignin entityPrisonGuardSignin) throws Exception {
                         Rlog.Log("登陆 狱警","成功","0");
                     }
                 })
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Subscriber<EntityPrisonGuardSignin>() {
                     @Override
                     public void onSubscribe(Subscription s) {

                     }

                     @Override
                     public void onNext(EntityPrisonGuardSignin entityPrisonGuardSignin) {

                     }

                     @Override
                     public void onError(Throwable t) {
                         Rlog.Log("登陆 狱警","失败","-1");
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
    }

    @Override
    public void getUrgent(String token, String dwdm, String prisonerNo, String callNumber, String updateUser, String updateUserId, String relationName, String relationId, String callName, IUnifiedDataListener<EntityUrgent> iUnifiedDataListener) {
             HttpmanCalllnformation.getHttpmanCalllnformation().getUrgent(token,dwdm,prisonerNo,callNumber,updateUser,updateUserId,relationName,relationId,callName)
                     .subscribeOn(Schedulers.newThread())
                     .observeOn(Schedulers.io())
                     .doOnNext(new Consumer<EntityUrgent>() {
                         @Override
                         public void accept(EntityUrgent entityUrgent) throws Exception {
                             Rlog.Log("紧急拨打","成功","0");
                         }
                     })
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Subscriber<EntityUrgent>() {
                         @Override
                         public void onSubscribe(Subscription s) {

                         }

                         @Override
                         public void onNext(EntityUrgent entityUrgent) {

                         }

                         @Override
                         public void onError(Throwable t) {
                             Rlog.Log("紧急拨打","失败","-1");
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
