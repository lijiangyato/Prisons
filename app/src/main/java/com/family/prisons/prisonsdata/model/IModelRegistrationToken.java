package com.family.prisons.prisonsdata.model;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonArea;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonTest;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvince;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvincePrison;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public interface IModelRegistrationToken extends IProvider {
    /**
     * 描述：获取监狱的省份
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getProvince(String token,IUnifiedDataListener<EntityProvince> iUnifiedDataListener);

    /**
     * 描述：获取省份监狱
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getProvincePrison(String token, String prisonCode,IUnifiedDataListener<EntityProvincePrison> iUnifiedDataListener);

    /**
     * 描述：获取省份监狱监区
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getPrisonArea(String token, String dwdm,IUnifiedDataListener<EntityPrisonArea> iUnifiedDataListener);

    /**
     * 描述：测试服务器链接
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getTest(String token,IUnifiedDataListener<EntityPrisonTest> iUnifiedDataListener);
}
