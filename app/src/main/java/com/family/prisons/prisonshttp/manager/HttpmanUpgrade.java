package com.family.prisons.prisonshttp.manager;
import com.family.prisons.prisonsdata.entityupload.EntityJournal;
import com.family.prisons.prisonsdata.entityupload.EntityToUpdate;
import com.family.prisons.prisonshttp.HttpRetrofit;
import com.family.prisons.prisonshttp.IHttpUpgrade;

import io.reactivex.Flowable;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public class HttpmanUpgrade {

    public static  HttpmanUpgrade mHttpmanUpgrade;
    public static IHttpUpgrade mhttpUpgrade;
    public HttpmanUpgrade(){

    }

    /**
     * 描述：获取默认Retrofit（无Cookies）
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public static HttpmanUpgrade getmHttpmanUpgrade() {
        if (mHttpmanUpgrade == null) {
            synchronized (IHttpUpgrade.class) {
                if (mHttpmanUpgrade == null) {
                    mHttpmanUpgrade = new HttpmanUpgrade();
                    mhttpUpgrade = HttpRetrofit.getDefaultRetrofit().create(IHttpUpgrade.class);
                }
            }
        }
        return mHttpmanUpgrade;
    }
    /**
     * 描述：应用升级
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityToUpdate> getUpload(String token) {
        return mhttpUpgrade.getUpload(token);
    }

    /**
     * 描述：异常日志上传
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityJournal> getJournal(String logType,String terminalId,String prisonAreaCode,String prisonAreaName,String requestUrl,String queryParam, String method, String exceptionCause,String exceptionDetail) {
        return mhttpUpgrade.getJournal(logType,terminalId,prisonAreaCode,prisonAreaName,requestUrl,queryParam,method,exceptionCause,exceptionDetail);
    }
}
