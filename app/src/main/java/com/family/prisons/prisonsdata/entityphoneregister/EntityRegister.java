package com.family.prisons.prisonsdata.entityphoneregister;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public class EntityRegister {

    /**
     * code : 200
     * data : {"dwdm":"5155","dwdmName":"达州监狱","iNSTALL_ADDRESS":"一监区","ip":"192.168.1.9","mac":"00:C8:DA:DE:CB:32","pHONE_NAME":"二号机","phoneNo":"8","prisonAreaCode":"2961","prisonAreaName":"一监区","prisonCode":"5100","prisonName":"四川省监狱管理局","sipAccount":"551550008","sipPassword":"lecent551550008"}
     * msg : 注册成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * dwdm : 5155
         * dwdmName : 达州监狱
         * iNSTALL_ADDRESS : 一监区
         * ip : 192.168.1.9
         * mac : 00:C8:DA:DE:CB:32
         * pHONE_NAME : 二号机
         * phoneNo : 8
         * prisonAreaCode : 2961
         * prisonAreaName : 一监区
         * prisonCode : 5100
         * prisonName : 四川省监狱管理局
         * sipAccount : 551550008
         * sipPassword : lecent551550008
         */

        private String dwdm;
        private String dwdmName;
        private String iNSTALL_ADDRESS;
        private String ip;
        private String mac;
        private String pHONE_NAME;
        private String phoneNo;
        private String prisonAreaCode;
        private String prisonAreaName;
        private String prisonCode;
        private String prisonName;
        private String sipAccount;
        private String sipPassword;

        public String getDwdm() {
            return dwdm;
        }

        public void setDwdm(String dwdm) {
            this.dwdm = dwdm;
        }

        public String getDwdmName() {
            return dwdmName;
        }

        public void setDwdmName(String dwdmName) {
            this.dwdmName = dwdmName;
        }

        public String getINSTALL_ADDRESS() {
            return iNSTALL_ADDRESS;
        }

        public void setINSTALL_ADDRESS(String iNSTALL_ADDRESS) {
            this.iNSTALL_ADDRESS = iNSTALL_ADDRESS;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getPHONE_NAME() {
            return pHONE_NAME;
        }

        public void setPHONE_NAME(String pHONE_NAME) {
            this.pHONE_NAME = pHONE_NAME;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getPrisonAreaCode() {
            return prisonAreaCode;
        }

        public void setPrisonAreaCode(String prisonAreaCode) {
            this.prisonAreaCode = prisonAreaCode;
        }

        public String getPrisonAreaName() {
            return prisonAreaName;
        }

        public void setPrisonAreaName(String prisonAreaName) {
            this.prisonAreaName = prisonAreaName;
        }

        public String getPrisonCode() {
            return prisonCode;
        }

        public void setPrisonCode(String prisonCode) {
            this.prisonCode = prisonCode;
        }

        public String getPrisonName() {
            return prisonName;
        }

        public void setPrisonName(String prisonName) {
            this.prisonName = prisonName;
        }

        public String getSipAccount() {
            return sipAccount;
        }

        public void setSipAccount(String sipAccount) {
            this.sipAccount = sipAccount;
        }

        public String getSipPassword() {
            return sipPassword;
        }

        public void setSipPassword(String sipPassword) {
            this.sipPassword = sipPassword;
        }
    }
}
