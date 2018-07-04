package com.family.prisons.prisonsdata.entityregistrationtoken;

import java.util.List;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public class EntityPrisonArea {
    public String name;
    /**
     * code : 200
     * data : [{"createDate":"2016-12-07 10:04:00","createUser":"超级管理员","dwdm":"5155","prisonAreaCode":"2962","prisonAreaName":"二监区","status":1},{"createDate":"2016-12-07 10:03:50","createUser":"超级管理员","dwdm":"5155","prisonAreaCode":"2961","prisonAreaName":"一监区","status":1},{"createDate":"2016-12-07 10:04:26","createUser":"超级管理员","dwdm":"5155","prisonAreaCode":"2964","prisonAreaName":"二监区一分监区","status":1},{"createDate":"2016-12-07 10:04:11","createUser":"超级管理员","dwdm":"5155","prisonAreaCode":"2963","prisonAreaName":"一监区一分监区","status":1},{"createDate":"2017-07-05 10:39:50","createUser":"超级管理员","dwdm":"5155","prisonAreaCode":"3544","prisonAreaName":"dddd","status":1}]
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
         * createDate : 2016-12-07 10:04:00
         * createUser : 超级管理员
         * dwdm : 5155
         * prisonAreaCode : 2962
         * prisonAreaName : 二监区
         * status : 1
         */

        private String createDate;
        private String createUser;
        private String dwdm;
        private String prisonAreaCode;
        private String prisonAreaName;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
