package com.family.prisons.prisonsdata.model.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.family.library.librarylog.Rlog;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityvoice.EntityAbnormalUpload;
import com.family.prisons.prisonsdata.entityvoice.EntityUpload;
import com.family.prisons.prisonsdata.model.IModelVolce;
import com.family.prisons.prisonshttp.manager.HttpmanVoice;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ThinkPad on 2018/6/12.
 */
@Route(path = "/prisonsdata/model/ModelVolce",name = "")
public class ModelVolce  implements IModelVolce{

    @Override
    public void getUpload(String token, String fileName, String voiceFile, IUnifiedDataListener<EntityUpload> iUnifiedDataListener) {
        HttpmanVoice.gethttpmanVoice().getUpload(token,fileName,voiceFile)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityUpload>() {
                    @Override
                    public void accept(EntityUpload entityUpload) throws Exception {
                        Rlog.Log("语音文件上传","成功","0");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityUpload>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityUpload entityUpload) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Rlog.Log("语音文件上传","失败","-1");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getAbnormalUpload(String token, String fileName, String voiceFile, IUnifiedDataListener<EntityAbnormalUpload> iUnifiedDataListener) {
            HttpmanVoice.gethttpmanVoice().getAbnormalUpload(token,fileName,voiceFile)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(Schedulers.io())
                    .doOnNext(new Consumer<EntityAbnormalUpload>() {
                        @Override
                        public void accept(EntityAbnormalUpload entityAbnormalUpload) throws Exception {
                            Rlog.Log("异常文件上传","成功","0");
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<EntityAbnormalUpload>() {
                        @Override
                        public void onSubscribe(Subscription s) {

                        }

                        @Override
                        public void onNext(EntityAbnormalUpload entityAbnormalUpload) {

                        }

                        @Override
                        public void onError(Throwable t) {
                            Rlog.Log("异常文件上传","失败","-1");
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
