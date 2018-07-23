package com.example.wangtao.project_jingdong.mvp.addrs.presenter;

import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.mvp.addrs.model.AddrsModel;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsAddBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsDefaultBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsSetBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUpdataBean;
import com.example.wangtao.project_jingdong.mvp.addrs.model.bean.AddrsUserBean;
import com.example.wangtao.project_jingdong.mvp.addrs.view.iview.IAddrsView;

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
public class AddrsPresenter extends BasePresenter<IAddrsView> {


    private AddrsModel addrsModel;

    public AddrsPresenter(IAddrsView iview) {
        super(iview);
    }
    @Override
    protected void onModel() {
        addrsModel = new AddrsModel();
    }

    public void getDefaultAddrPresenter(String uid){
        addrsModel.getDefaultAddrModel(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddrsDefaultBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                          compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(AddrsDefaultBean addrsDefaultBean) {
                        if (iview != null){
                            iview.getDataSuccess(addrsDefaultBean);
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
    public void getUserAddrPresenter(String uid){
        addrsModel.getUserAddrModel(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddrsUserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(AddrsUserBean addrsUserBean) {
                        if (iview != null){
                            iview.getUserSuccess(addrsUserBean);
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
    public void getAddAddrPresenter(String uid,String addr,String mobile,String name){
        addrsModel.getAddAddrModel(uid,addr,mobile,name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddrsAddBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                          compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(AddrsAddBean addrsAddBean) {
                        if (iview != null){
                            iview.getAddSuccess(addrsAddBean);
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
    public void getUpdataAddrPresenter(String uid, String addrid,String mobile, String name, String addr){
        addrsModel.getUpdataAddrModel(uid,addrid,mobile,name,addr)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddrsUpdataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                          compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(AddrsUpdataBean addrsUpdataBean) {
                        if (iview != null){
                            iview.getUpdataSuccess(addrsUpdataBean);
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
    public void getSetAddrPresenter(String uid, String addrid,String status){
        addrsModel.getSetAddrModel(uid,addrid,status)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddrsSetBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(AddrsSetBean addrsSetBean) {
                        if (iview != null){
                            iview.getSetSuccess(addrsSetBean);
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
