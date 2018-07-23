package com.example.wangtao.project_jingdong.mvp.shoppingcart.presenter;

import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.mvp.classify.model.ClassifyModel;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.classify.view.iview.IClassView;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.ShopingModel;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingButBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingDeleteBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.model.bean.ShopingUpdataBean;
import com.example.wangtao.project_jingdong.mvp.shoppingcart.view.iview.IShopingView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangtao on 2018/7/12.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ShopingPresenter extends BasePresenter<IShopingView> {


    private ShopingModel shopingModel;

    public ShopingPresenter(IShopingView iview) {
        super(iview);
    }

    @Override
    protected void onModel() {
        shopingModel = new ShopingModel();
    }
    public void getShopingPresenter(String uid){
          shopingModel.getShopingModel(uid)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<ShopingBean>() {
                      @Override
                      public void onSubscribe(Disposable d) {
                             compositeDisposable.add(d);
                      }

                      @Override
                      public void onNext(ShopingBean shopingBean) {
                              if (iview != null){
                                   iview.getClassSuccess(shopingBean);
                              }
                      }

                      @Override
                      public void onError(Throwable e) {
                          if (iview != null){
                              iview.getClassError(e.toString());
                          }
                      }

                      @Override
                      public void onComplete() {

                      }
                  });
    }
    public void getShopingUpdataPresenter(String uid,String sell,String pid,String selected,String num){
        shopingModel.getUpdataShopingModel(uid,sell,pid,selected,num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopingUpdataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ShopingUpdataBean shopingUpdataBean) {
                        if (iview != null){
                            iview.getUpdataClassSuccess(shopingUpdataBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getClassError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getShopingDeletePresenter(String uid,String pid){
        shopingModel.getDeleteShopingModel(uid,pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopingDeleteBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                          compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ShopingDeleteBean shopingDeleteBean) {
                        if (iview != null){
                            iview.getDeleteClassSuccess(shopingDeleteBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getClassError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getShopingButPresenter(String uid,String price){
        shopingModel.getButShopingModel(uid,price)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopingButBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ShopingButBean shopingButBean) {
                        if (iview != null){
                            iview.getButClassSuccess(shopingButBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getClassError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
