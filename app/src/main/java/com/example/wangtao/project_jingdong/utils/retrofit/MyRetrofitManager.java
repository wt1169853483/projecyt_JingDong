package com.example.wangtao.project_jingdong.utils.retrofit;

import com.example.wangtao.project_jingdong.utils.constant.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MyRetrofitManager {
    private static String Url_bean= Config.home_url;
    private Retrofit retrofit;

    private static class SingRetrofit{
        public static MyRetrofitManager myRetrofitManger=new MyRetrofitManager(Url_bean);
    }

    private MyRetrofitManager(String utl_bean) {
        retrofit =new Retrofit.Builder()
                .baseUrl(utl_bean)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(Okhttps())
                .build();
    }

    public static MyRetrofitManager getDefault(){
        return SingRetrofit.myRetrofitManger;
    }

    private OkHttpClient Okhttps() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                //.readTimeout(5000, TimeUnit.MILLISECONDS)
                //.writeTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
    public <T> T create (Class<T> tClass){
        return retrofit.create(tClass);
    }
}
