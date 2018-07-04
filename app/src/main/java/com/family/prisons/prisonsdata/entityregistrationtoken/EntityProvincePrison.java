package com.family.prisons.prisonsdata.entityregistrationtoken;

import java.util.List;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public class EntityProvincePrison {


    /**
     * code : 200
     * data : [{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5201","dwdmName":"羊艾监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5202","dwdmName":"王武监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5203","dwdmName":"金华监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5205","dwdmName":"第一女子监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5206","dwdmName":"沙子哨监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5207","dwdmName":"第二女子监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5211","dwdmName":"遵义监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5212","dwdmName":"忠庄监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5213","dwdmName":"田沟监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5214","dwdmName":"松林监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5215","dwdmName":"茅草铺监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5221","dwdmName":"宁谷监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5222","dwdmName":"轿子山监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5223","dwdmName":"平坝监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5224","dwdmName":"太平监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5225","dwdmName":"安顺监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5231","dwdmName":"桐州监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5232","dwdmName":"都匀监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5233","dwdmName":"瓮安监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5234","dwdmName":"福泉监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5235","dwdmName":"广顺监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5236","dwdmName":"北斗山监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5241","dwdmName":"凯里监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5242","dwdmName":"鱼洞监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5243","dwdmName":"东坡监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5251","dwdmName":"铜仁监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5252","dwdmName":"大硐喇监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5253","dwdmName":"毕节监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5254","dwdmName":"大方监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5261","dwdmName":"兴义监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5262","dwdmName":"普安监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5263","dwdmName":"晴隆监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5264","dwdmName":"海子监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5280","dwdmName":"少管所","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5291","dwdmName":"贵阳新收分流中心","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5292","dwdmName":"遵义新收分流中心","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5293","dwdmName":"凯里新收分流中心","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5218","dwdmName":"元江监狱","status":1},{"createDate":"2009-04-29 00:00:00","createUser":"admin","dwdm":"5204","dwdmName":"金西监狱","status":1}]
     * msg : 查询成功
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createDate : 2009-04-29 00:00:00
         * createUser : admin
         * dwdm : 5201
         * dwdmName : 羊艾监狱
         * status : 1
         */

        private String createDate;
        private String createUser;
        private String dwdm;
        private String dwdmName;
        private int status;

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
