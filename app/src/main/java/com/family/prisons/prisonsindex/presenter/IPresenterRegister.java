package com.family.prisons.prisonsindex.presenter;

/**
 * Created by ThinkPad on 2018/6/13.
 */

public interface IPresenterRegister {
    void displaypresenter();

    /**
     * 描述：监狱省份令牌
     */
    void getProvince(String token);
    /**
     * 描述：监狱省份
     */
    void getProvincePrison(String token, String prisonCode);

    /**
     * 描述：监区
     */
    void getPrisonArea(String token, String dwdm);

    /**
     * 描述：注册
     */
   void getRegister(String token, String phoneNo, String ip, String mac, String dwdm, String dwdmName, String prisonCode, String prisonName, String prisonAreaCode, String prisonAreaName);
    }