package com.family.prisons.prisonsdata.model.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.library.librarylog.Rlog;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entitypplyform.EntityAgree;
import com.family.prisons.prisonsdata.entitypplyform.EntityApproval;
import com.family.prisons.prisonsdata.entitypplyform.EntityBill;
import com.family.prisons.prisonsdata.entitypplyform.EntityForm;
import com.family.prisons.prisonsdata.entitypplyform.EntityTelephone;
import com.family.prisons.prisonsdata.entitypplyform.EntityWhiteList;
import com.family.prisons.prisonsdata.model.IModelApplyForm;
import com.family.prisons.prisonshttp.manager.HttpmanApplyForm;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ThinkPad on 2018/6/12.
 */
@Route(path = "/prisonsdata/model/ModelApplyForm", name = "")
public class ModelApplyForm implements IModelApplyForm {


    @Override
    public void getForm(String dwdm, String prisonerNo, String offset, String limit, String isDail, String status, IUnifiedDataListener<EntityForm> iUnifiedDataListener) {
        HttpmanApplyForm.getMhttpmanApplyForm().getForm(dwdm, prisonerNo, offset, limit, isDail, status)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityForm>() {
                    @Override
                    public void accept(EntityForm entityForm) throws Exception {
                        Rlog.Log("申请单查询","成功","0");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityForm>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityForm entityForm) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("申请单查询","失败","-1");

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getBill(String dwdm, String prisonerNo, String offset, String limit, IUnifiedDataListener<EntityBill> iUnifiedDataListener) {
        HttpmanApplyForm.getMhttpmanApplyForm().getBill(dwdm, prisonerNo, offset, limit)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityBill>() {
                    @Override
                    public void accept(EntityBill entityBill) throws Exception {
                        Rlog.Log("获取账单列表","成功","0");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityBill>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityBill entityBill) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("获取账单列表","失败","-1");

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getTelephone(String token, String dwdm, String offset, String limit, IUnifiedDataListener<EntityTelephone> iUnifiedDataListener) {
        HttpmanApplyForm.getMhttpmanApplyForm().getTelephone(token, dwdm, offset, limit)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityTelephone>() {
                    @Override
                    public void accept(EntityTelephone entityTelephone) throws Exception {
                        Rlog.Log("电话审批列表","成功","0");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityTelephone>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityTelephone entityTelephone) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("电话审批列表","失败","-1");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getWhiteList(String token, String dwdm, String prisonerNo, String offset, String limit, IUnifiedDataListener<EntityWhiteList> iUnifiedDataListener) {
        HttpmanApplyForm.getMhttpmanApplyForm().getWhiteList(token, dwdm, prisonerNo, offset, limit)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityWhiteList>() {
                    @Override
                    public void accept(EntityWhiteList entityWhiteList) throws Exception {
                        Rlog.Log("白名单","成功","0");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityWhiteList>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityWhiteList entityWhiteList) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("白名单","失败","-1");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getApproval(String token, String billNo, String status, String updateUserId, String updateUser, String isWhitelists, String illustrationText, String voiceIllustration, IUnifiedDataListener<EntityApproval> iUnifiedDataListener) {
        HttpmanApplyForm.getMhttpmanApplyForm().getApproval(token,billNo,status,updateUserId,updateUser,isWhitelists,illustrationText,voiceIllustration)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityApproval>() {
                    @Override
                    public void accept(EntityApproval entityApproval) throws Exception {
                        Rlog.Log("电话审批拒绝和同意","成功","0");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityApproval>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityApproval entityApproval) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("电话审批拒绝和同意","失败","-1");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getAgree(String billNo, String status, String updateUserId, String updateUser, String isWhitelists, IUnifiedDataListener<EntityAgree> iUnifiedDataListener) {
       HttpmanApplyForm.getMhttpmanApplyForm().getAgree(billNo,status,updateUserId,updateUser,isWhitelists)
               .subscribeOn(Schedulers.newThread())
               .observeOn(Schedulers.io())
               .doOnNext(new Consumer<EntityAgree>() {
                   @Override
                   public void accept(EntityAgree entityAgree) throws Exception {
                       Rlog.Log("电话审批拒绝和同意","成功","0");
                   }
               })
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Subscriber<EntityAgree>() {
                   @Override
                   public void onSubscribe(Subscription s) {

                   }

                   @Override
                   public void onNext(EntityAgree entityAgree) {

                   }

                   @Override
                   public void onError(Throwable t) {
                       Rlog.Log("电话审批拒绝和同意","失败","-1");
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
