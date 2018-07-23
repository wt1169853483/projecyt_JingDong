package com.example.wangtao.project_jingdong.mvp.indent.model.bean;

/**
 * Created by wangtao on 2018/7/20.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class IndentAddrBean {

    /**
     * msg : 请求成功
     * code : 0
     * data : {"addr":"北京市海淀区","addrid":9984,"mobile":15035404355,"name":"张三","status":1,"uid":16443}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * addr : 北京市海淀区
         * addrid : 9984
         * mobile : 15035404355
         * name : 张三
         * status : 1
         * uid : 16443
         */

        private String addr;
        private int addrid;
        private long mobile;
        private String name;
        private int status;
        private int uid;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public int getAddrid() {
            return addrid;
        }

        public void setAddrid(int addrid) {
            this.addrid = addrid;
        }

        public long getMobile() {
            return mobile;
        }

        public void setMobile(long mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
