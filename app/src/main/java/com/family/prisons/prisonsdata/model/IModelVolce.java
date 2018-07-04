package com.family.prisons.prisonsdata.model;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityvoice.EntityAbnormalUpload;
import com.family.prisons.prisonsdata.entityvoice.EntityUpload;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public interface IModelVolce extends IProvider {
    /**
     * 描述：语音文件上传
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getUpload(String token, String fileName, String voiceFile,IUnifiedDataListener<EntityUpload> iUnifiedDataListener);

    /**
     * 描述：异常文件上传
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getAbnormalUpload(String token, String fileName, String voiceFile,IUnifiedDataListener<EntityAbnormalUpload> iUnifiedDataListener);
}
