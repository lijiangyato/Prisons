package com.family.prisons.prisonshttp.manager;

import com.family.prisons.prisonsdata.entitypplyform.EntityAgree;
import com.family.prisons.prisonsdata.entitypplyform.EntityApproval;
import com.family.prisons.prisonsdata.entitypplyform.EntityBill;
import com.family.prisons.prisonsdata.entitypplyform.EntityForm;
import com.family.prisons.prisonsdata.entitypplyform.EntityTelephone;
import com.family.prisons.prisonsdata.entitypplyform.EntityWhiteList;
import com.family.prisons.prisonshttp.HttpRetrofit;
import com.family.prisons.prisonshttp.IHttpApplyForm;

import io.reactivex.Flowable;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public class HttpmanApplyForm {
    public static  HttpmanApplyForm mhttpmanApplyForm;
    public static IHttpApplyForm mIHttpApplyForm;
    public HttpmanApplyForm(){

    }

    /**
     * 描述：获取默认Retrofit（无Cookies）
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public static HttpmanApplyForm getMhttpmanApplyForm() {
        if (mhttpmanApplyForm == null) {
            synchronized (IHttpApplyForm.class) {
                if (mhttpmanApplyForm == null) {
                    mhttpmanApplyForm = new HttpmanApplyForm();
                    mIHttpApplyForm = HttpRetrofit.getDefaultRetrofit().create(IHttpApplyForm.class);
                }
            }
        }
        return mhttpmanApplyForm;
    }


    /**
     * 描述：申请单查询
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityForm> getForm(String dwdm, String prisonerNo,String offset,String limit,String isDail,String status) {
        return mIHttpApplyForm.getForm(dwdm,prisonerNo,offset,limit,isDail,status);
    }

    /**
     * 描述：获取账单列表
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityBill> getBill(String dwdm, String prisonerNo, String offset, String limit) {
        return mIHttpApplyForm.getBill(dwdm,prisonerNo,offset,limit);
    }
    /**
     * 描述：电话审批列表
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */

    public Flowable<EntityTelephone> getTelephone(String token,String dwdm,String offset,String limit) {
        return mIHttpApplyForm.getTelephone(token,dwdm,offset,limit);
    }


    /**
     * 描述：白名单
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityWhiteList> getWhiteList(String token,String dwdm,String prisonerNo,String offset,String limit) {
        return mIHttpApplyForm.getWhiteList(token,dwdm,prisonerNo,offset,limit);
    }

    /**
     * 描述：电话审批拒绝和同意
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityApproval> getApproval(String token, String billNo, String status, String updateUserId, String updateUser, String isWhitelists, String illustrationText, String voiceIllustration) {
        return mIHttpApplyForm.getApproval(token,billNo,status,updateUserId,updateUser,isWhitelists,illustrationText,voiceIllustration);
    }

    /**
     * 描述：电话审批拒绝和同意
     * 邮箱：1755036940@qq.com
     * 创建时间：2018/6/11
     * 姓名：李江
     */
    public Flowable<EntityAgree> getAgree(String billNo, String status, String updateUserId, String updateUser, String isWhitelists) {
        return mIHttpApplyForm.getAgree(billNo,status,updateUserId,updateUser,isWhitelists);
    }
}
