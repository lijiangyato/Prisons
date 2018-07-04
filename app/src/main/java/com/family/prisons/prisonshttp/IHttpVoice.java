package com.family.prisons.prisonshttp;

import com.family.prisons.prisonsdata.entityvoice.EntityAbnormalUpload;
import com.family.prisons.prisonsdata.entityvoice.EntityUpload;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public interface IHttpVoice {
    /**
     * 语音文件上传
     * @param token
     * @param fileName
     * @param voiceFile
     * @return
     */
    @POST("lecent/prison/telePhone/Api/voiceUpload")
    Flowable<EntityUpload> getUpload(
            @Query("token") String token,
            @Query("fileName") String fileName,
            @Query("voiceFile") String voiceFile
    );

    /**
     * 异常文件上传
     * @param token
     * @param fileName
     * @param voiceFile
     * @return
     */

    @POST("lecent/prison/telePhone/Api/telePhoneLogUpload")
    Flowable<EntityAbnormalUpload> getAbnormalUpload(
            @Query("token") String token,
            @Query("fileName") String fileName,
            @Query("voiceFile") String voiceFile
    );
}
