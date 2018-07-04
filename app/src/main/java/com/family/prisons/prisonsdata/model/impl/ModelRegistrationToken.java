package com.family.prisons.prisonsdata.model.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.library.librarylog.Rlog;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonArea;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonTest;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvince;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvincePrison;
import com.family.prisons.prisonsdata.model.IModelRegistrationToken;
import com.family.prisons.prisonshttp.manager.HttpmanRegistrationToken;
import com.socks.library.KLog;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ThinkPad on 2018/6/12.
 */
@Route(path = "/prisonsdata/model/ModelRegistrationToken",name = "")
public class ModelRegistrationToken  implements IModelRegistrationToken{

    @Override
    public void getProvince(String token, final IUnifiedDataListener<EntityProvince> iUnifiedDataListener) {
        HttpmanRegistrationToken.getHttpmanRegistrationToken().getProvince(token)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityProvince>() {
                    @Override
                    public void accept(EntityProvince entityProvince) throws Exception {
                        Rlog.Log("获取监狱的省份","成功","0");
                        iUnifiedDataListener.success(entityProvince);

                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityProvince>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityProvince entityProvince) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("获取监狱的省份","失败","-1");
                        iUnifiedDataListener.fail(-1,"请求失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getProvincePrison(String token, String prisonCode, final IUnifiedDataListener<EntityProvincePrison> iUnifiedDataListener) {
       HttpmanRegistrationToken.getHttpmanRegistrationToken().getProvincePrison(token,prisonCode)
               .subscribeOn(Schedulers.newThread())
               .observeOn(Schedulers.io())
               .doOnNext(new Consumer<EntityProvincePrison>() {
                   @Override
                   public void accept(EntityProvincePrison entityProvincePrison) throws Exception {
                       Rlog.Log("获取省份监狱","成功","0");
                       iUnifiedDataListener.success(entityProvincePrison);
                   }
               })
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Subscriber<EntityProvincePrison>() {
                   @Override
                   public void onSubscribe(Subscription s) {

                   }

                   @Override
                   public void onNext(EntityProvincePrison entityProvincePrison) {

                   }

                   @Override
                   public void onError(Throwable t) {
                       Rlog.Log("获取省份监狱","失败","-1");
                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }

    @Override
    public void getPrisonArea(String token, String dwdm, final IUnifiedDataListener<EntityPrisonArea> iUnifiedDataListener) {
         HttpmanRegistrationToken.getHttpmanRegistrationToken().getPrisonArea(token,dwdm)
                 .subscribeOn(Schedulers.newThread())
                 .observeOn(Schedulers.io())
                 .doOnNext(new Consumer<EntityPrisonArea>() {
                     @Override
                     public void accept(EntityPrisonArea entityPrisonArea) throws Exception {
                         Rlog.Log("获取省份监狱监区","成功","0");
                         iUnifiedDataListener.success(entityPrisonArea);
                     }
                 })
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Subscriber<EntityPrisonArea>() {
                     @Override
                     public void onSubscribe(Subscription s) {

                     }

                     @Override
                     public void onNext(EntityPrisonArea entityPrisonArea) {

                     }

                     @Override
                     public void onError(Throwable t) {
                         Rlog.Log("获取省份监狱监区","失败","-1");
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
    }

    @Override
    public void getTest(String token, IUnifiedDataListener<EntityPrisonTest> iUnifiedDataListener) {
             HttpmanRegistrationToken.getHttpmanRegistrationToken().getTest(token)
                     .subscribeOn(Schedulers.newThread())
                     .observeOn(Schedulers.io())
                     .doOnNext(new Consumer<EntityPrisonTest>() {
                         @Override
                         public void accept(EntityPrisonTest entityPrisonTest) throws Exception {
                             Rlog.Log("测试服务器链接","成功","0");
                         }
                     })
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Subscriber<EntityPrisonTest>() {
                         @Override
                         public void onSubscribe(Subscription s) {

                         }

                         @Override
                         public void onNext(EntityPrisonTest entityPrisonTest) {

                         }

                         @Override
                         public void onError(Throwable t) {
                             Rlog.Log("测试服务器链接","失败","-1");
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
