package com.family.prisons.prisonsdata.model;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entityphoneregister.EntityRegister;
import com.family.prisons.prisonsdata.entityphoneregister.EntitySipAccount;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public interface IModelPhoneRegister  extends IProvider {
    /**
     * 描述：话机注册
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
   void getRegister(String token, String phoneNo, String ip, String mac, String dwdm, String dwdmName, String prisonCode, String prisonName, String prisonAreaCode, String prisonAreaName,IUnifiedDataListener<EntityRegister> iUnifiedDataListener);
    /**
     * 描述：获取SIP账号
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
   void getSipAccount(String token, String phoneNo, String dwdm,IUnifiedDataListener<EntitySipAccount> iUnifiedDataListener);
}
