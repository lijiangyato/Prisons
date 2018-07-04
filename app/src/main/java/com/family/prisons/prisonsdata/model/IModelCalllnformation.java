package com.family.prisons.prisonsdata.model;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityCalllnformation;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityPrisonGuardSignin;
import com.family.prisons.prisonsdata.entitycalllnformation.EntitySignIn;
import com.family.prisons.prisonsdata.entitycalllnformation.EntityUrgent;
import com.family.prisons.prisonsdata.IUnifiedDataListener;


/**
 * Created by ThinkPad on 2018/6/12.
 */

public interface IModelCalllnformation extends IProvider {

    /**
     * 描述：获取犯人通话信息
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getCalllnformation(String token,String dwdm,String prisonerNo,IUnifiedDataListener<EntityCalllnformation> iUnifiedDataListener);
    /**
     * 描述：登陆
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getSignIn(String token,String dwdm,String prisonAreaCode, String loginRole,String loginData,IUnifiedDataListener<EntitySignIn> iUnifiedDataListener);
    /**
     * 描述：登陆 狱警
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getPrisonGuardSignin(String token,String dwdm,String prisonAreaCode,String loginRole,String loginData,IUnifiedDataListener<EntityPrisonGuardSignin> iUnifiedDataListener);
    /**
     * 描述：紧急拨打
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getUrgent(String token,String dwdm,String prisonerNo,String callNumber,String updateUser,String updateUserId,String relationName,String relationId,String callName,IUnifiedDataListener<EntityUrgent> iUnifiedDataListener);
}
