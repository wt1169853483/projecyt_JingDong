package com.example.wangtao.project_jingdong.mvp.homepage.model.bean;

/**
 * Created by wangtao on 2018/7/14.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class HomePidBean {
    /**
     * msg :
     * seller : {"description":"我是商家20","icon":"http://120.27.23.105/images/icon.png","name":"商家20","productNums":999,"score":5,"sellerid":20}
     * code : 0
     * data : {"bargainPrice":111.99,"createtime":"2017-10-14T21:48:08","detailUrl":"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg","itemtype":2,"pid":4,"price":999,"pscid":1,"salenum":356,"sellerid":20,"subhead":"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下","title":"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g"}
     */

    private String msg;
    private SellerBean seller;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
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

    public static class SellerBean {
        /**
         * description : 我是商家20
         * icon : http://120.27.23.105/images/icon.png
         * name : 商家20
         * productNums : 999
         * score : 5
         * sellerid : 20
         */

        private String description;
        private String icon;
        private String name;
        private int productNums;
        private int score;
        private int sellerid;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProductNums() {
            return productNums;
        }

        public void setProductNums(int productNums) {
            this.productNums = productNums;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }
    }

    public static class DataBean {
        /**
         * bargainPrice : 111.99
         * createtime : 2017-10-14T21:48:08
         * detailUrl : https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends
         * images : https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg
         * itemtype : 2
         * pid : 4
         * price : 999
         * pscid : 1
         * salenum : 356
         * sellerid : 20
         * subhead : 每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下
         * title : 北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g
         */

        private double bargainPrice;
        private String createtime;
        private String detailUrl;
        private String images;
        private int itemtype;
        private int pid;
        private double price;
        private int pscid;
        private int salenum;
        private int sellerid;
        private String subhead;
        private String title;

        public double getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(double bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getItemtype() {
            return itemtype;
        }

        public void setItemtype(int itemtype) {
            this.itemtype = itemtype;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getPscid() {
            return pscid;
        }

        public void setPscid(int pscid) {
            this.pscid = pscid;
        }

        public int getSalenum() {
            return salenum;
        }

        public void setSalenum(int salenum) {
            this.salenum = salenum;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }

        public String getSubhead() {
            return subhead;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    /* *//**
     * msg :
     * seller : {"description":"我是商家1","icon":"http://120.27.23.105/images/icon.png","name":"商家1","productNums":999,"score":4.9,"sellerid":1}
     * code : 0
     * data : {"bargainPrice":11800,"createtime":"2017-10-10T17:33:37","detailUrl":"https://item.m.jd.com/product/4338107.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg!q70.jpg","itemtype":0,"pid":57,"price":5199,"pscid":40,"salenum":4343,"sellerid":1,"subhead":"【i5 MX150 2G显存】全高清窄边框 8G内存 256固态硬盘 支持指纹识别 预装WIN10系统","title":"小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银 "}
     *//*

    private String msg;
    private SellerBean seller;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
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

    public static class SellerBean {
        *//**
         * description : 我是商家1
         * icon : http://120.27.23.105/images/icon.png
         * name : 商家1
         * productNums : 999
         * score : 4.9
         * sellerid : 1
         *//*

        private String description;
        private String icon;
        private String name;
        private int productNums;
        private double score;
        private int sellerid;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProductNums() {
            return productNums;
        }

        public void setProductNums(int productNums) {
            this.productNums = productNums;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }
    }

    public static class DataBean {
        *//**
         * bargainPrice : 11800
         * createtime : 2017-10-10T17:33:37
         * detailUrl : https://item.m.jd.com/product/4338107.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
         * images : https://m.360buyimg.com/n0/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg!q70.jpg
         * itemtype : 0
         * pid : 57
         * price : 5199
         * pscid : 40
         * salenum : 4343
         * sellerid : 1
         * subhead : 【i5 MX150 2G显存】全高清窄边框 8G内存 256固态硬盘 支持指纹识别 预装WIN10系统
         * title : 小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银
         *//*

        private int bargainPrice;
        private String createtime;
        private String detailUrl;
        private String images;
        private int itemtype;
        private int pid;
        private double price;
        private int pscid;
        private int salenum;
        private int sellerid;
        private String subhead;
        private String title;

        public int getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(int bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getItemtype() {
            return itemtype;
        }

        public void setItemtype(int itemtype) {
            this.itemtype = itemtype;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getPscid() {
            return pscid;
        }

        public void setPscid(int pscid) {
            this.pscid = pscid;
        }

        public int getSalenum() {
            return salenum;
        }

        public void setSalenum(int salenum) {
            this.salenum = salenum;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }

        public String getSubhead() {
            return subhead;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "bargainPrice=" + bargainPrice +
                    ", createtime='" + createtime + '\'' +
                    ", detailUrl='" + detailUrl + '\'' +
                    ", images='" + images + '\'' +
                    ", itemtype=" + itemtype +
                    ", pid=" + pid +
                    ", price=" + price +
                    ", pscid=" + pscid +
                    ", salenum=" + salenum +
                    ", sellerid=" + sellerid +
                    ", subhead='" + subhead + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }*/

}
