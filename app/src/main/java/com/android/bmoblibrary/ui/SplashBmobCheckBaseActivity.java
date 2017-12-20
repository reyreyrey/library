package com.android.bmoblibrary.ui;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

/**
 * author: Rea.X
 * date: 2017/12/20.
 */

public abstract class SplashBmobCheckBaseActivity extends AppCompatActivity {
    protected long timeStamp = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView im = new ImageView(this);
        setContentView(im);
        ImmersionBar.with(this)
                .fitsSystemWindows(false)
                .hideBar(BarHide.FLAG_HIDE_BAR).init();
        im.setBackgroundResource(getSplashImageRes());
        timeStamp = System.currentTimeMillis();
        query();
    }

    protected abstract void query();

    protected abstract void toMain();

    protected abstract
    @DrawableRes
    int getSplashImageRes();
}
