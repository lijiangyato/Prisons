package com.family.prisons.prisonsdata.model;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityupload.EntityJournal;
import com.family.prisons.prisonsdata.entityupload.EntityToUpdate;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public interface IModelUpgrade extends IProvider {
    /**
     * 描述：应用升级
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getUpload(String token,IUnifiedDataListener<EntityToUpdate> iUnifiedDataListener);

    /**
     * 描述：异常日志上传
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
   void getJournal(String logType,String terminalId,String prisonAreaCode,String prisonAreaName,String requestUrl,String queryParam, String method, String exceptionCause,String exceptionDetail,IUnifiedDataListener<EntityJournal> iUnifiedDataListener);
}
