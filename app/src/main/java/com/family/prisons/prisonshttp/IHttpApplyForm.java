package com.family.prisons.prisonshttp;

import com.family.prisons.prisonsdata.entitypplyform.EntityAgree;
import com.family.prisons.prisonsdata.entitypplyform.EntityApproval;
import com.family.prisons.prisonsdata.entitypplyform.EntityBill;
import com.family.prisons.prisonsdata.entitypplyform.EntityForm;
import com.family.prisons.prisonsdata.entitypplyform.EntityTelephone;
import com.family.prisons.prisonsdata.entitypplyform.EntityWhiteList;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public interface IHttpApplyForm {
    /**
     * 申请单查询
     *
     * @param dwdm
     * @param prisonerNo
     * @param offset
     * @param limit
     * @return
     */

    @POST("lecent/prison/telePhone/Api/listPsionerApproval")
    Flowable<EntityForm> getForm(
            @Query("dwdm") String dwdm,
            @Query("prisonerNo") String prisonerNo,
            @Query("offset") String offset,
            @Query("limit") String limit,
            @Query("isDail") String isDail,
            @Query("status") String status
    );

    /**
     * 获取账单列表
     *
     * @param dwdm
     * @param prisonerNo
     * @param offset
     * @param limit
     * @return
     */
    @POST("lecent/prison/telePhone/Api/listTelePhoneApiBill")
    Flowable<EntityBill> getBill(
            @Query("dwdm") String dwdm,
            @Query("prisonerNo") String prisonerNo,
            @Query("offset") String offset,
            @Query("limit") String limit
    );

    /**
     * 电话审批列表
     *
     * @param token
     * @param dwdm
     * @param offset
     * @param limit
     * @return
     */
    @POST("lecent/prison/telePhone/Api/psionerApproval")
    Flowable<EntityTelephone> getTelephone(
            @Query("token") String token,
            @Query("dwdm") String dwdm,
            @Query("offset") String offset,
            @Query("limit") String limit
    );


    /**
     * 白名单
     *
     * @param token
     * @param dwdm
     * @param prisonerNo
     * @param offset
     * @param limit
     * @return
     */

    @POST("lecent/prison/telePhone/Api/listTelePhoneWhilte")
    Flowable<EntityWhiteList> getWhiteList(
            @Query("token") String token,
            @Query("dwdm") String dwdm,
            @Query("prisonerNo") String prisonerNo,
            @Query("offset") String offset,
            @Query("limit") String limit
    );

    /**
     * 电话审批拒绝和同意
     *
     * @param token
     * @param billNo
     * @param status
     * @param updateUserId
     * @param updateUser
     * @param isWhitelists
     * @param illustrationText
     * @param voiceIllustration
     * @return
     */
    @POST("lecent/prison/telePhone/Api/updatePsionerApproval")
    Flowable<EntityApproval> getApproval(
            @Query("token") String token,
            @Query("billNo") String billNo,
            @Query("status") String status,
            @Query("updateUserId") String updateUserId,
            @Query("updateUser") String updateUser,
            @Query("isWhitelists") String isWhitelists,
            @Query("illustrationText") String illustrationText,
            @Query("voiceIllustration") String voiceIllustration

    );

    /**
     * 电话审批拒绝和同意
     *
     * @param billNo
     * @param status
     * @param updateUserId
     * @param updateUser
     * @param isWhitelists
     * @return
     */


    @POST("lecent/prison/telePhone/Api/updatePsionerApproval")
    Flowable<EntityAgree> getAgree(
            @Query("billNo") String billNo,
            @Query("status") String status,
            @Query("updateUserId") String updateUserId,
            @Query("updateUser") String updateUser,
            @Query("isWhitelists") String isWhitelists

    );

}
