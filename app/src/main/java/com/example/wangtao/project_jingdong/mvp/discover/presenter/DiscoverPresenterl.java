package com.example.wangtao.project_jingdong.mvp.discover.presenter;

import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.mvp.discover.Model.DiscoverModel;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.FuliBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.ISOBean;
import com.example.wangtao.project_jingdong.mvp.discover.Model.bean.NewsBean;
import com.example.wangtao.project_jingdong.mvp.discover.view.iview.IDiscoverView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangtao on 2018/7/18.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class DiscoverPresenterl extends BasePresenter<IDiscoverView>{

    private DiscoverModel discoverModel;

    public DiscoverPresenterl(IDiscoverView iview) {
        super(iview);
    }

    @Override
    protected void onModel() {
        discoverModel = new DiscoverModel();
    }

    public void getDiscover(int page){
          discoverModel.getDiscModel(page)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<NewsBean>() {
                      @Override
                      public void onSubscribe(Disposable d) {
                            compositeDisposable.add(d);
                      }

                      @Override
                      public void onNext(NewsBean newsBean) {
                          if (iview != null){
                              iview.getDiscoverSuccess(newsBean);
                          }
                      }

                      @Override
                      public void onError(Throwable e) {
                             if (iview != null){
                                   iview.getDiscoverError(e.toString());
                             }
                      }

                      @Override
                      public void onComplete() {

                      }
                  });
    }
    public void getFuLiDiscover(int page){
        discoverModel.getFuLiDiscModel(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                          compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        if (iview != null){
                            iview.getFuLiDiscoverSuccess(fuliBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getDiscoverError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getISODiscover(int page){
        discoverModel.getISODiscModel(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ISOBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                          compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ISOBean isoBean) {
                        if (iview != null){
                            iview.getISODiscoverSuccess(isoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getDiscoverError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
