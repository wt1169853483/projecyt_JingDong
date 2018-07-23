package com.example.wangtao.project_jingdong.mvp.mine.presenter;

import android.util.Log;

import com.example.wangtao.project_jingdong.base.BasePresenter;
import com.example.wangtao.project_jingdong.mvp.homepage.model.HomeModel;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeCatagoryBean;
import com.example.wangtao.project_jingdong.mvp.homepage.model.bean.HomeUtilBean;
import com.example.wangtao.project_jingdong.mvp.homepage.view.iview.HomeIview;
import com.example.wangtao.project_jingdong.mvp.mine.model.MineModel;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineLoginBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineRegBean;
import com.example.wangtao.project_jingdong.mvp.mine.model.bean.MineUploadBean;
import com.example.wangtao.project_jingdong.mvp.mine.view.iview.IMineView;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * Created by wangtao on 2018/7/11.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class MinePresenter extends BasePresenter<IMineView> {
    private static final String TAG = "HomePresenter";
    private MineModel mineModel;

    public MinePresenter(IMineView iview) {
        super(iview);
    }

    @Override
    protected void onModel() {
        mineModel = new MineModel();
    }
    public void getMineLoginPresenter(String name,String password){
        Log.d(TAG, "getMineLoginPresenter:++++++++++++ "+name);
        if (name.equals("") && password.length() < 1) {
            if (iview != null) {
                iview.onFaild("手机号不能为空");
            }
            return;
        }

        if (name.length() < 11) {
            if (iview != null) {
                iview.onFaild("手机号长度不够");
            }
        }

        if (password.equals("") && password.length() < 1) {
            if (iview != null) {
                iview.onFaild("密码不能为空");
            }
        }
        if (password.length() < 6 && password.length() > 1) {
            if (iview != null) {
                iview.onFaild("密码长度不够");
            }
        }

        mineModel.getMineLoginModel(name,password)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MineLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(MineLoginBean mineLoginBean) {
                          if (iview != null){
                                iview.getMineSuccess(mineLoginBean);
                          }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getMineError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
         }
    public void getMineRegPresenter(String name,String password){
        mineModel.getMineRegModel(name,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MineRegBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(MineRegBean mineRegBean) {
                        if (iview != null){
                            iview.RegMineSuccess(mineRegBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.RegMineError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getUploadMineRegPresenter(String uid, MultipartBody.Part file){
        mineModel.getUploadMineRegModel(uid,file)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MineUploadBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(MineUploadBean mineUploadBean) {
                        if (iview != null){
                            iview.getUploadMineSuccess(mineUploadBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getMineError(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getMineUserPresenter(String uid){

        mineModel.getMineUserModel(uid)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MineLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(MineLoginBean mineLoginBean) {
                        if (iview != null){
                            iview.getMineSuccess(mineLoginBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iview != null){
                            iview.getMineError(e.toString());
                        }
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
