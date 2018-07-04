package com.family.prisons.prisonshttp.manager;

import com.family.prisons.prisonsdata.entitycalllnformation.EntityCalllnformation;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityPrisonGuardSignin;
import com.family.prisons.prisonsdata.entitycalllnformation.EntitySignIn;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityUrgent;
import com.family.prisons.prisonshttp.HttpRetrofit;

import com.family.prisons.prisonshttp.IHttpCallInformation;

import io.reactivex.Flowable;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public class HttpmanCalllnformation {


    public static  HttpmanCalllnformation mHttpmanCalllnformation;
    public static IHttpCallInformation mIHttpCallInformation;
    public HttpmanCalllnformation(){

    }

    /**
     * 描述：获取默认Retrofit（无Cookies）
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public static HttpmanCalllnformation getHttpmanCalllnformation() {
        if (mHttpmanCalllnformation == null) {
            synchronized (IHttpCallInformation.class) {
                if (mHttpmanCalllnformation == null) {
                    mHttpmanCalllnformation = new HttpmanCalllnformation();
                    mIHttpCallInformation = HttpRetrofit.getDefaultRetrofit().create(IHttpCallInformation.class);
                }
            }
        }
        return mHttpmanCalllnformation;
    }

    /**
     * 描述：获取犯人通话信息
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityCalllnformation> getCalllnformation(String token,String dwdm,String prisonerNo) {
        return mIHttpCallInformation.getCalllnformation(token,dwdm,prisonerNo);
    }
    /**
     * 描述：登陆
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntitySignIn> getSignIn(String token,String dwdm,String prisonAreaCode, String loginRole,String loginData) {
        return mIHttpCallInformation.getSignIn(token,dwdm,prisonAreaCode,loginRole,loginData);
    }

    /**
     * 描述：登陆 狱警
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */

    public Flowable<EntityPrisonGuardSignin> getPrisonGuardSignin(String token,String dwdm,String prisonAreaCode,String loginRole,String loginData) {
        return mIHttpCallInformation.getPrisonGuardSignin(token,dwdm,prisonAreaCode,loginRole,loginData);
    }
    /**
     * 描述：紧急拨打
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityUrgent> getUrgent(String token,String dwdm,String prisonerNo,String callNumber,String updateUser,String updateUserId,String relationName,String relationId,String callName) {
        return mIHttpCallInformation.getUrgent(token,dwdm,prisonerNo,callNumber,updateUser,updateUserId,relationName,relationId,callName);
    }
}
