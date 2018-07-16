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
    //登录注册 ?mobile=1503540435&password=123456
    public final static String minelogine_Url="user/login";
    public final static String minereg_Url="user/reg";
    //添加购物车 https://www.zhaoapi.cn/product/addCart?uid=16443&pid=57
    public final static String addCar_url="product/addCart";
    //查询购物车 https://www.zhaoapi.cn/product/getCarts?uid=16443
    public final static String getCar_url="product/getCarts";


}
