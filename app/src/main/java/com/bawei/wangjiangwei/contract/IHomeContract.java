package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.beas.mvp.IBaseModel;
import com.bawei.wangjiangwei.beas.mvp.IBaseView;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
/**
 * 姓名：王江伟
 * 时间：2019年12月31日10:41:25
 * 作用：契约类
 */
public interface IHomeContract {
    interface IModel extends IBaseModel {
        void getData(String url,ModelCallback modelCallback);

        interface ModelCallback{
            void success(HomeEntity homeEntity);
            void error(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(HomeEntity homeEntity);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getData(String url);
    }
}
