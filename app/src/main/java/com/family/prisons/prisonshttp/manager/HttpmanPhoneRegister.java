package com.family.prisons.prisonshttp.manager;
import com.family.prisons.prisonsdata.entityphoneregister.EntityRegister;
import com.family.prisons.prisonsdata.entityphoneregister.EntitySipAccount;
import com.family.prisons.prisonshttp.HttpRetrofit;
import com.family.prisons.prisonshttp.IHttpPhoneRegister;

import io.reactivex.Flowable;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public class HttpmanPhoneRegister {


    public static  HttpmanPhoneRegister mHttpmanPhoneRegister;
    public static IHttpPhoneRegister mIHttpPhoneRegister;
    public HttpmanPhoneRegister(){

    }

    /**
     * 描述：获取默认Retrofit（无Cookies）
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public static HttpmanPhoneRegister getHttpmanPhoneRegister() {
        if (mHttpmanPhoneRegister == null) {
            synchronized (IHttpPhoneRegister.class) {
                if (mHttpmanPhoneRegister == null) {
                    mHttpmanPhoneRegister = new HttpmanPhoneRegister();
                    mIHttpPhoneRegister = HttpRetrofit.getDefaultRetrofit().create(IHttpPhoneRegister.class);
                }
            }
        }
        return mHttpmanPhoneRegister;
    }

    /**
     * 描述：话机注册
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */

    public Flowable<EntityRegister> getRegister(String token, String phoneNo, String ip, String mac, String dwdm, String dwdmName, String prisonCode, String prisonName, String prisonAreaCode, String prisonAreaName) {
        return mIHttpPhoneRegister.getRegister(token,phoneNo,ip,mac,dwdm,dwdmName,prisonCode,prisonName,prisonAreaCode,prisonAreaName);
    }
    /**
     * 描述：获取SIP账号
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntitySipAccount> getSipAccount(String token, String phoneNo, String dwdm) {
        return mIHttpPhoneRegister.getSipAccount(token,phoneNo,dwdm);
    }
}
