package com.example.wangtao.project_jingdong.utils.constant;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class Config {
    //首页ad/getAd
    public final static String home_url="https://www.zhaoapi.cn/";

    public final static String home_luibo_url="ad/getAd";
    //获取pid
    public final static String home_pid_url="product/getProductDetail";

    public final  static String home_urlRecycle="product/getCatagory";
    //分类
    public final static String classify_LeftURl="product/getCatagory";
    public final static String classify_RightURl="product/getProductCatagory";

    //查询分类product/getProducts
    public final static String fei_pscid="product/getProducts";
    //首页搜索
    public final static String fei_sousuo="product/searchProducts";

    //购物车购物  要设置uid
    public final static String shoping_Url="product/getCarts";
    //更新数据库
    public final static String shoping_updata_Url="product/updateCarts";
    //删除
    public final static String shoping_delete_Url="product/deleteCart";
    //登录注册 ?mobile=1503540435&password=123456
    public final static String minelogine_Url="user/login";
    public final static String minereg_Url="user/reg";
    //添加购物车 https://www.zhaoapi.cn/product/addCart?uid=16443&pid=57
    public final static String addCar_url="product/addCart";
    //查询购物车 https://www.zhaoapi.cn/product/getCarts?uid=16443
    public final static String getCar_url="product/getCarts";
     //上传头像
     public final static String getfile_upload="file/upload";
     //刷新
     public final static String getUset_Info="user/getUserInfo";

     //新闻头条 http://v.juhe.cn/toutiao/index?type=top&key=106e461cd267b52955afda07e9315eb0
     public final static String getXinWei_Info="toutiao/index";
      //立即购买  https://www.zhaoapi.cn/product/updateOrder?uid=15314&status=1&orderId=10966
      public final static String getBut_Info="product/createOrder";

     // public final static String getBut_Info="product/createOrder";
     public final static String getOrders_Info="product/getOrders";
     //https://www.zhaoapi.cn/product/updateOrder?uid=15314&status=1&orderId=10966
     public final static String getUpdataOrders_Info="product/updateOrder";
     //https://www.zhaoapi.cn/user/updateAddr?uid=71&addrid=2

     //常用的收获地址https://www.zhaoapi.cn/user/getAddrs?uid=71
     public final static String getUser_addrs="user/getAddrs";

    //添加常用地址  https://www.zhaoapi.cn/user/addAddr?uid=16443&addr=%E5%8C%97%E4%BA%AC%E5%B8%82%E6%B5%B7%E6%B7%80%E5%8C%BA&mobile=15035404355&name=%E5%BC%A0%E4%B8%89
    public final static String getaddUser_addrs="user/addAddr";
    //获取地址  https://www.zhaoapi.cn/user/updateAddr?uid=71&addrid=2
    public final static String getUpdataUser_addrs="user/updateAddr";
    //获取默认地址 https://www.zhaoapi.cn/user/getDefaultAddr?uid=71
    public final static String getDefaultUser_addrs="user/getDefaultAddr";
    //设置默认地址 https://www.zhaoapi.cn/user/setAddr?uid=71&addrid=3&status=1
    public final static String getDefault_steing_addrs="user/setAddr";
}
