package com.bawei.wangjiangwei.presenter;

import android.util.Log;

import com.bawei.wangjiangwei.beas.mvp.BasePresenter;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.HomeModel;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
/**
 * 姓名：王江伟
 * 时间：2019年12月31日10:41:25
 * 作用：p层封
 */
public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IPresenter {
    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void getData(String url) {

        model.getData(url, new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(HomeEntity homeEntity) {

                getView().success(homeEntity);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }
}
