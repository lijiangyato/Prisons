package com.family.prisons.prisonsdata.entityregistrationtoken;

/**
 * Created by ThinkPad on 2018/6/11.
 */


import java.util.List;

/**
 * 描述：监狱省份实体参数
 * 邮箱：1755036940@qq.com
 * 创建时间：2018/6/11
 * 姓名：李江
 */
public class EntityProvince {



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
         * prisonCode : 5200
         * prisonName : 贵州省监狱管理局
         * status : 1
         */

        private String createDate;
        private String createUser;
        private String prisonCode;
        private String prisonName;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
