package com.family.prisons.prisonshttp;
/**
 * 描述：监狱注册
 * 邮箱：1755036940@qq.com
 * 创建时间：2018/6/11
 * 姓名：李江
 */

import com.family.prisons.prisonsdata.entityphoneregister.EntityRegister;
import com.family.prisons.prisonsdata.entityphoneregister.EntitySipAccount;
import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public interface IHttpPhoneRegister {

    /**
     * 话机注册
     *
     * @return
     */
    @POST("lecent/prison/telePhone/Api/register")
    Flowable<EntityRegister> getRegister(
            @Query("token") String token,
            @Query("phoneNo") String phoneNo,
            @Query("ip") String ip,
            @Query("mac") String mac,
            @Query("dwdm") String dwdm,
            @Query("dwdmName") String dwdmName,
            @Query("prisonCode") String prisonCode,
            @Query("prisonName") String prisonName,
            @Query("prisonAreaCode") String prisonAreaCode,
            @Query("prisonAreaName") String prisonAreaName

    );

    /**
     * 获取SIP账号
     * @param token
     * @param phoneNo
     * @param dwdm
     * @return
     */
    @POST("lecent/prison/telePhone/Api/SipConfiguration")
    Flowable<EntitySipAccount> getSipAccount(
            @Query("token") String token,
            @Query("phoneNo") String phoneNo,
            @Query("dwdm") String dwdm
    );
}
