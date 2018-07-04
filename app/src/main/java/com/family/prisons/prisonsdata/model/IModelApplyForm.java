package com.family.prisons.prisonsdata.model;


import com.alibaba.android.arouter.facade.template.IProvider;
import com.family.prisons.prisonsdata.IUnifiedDataListener;
import com.family.prisons.prisonsdata.entitypplyform.EntityAgree;
import com.family.prisons.prisonsdata.entitypplyform.EntityApproval;
import com.family.prisons.prisonsdata.entitypplyform.EntityBill;
import com.family.prisons.prisonsdata.entitypplyform.EntityForm;
import com.family.prisons.prisonsdata.entitypplyform.EntityTelephone;
import com.family.prisons.prisonsdata.entitypplyform.EntityWhiteList;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public interface IModelApplyForm extends IProvider {
    /**
     * 描述：申请单查询
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getForm(String dwdm, String prisonerNo, String offset, String limit, String isDail, String status, IUnifiedDataListener<EntityForm> iUnifiedDataListener);
    /**
     * 描述：获取账单列表
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getBill(String dwdm, String prisonerNo, String offset, String limit,IUnifiedDataListener<EntityBill> iUnifiedDataListener);
    /**
     * 电话审批列表
     *
     * @param token
     * @param dwdm
     * @param offset
     * @param limit
     * @return
     */
    void getTelephone(String token,String dwdm,String offset,String limit,IUnifiedDataListener<EntityTelephone> iUnifiedDataListener);
    /**
     * 描述：白名单
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getWhiteList(String token,String dwdm,String prisonerNo,String offset,String limit,IUnifiedDataListener<EntityWhiteList> iUnifiedDataListener);
    /**
     * 描述：电话审批拒绝和同意
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getApproval(String token, String billNo, String status, String updateUserId, String updateUser, String isWhitelists, String illustrationText, String voiceIllustration,IUnifiedDataListener<EntityApproval> iUnifiedDataListener);

    /**
     * 描述：电话审批拒绝和同意
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    void getAgree(String billNo, String status, String updateUserId, String updateUser, String isWhitelists,IUnifiedDataListener<EntityAgree> iUnifiedDataListener);
}
