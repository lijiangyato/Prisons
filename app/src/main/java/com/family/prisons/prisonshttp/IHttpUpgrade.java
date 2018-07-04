package com.family.prisons.prisonshttp;
import com.family.prisons.prisonsdata.entityupload.EntityJournal;
import com.family.prisons.prisonsdata.entityupload.EntityToUpdate;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public interface IHttpUpgrade {
    /**
     * 应用升级
     * @param token
     * @return
     */

    @POST("lecent/prison/telePhone/Api/updateApk")
    Flowable<EntityToUpdate> getUpload(
            @Query("token") String token
    );


    /**
     * 异常日志上传
     * @param method   方法名
     * @param exceptionCause  异常原因
     * @param exceptionDetail  异常详情
     * @return
     */

    @POST("lecent/prison/telePhone/Api/systemLogUpload")
    Flowable<EntityJournal> getJournal(
            @Query("logType") String logType,
            @Query("terminalId") String terminalId,
            @Query("prisonAreaCode") String prisonAreaCode,
            @Query("prisonAreaName") String prisonAreaName,
            @Query("requestUrl") String requestUrl,
            @Query("queryParam") String queryParam,
            @Query("method") String method,
            @Query("exceptionCause") String exceptionCause,
            @Query("exceptionDetail") String exceptionDetail
    );




}
