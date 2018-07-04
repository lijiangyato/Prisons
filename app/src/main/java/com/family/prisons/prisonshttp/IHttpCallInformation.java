package com.family.prisons.prisonshttp;

import com.family.prisons.prisonsdata.entitycalllnformation.EntityCalllnformation;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityPrisonGuardSignin;
import com.family.prisons.prisonsdata.entitycalllnformation.EntitySignIn;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityUrgent;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public interface IHttpCallInformation {

    /**
     * 获取犯人通话信息
     *
     * @param token
     * @param dwdm
     * @param prisonerNo
     * @return
     */
    @POST("lecent/prison/telePhone/Api/queryOffenderInfo")
    Flowable<EntityCalllnformation> getCalllnformation(
            @Query("token") String token,
            @Query("dwdm") String dwdm,
            @Query("prisonerNo") String prisonerNo
    );

    /**
     * 登陆
     *
     * @param token
     * @param dwdm
     * @param loginRole
     * @param loginData
     * @return
     */
    @POST("lecent/prison/telePhone/Api/terminal/login")
    Flowable<EntitySignIn> getSignIn(
            @Query("token") String token,
            @Query("dwdm") String dwdm,
            @Query("prisonAreaCode") String prisonAreaCode,
            @Query("loginRole") String loginRole,
            @Query("loginData") String loginData
    );


    /**
     * 登陆 狱警
     *
     * @param token
     * @param dwdm
     * @param loginRole
     * @param loginData
     * @return
     */

    @POST("lecent/prison/telePhone/Api/terminal/login")
    Flowable<EntityPrisonGuardSignin> getPrisonGuardSignin(
            @Query("token") String token,
            @Query("dwdm") String dwdm,
            @Query("prisonAreaCode") String prisonAreaCode,
            @Query("loginRole") String loginRole,
            @Query("loginData") String loginData
    );


    /**
     * 紧急拨打
     *
     * @param token
     * @param dwdm
     * @param prisonerNo
     * @param callNumber
     * @param updateUser
     * @param updateUserId
     * @param relationName
     * @param relationId
     * @param callName
     * @return
     */

    @POST("lecent/prison/telePhone/Api/emergencyCall")
    Flowable<EntityUrgent> getUrgent(
            @Query("token") String token,
            @Query("dwdm") String dwdm,
            @Query("prisonerNo") String prisonerNo,
            @Query("callNumber") String callNumber,
            @Query("updateUser") String updateUser,
            @Query("updateUserId") String updateUserId,
            @Query("relationName") String relationName,
            @Query("relationId") String relationId,
            @Query("callName") String callName
    );
}
