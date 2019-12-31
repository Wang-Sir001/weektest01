package com.bawei.wangjiangwei;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bawei.wangjiangwei.beas.BaseActivity;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.adapter.HomeAdapter;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bawei.wangjiangwei.presenter.HomePresenter;

import butterknife.BindView;
/**
 * 姓名：王江伟
 * 时间：2019年12月31日10:41:25
 * 作用：首页
 */
public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {
    @BindView(R.id.sharp)
    TextView sharp;
    @BindView(R.id.recy)
    RecyclerView recy;
    @Override
    protected void initData() {
        presenter.getData("http://blog.zhaoliang5156.cn/api/news/ranking.json");

        sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        recy.setLayoutManager(new GridLayoutManager(this,1));
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(HomeEntity homeEntity) {

//        recy.setAdapter(new HomeAdapter(this,HomeEntity.ranking));
    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
