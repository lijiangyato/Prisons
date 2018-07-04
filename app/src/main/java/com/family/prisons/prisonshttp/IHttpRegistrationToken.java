package com.family.prisons.prisonshttp;

import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonArea;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonTest;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvince;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvincePrison;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 描述：监狱登陆令牌
 * 邮箱：1755036940@qq.com
 * 创建时间：2018/6/11
 * 姓名：李江
 */
public interface IHttpRegistrationToken {
    /**
     * 获取监狱的省份
     * @param token   令牌
     * @return
     */
    @POST("lecent/prison/telePhone/Api/listPrisonManagement")
    Flowable<EntityProvince> getProvince(
            @Query("token") String token
    );

    /**
     * 获取省份监狱
     * @param token   令牌
     * @param prisonCode    监狱码
     * @return
     */
     @POST("lecent/prison/telePhone/Api/listPrison")
    Flowable<EntityProvincePrison> getProvincePrison(
             @Query("token") String token,
             @Query("prisonCode") String prisonCode
     );

    /**
     * 获取省份监狱监区
     * @param token   令牌
     * @param dwdm    监狱码
     * @return
     */
    @POST("lecent/prison/telePhone/Api/listPrisonInfo")
    Flowable<EntityPrisonArea> getPrisonArea(
            @Query("token") String token,
            @Query("dwdm") String dwdm
    );
    /**
     * 测试服务器链接
     * @param token   令牌
     * @return
     */
    @POST("lecent/prison/telePhone/Api/testLink")
    Flowable<EntityPrisonTest> getTest(
            @Query("token") String token
    );
}
