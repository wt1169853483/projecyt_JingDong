package com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean;

import java.util.List;

/**
 * Created by wangtao on 2018/7/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ShopingButBean {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2018-07-19T11:17:38","orderid":10966,"price":111.99,"status":1,"title":"订单测试标题15314","uid":15314},{"createtime":"2018-07-19T11:25:50","orderid":10967,"price":6777.99,"status":0,"title":"订单测试标题15314","uid":15314},{"createtime":"2018-07-19T11:33:11","orderid":10968,"price":6777.99,"status":0,"title":"订单测试标题15314","uid":15314},{"createtime":"2018-07-19T11:34:22","orderid":10969,"price":6777.99,"status":0,"title":"订单测试标题15314","uid":15314},{"createtime":"2018-07-19T11:35:16","orderid":10970,"price":99.99,"status":0,"title":"订单测试标题15314","uid":15314},{"createtime":"2018-07-19T11:50:58","orderid":10972,"price":6666,"status":0,"title":"订单测试标题15314","uid":15314},{"createtime":"2018-07-19T11:52:01","orderid":10973,"price":6666,"status":0,"title":"订单测试标题15314","uid":15314},{"createtime":"2018-07-19T12:09:21","orderid":10976,"price":6666,"status":0,"title":"订单测试标题15314","uid":15314},{"createtime":"2018-07-19T12:11:51","orderid":10977,"price":6666,"status":0,"title":"订单测试标题15314","uid":15314}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2018-07-19T11:17:38
         * orderid : 10966
         * price : 111.99
         * status : 1
         * title : 订单测试标题15314
         * uid : 15314
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private String title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
