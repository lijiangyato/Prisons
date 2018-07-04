package com.family.prisons.prisonshttp.manager;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonArea;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonTest;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvince;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvincePrison;
import com.family.prisons.prisonshttp.HttpRetrofit;
import com.family.prisons.prisonshttp.IHttpRegistrationToken;

import io.reactivex.Flowable;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public class HttpmanRegistrationToken {

    public static  HttpmanRegistrationToken mHttpmanRegistrationToken;
    public static IHttpRegistrationToken mHttpRegistrationToken;
    public HttpmanRegistrationToken(){

    }

    /**
     * 描述：获取默认Retrofit（无Cookies）
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public static HttpmanRegistrationToken getHttpmanRegistrationToken() {
        if (mHttpmanRegistrationToken == null) {
            synchronized (IHttpRegistrationToken.class) {
                if (mHttpmanRegistrationToken == null) {
                    mHttpmanRegistrationToken = new HttpmanRegistrationToken();
                    mHttpRegistrationToken = HttpRetrofit.getDefaultRetrofit().create(IHttpRegistrationToken.class);
                }
            }
        }
        return mHttpmanRegistrationToken;
    }

    /**
     * 描述：获取监狱的省份
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */

    public Flowable<EntityProvince> getProvince(String token) {
        return mHttpRegistrationToken.getProvince(token);
    }
    /**
     * 描述：获取省份监狱
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityProvincePrison> getProvincePrison(String token, String prisonCode) {
        return mHttpRegistrationToken.getProvincePrison(token,prisonCode);
    }
    /**
     * 描述：获取省份监狱监区
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityPrisonArea> getPrisonArea(String token, String dwdm) {
        return mHttpRegistrationToken.getPrisonArea(token,dwdm);
    }
    /**
     * 描述：测试服务器链接
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityPrisonTest> getTest(String token) {
        return mHttpRegistrationToken.getTest(token);
    }
}
