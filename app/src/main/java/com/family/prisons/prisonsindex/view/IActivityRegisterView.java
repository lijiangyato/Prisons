package com.family.prisons.prisonsindex.view;

import com.family.prisons.prisonsdata.entityregistrationtoken.EntityPrisonArea;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvince;
import com.family.prisons.prisonsdata.entityregistrationtoken.EntityProvincePrison;
import com.family.prisons.prisonsindex.entity.EntityRegister;

/**
 * Created by ThinkPad on 2018/6/13.
 */

public interface IActivityRegisterView {

    void displayview();

    /**
     * 描述：监狱省份
     */
    void setProvince(EntityProvince entityProvince);

    /**
     * 描述：具体监狱身份
     */
    void setProvincePrison(EntityProvincePrison entityProvincePrison);

    /**
     * 描述：监区
     */

    void setPrisonArea(EntityPrisonArea response);

    /**
     * 描述：注册
     */
    void getRegister(com.family.prisons.prisonsdata.entityphoneregister.EntityRegister entityRegister);

    /**
     * 描述：加载
     */

    void setLoad();

    /**
     * 描述：关闭加载
     */
    void setCloseLoad(int cod,String dwdm,String prisonAreaCode);


}
