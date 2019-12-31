package com.bawei.wangjiangwei.model;

import android.util.Log;

import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bawei.wangjiangwei.utils.OkHttpUtils;
import com.google.gson.Gson;
/**
 * 姓名：王江伟
 * 时间：2019年12月31日10:41:25
 * 作用：m层
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getData(String url, ModelCallback modelCallback) {

        OkHttpUtils.getInstance().doGet(url, new OkHttpUtils.OkHttpCallback() {
            @Override
            public void success(String data) {

                HomeEntity homeEntity = new Gson().fromJson(data, HomeEntity.class);
                modelCallback.success(homeEntity);
            }

            @Override
            public void error(Throwable throwable) {
                modelCallback.error(throwable);
            }
        });
    }
}
