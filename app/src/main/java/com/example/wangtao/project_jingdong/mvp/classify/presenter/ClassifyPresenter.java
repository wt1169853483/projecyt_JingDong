package com.example.wangtao.project_jingdong.mvp.classify.presenter;

import android.util.Log;

import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.base.Iview;
import com.example.wangtao.project_jingdong.mvp.classify.model.ClassifyModel;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyLeftBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyPscidBean;
import com.example.wangtao.project_jingdong.mvp.classify.model.bean.ClassifyRightBean;
import com.example.wangtao.project_jingdong.mvp.classify.view.iview.IClassView;

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
public class ClassifyPresenter extends BasePresenter<IClassView> {
    private static final String TAG = "ClassifyPresenter";
    private ClassifyModel classifyModel;

    public ClassifyPresenter(IClassView iview) {
        super(iview);
    }
    @Override
    protected void onModel() {
        classifyModel = new ClassifyModel();
    }
    public void getClassPresenter(){
          classifyModel.getClassifyModel()
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<ClassifyLeftBean>() {
                      @Override
                      public void onSubscribe(Disposable d) {
                           compositeDisposable.add(d);
                      }

                      @Override
                      public void onNext(ClassifyLeftBean classifyLeftBean) {
                            if (iview != null){
                                 iview.getClassSuccess(classifyLeftBean);
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
    public void getClassRightPresenter(String url) {
               classifyModel.getClassifyRightModel(url)
                       .subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(new Observer<ClassifyRightBean>() {
                           @Override
                           public void onSubscribe(Disposable d) {
                                 compositeDisposable.add(d);
                           }

                           @Override
                           public void onNext(ClassifyRightBean classifyRightBean) {
                               if(iview != null){
                                    iview.getClassRightSuccess(classifyRightBean);
                               }
                           }

                           @Override
                           public void onError(Throwable e) {
                               if(iview != null){
                                   iview.getClassRightError(e.toString());
                               }
                           }

                           @Override
                           public void onComplete() {

                           }
                       });
    }
    public void getPscidRightPresenter(String pscid) {
        classifyModel.getPscidModel(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassifyPscidBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClassifyPscidBean classifyPscidBean) {
                        if(iview != null){
                            iview.getPscidRightSuccess(classifyPscidBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(iview != null){
                            iview.getClassError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
