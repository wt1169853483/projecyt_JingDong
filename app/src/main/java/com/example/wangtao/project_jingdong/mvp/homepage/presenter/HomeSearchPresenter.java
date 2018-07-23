package com.example.wangtao.project_jingdong.mvp.homepage.presenter;

import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.HomeModel;
import com.example.wangtao.project_jingdong.mvp.homepage.model.HomeSearchModel;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeButBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomePidBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeSearchBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeaddCarBean;
import com.example.wangtao.project_jingdong.mvp.homepage.view.iview.HomeIview;
import com.example.wangtao.project_jingdong.mvp.homepage.view.iview.IHomeSearch;

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
public class HomeSearchPresenter extends BasePresenter<IHomeSearch> {
    private static final String TAG = "HomePresenter";
    private HomeSearchModel homeSearchModel;

    public HomeSearchPresenter(IHomeSearch iview) {
        super(iview);
    }

    @Override
    protected void onModel() {
          homeSearchModel =new HomeSearchModel();
    }


    public void getSearchPresenter(String keywords,String page,String sort){
             homeSearchModel.getHomemiaosha(keywords,page,sort)
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Observer<HomeSearchBean>() {
                         @Override
                         public void onSubscribe(Disposable d) {
                               compositeDisposable.add(d);
                         }

                         @Override
                         public void onNext(HomeSearchBean homeSearchBean) {
                             if (iview != null){
                                   iview.getHomeSuccess(homeSearchBean);
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
