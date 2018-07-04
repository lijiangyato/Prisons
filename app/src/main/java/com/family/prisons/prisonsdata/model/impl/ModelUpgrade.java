package com.family.prisons.prisonsdata.model.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.library.librarylog.Rlog;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityupload.EntityJournal;
import com.family.prisons.prisonsdata.entityupload.EntityToUpdate;
import com.family.prisons.prisonsdata.model.IModelUpgrade;
import com.family.prisons.prisonshttp.manager.HttpmanUpgrade;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ThinkPad on 2018/6/12.
 */
@Route(path = "/prisonsdata/model/ModelUpgrade",name = "")
public class ModelUpgrade implements IModelUpgrade {

    @Override
    public void getUpload(String token, IUnifiedDataListener<EntityToUpdate> iUnifiedDataListener) {
        HttpmanUpgrade.getmHttpmanUpgrade().getUpload(token)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityToUpdate>() {
                    @Override
                    public void accept(EntityToUpdate entityToUpdate) throws Exception {
                        Rlog.Log("应用升级","成功","0");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityToUpdate>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityToUpdate entityToUpdate) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("应用升级","失败","-1");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getJournal(String logType, String terminalId, String prisonAreaCode, String prisonAreaName, String requestUrl, String queryParam, String method, String exceptionCause, String exceptionDetail, IUnifiedDataListener<EntityJournal> iUnifiedDataListener) {
          HttpmanUpgrade.getmHttpmanUpgrade().getJournal(logType,terminalId,prisonAreaCode,prisonAreaName,requestUrl,queryParam,method,exceptionCause,exceptionDetail)
                  .subscribeOn(Schedulers.newThread())
                  .observeOn(Schedulers.io())
                  .doOnNext(new Consumer<EntityJournal>() {
                      @Override
                      public void accept(EntityJournal entityJournal) throws Exception {
                          Rlog.Log("异常日志上传","成功","0");
                      }
                  })
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Subscriber<EntityJournal>() {
                      @Override
                      public void onSubscribe(Subscription s) {

                      }

                      @Override
                      public void onNext(EntityJournal entityJournal) {

                      }

                      @Override
                      public void onError(Throwable t) {
                          Rlog.Log("异常日志上传","失败","-1");
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
