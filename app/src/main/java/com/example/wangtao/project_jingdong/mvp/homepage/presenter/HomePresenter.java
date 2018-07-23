package com.example.wangtao.project_jingdong.mvp.homepage.presenter;

import android.util.Log;

import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.HomeModel;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeButBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeaddCarBean;
import com.example.wangtao.project_jingdong.mvp.homepage.view.iview.HomeIview;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class HomePresenter extends BasePresenter<HomeIview> {
    private static final String TAG = "HomePresenter";
    private HomeModel homeModel;

    public HomePresenter(HomeIview iview) {
        super(iview);
    }

    @Override
    protected void onModel() {
        homeModel = new HomeModel();
    }
    public void getHomePresenter(){
        homeModel.getHomeModel()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeUtilBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HomeUtilBean homeUtilBean) {

                            if (iview != null){
                                iview.getHomeSuccess(homeUtilBean);
                            }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                              iview.getHomeError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
           homeModel.getCataModel()
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new Observer<HomeCatagoryBean>() {
                       @Override
                       public void onSubscribe(Disposable d) {

                       }

                       @Override
                       public void onNext(HomeCatagoryBean homeCatagoryBean) {
                               if (iview != null){
                                    iview.getCatagorySuccess(homeCatagoryBean);
                               }
                       }

                       @Override
                       public void onError(Throwable e) {
                           if (iview != null){
                               iview.getCatagoryError(e.toString());
                           }
                       }

                       @Override
                       public void onComplete() {

                       }
                   });
    }
    public void getHomeCarPresenter(String uid,String pid){
            homeModel.getaddCar(uid,pid)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<HomeaddCarBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                              compositeDisposable.add(d);
                        }

                        @Override
                        public void onNext(HomeaddCarBean homeaddCarBean) {
                            if (iview != null){
                                iview.getDataSuccess(homeaddCarBean);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (iview != null){
                                iview.getDataError(e.toString());
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

    }
    public void getPresenterMiaosha(String pid) {
        homeModel.getHomemiaosha(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomePidBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HomePidBean homePidBean) {
                         if (iview != null){
                                iview.getPidDataSuccess(homePidBean);
                         }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getPidDataError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //结算
    public void getBuyPresenter(String uid,String price){
        homeModel.getBuyCar(uid,price)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeButBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HomeButBean homeButBean) {
                        if (iview != null){
                            iview.getButHomeSuccess(homeButBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getHomeError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
