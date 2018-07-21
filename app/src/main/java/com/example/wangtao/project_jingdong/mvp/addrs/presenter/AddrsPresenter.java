package com.example.wangtao.project_jingdong.mvp.indent.presenter;

import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.mvp.classify.model.ClassifyModel;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.classify.view.iview.IClassView;
import com.example.wangtao.project_jingdong.mvp.indent.model.IndentModel;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentAddrBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentBean;
import com.example.wangtao.project_jingdong.mvp.indent.model.bean.IndentUpdataBean;
import com.example.wangtao.project_jingdong.mvp.indent.view.iview.IndentView;

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
public class IndentPresenter extends BasePresenter<IndentView> {

   private IndentModel indentModel;

    public IndentPresenter(IndentView iview) {
        super(iview);
    }

    @Override
    protected void onModel() {
           indentModel=new IndentModel();
    }


    public void getClassPresenter(String uid){
        indentModel.getClassifyModel(uid)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<IndentBean>() {
                      @Override
                      public void onSubscribe(Disposable d) {
                            compositeDisposable.add(d);
                      }

                      @Override
                      public void onNext(IndentBean indentBean) {
                          if (iview != null){
                              iview.getDataSuccess(indentBean);
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
    public void getClassPresenter(String uid,String status,String orderId){
        indentModel.getUpdataIndentModel(uid,status,orderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IndentUpdataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(IndentUpdataBean indentUpdataBean) {
                        if (iview != null){
                            iview.getUpdataSuccess(indentUpdataBean);
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
    public void getDefaultAddrPresenter(String uid){
        indentModel.getDefaultAddrModel(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IndentAddrBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(IndentAddrBean indentAddrBean) {
                        if (iview != null){
                            iview.getDufaAddrSuccess(indentAddrBean);
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
}
