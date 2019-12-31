package com.bawei.wangjiangwei;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.wangjiangwei.beas.BaseActivity;
import com.bawei.wangjiangwei.beas.mvp.BasePresenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * 姓名：王江伟
 * 时间：2019年12月31日10:41:25
 * 作用：第二页
 */
public class SecondActivity extends BaseActivity {
    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void initData() {

        Bitmap bitmap = CodeUtils.createImage("王江伟", 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        img.setImageBitmap(bitmap);
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(img, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(SecondActivity.this, result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(SecondActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }

    @Override
    protected void initView() {
        CodeUtils.init(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_second;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    @OnClick({R.id.butQQ,R.id.butwx})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.butQQ:
                EventBus.getDefault().post("QQ");
                break;
            case R.id.butwx:
                EventBus.getDefault().post("微信");
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void qq(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
