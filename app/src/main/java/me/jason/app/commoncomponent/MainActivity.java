package me.jason.app.commoncomponent;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

@Route(path = RouterHub.APP_MAINACTIVITY)
public class MainActivity extends BaseActivity {
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
