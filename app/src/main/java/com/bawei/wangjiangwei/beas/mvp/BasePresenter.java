package com.bawei.wangjiangwei.beas.mvp;

import android.widget.ImageView;

import com.bawei.wangjiangwei.beas.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * 姓名：王江伟
 * 时间：2019年12月31日10:41:25
 * 作用：p层封装基类
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    private WeakReference<V> weakReference;

    public BasePresenter(){
        model = initModel();
    }

    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }

    public void detach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }

    protected abstract M initModel();

    public V getView(){
        return weakReference.get();
    }
}
