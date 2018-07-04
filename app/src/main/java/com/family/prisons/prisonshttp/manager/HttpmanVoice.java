package com.family.prisons.prisonshttp.manager;
import com.family.prisons.prisonsdata.entityvoice.EntityAbnormalUpload;
import com.family.prisons.prisonsdata.entityvoice.EntityUpload;
import com.family.prisons.prisonshttp.HttpRetrofit;
import com.family.prisons.prisonshttp.IHttpUpgrade;
import com.family.prisons.prisonshttp.IHttpVoice;

import io.reactivex.Flowable;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public class HttpmanVoice {

    public static HttpmanVoice mHttpmanVoice;
    public static IHttpVoice mIHttpVoice;

    public HttpmanVoice() {

    }

    /**
     * 描述：获取默认Retrofit（无Cookies）
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public static HttpmanVoice gethttpmanVoice() {
        if (mHttpmanVoice == null) {
            synchronized (IHttpUpgrade.class) {
                if (mHttpmanVoice == null) {
                    mHttpmanVoice = new HttpmanVoice();
                    mIHttpVoice = HttpRetrofit.getDefaultRetrofit().create(IHttpVoice.class);
                }
            }
        }
        return mHttpmanVoice;
    }

    /**
     * 描述：语音文件上传
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityUpload> getUpload(String token, String fileName, String voiceFile) {
        return mIHttpVoice.getUpload(token, fileName, voiceFile);
    }

    /**
     * 描述：异常文件上传
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityAbnormalUpload> getAbnormalUpload(String token, String fileName, String voiceFile) {
        return mIHttpVoice.getAbnormalUpload(token, fileName, voiceFile);
    }


}
