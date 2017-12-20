package com.android.bmoblibrary.ui;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.bmoblibrary.models.Config;
import com.android.bmoblibrary.utils.GuideTools;
import com.android.bmoblibrary.utils.SplashTools;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public abstract class SplashBaseActivity extends AppCompatActivity {
    private long timeStamp = 0;

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

    private void query() {
        BmobQuery<Config> query = new BmobQuery<>();
        query.findObjects(new FindListener<Config>() {
            @Override
            public void done(List<Config> list, BmobException e) {
                if (e == null) {
                    if (list != null && list.size() != 0) {
                        for (Config config : list) {
                            if (config.getAppid().equals(getPackageName())) {
                                deal(config);
                                return;
                            }
                        }
                    }
                }
                if (e != null) {
                }
                toMain();
            }
        });
    }

    private void deal(final Config configModel) {
        final String url = configModel.getUrl();
        if (configModel.isShow()) {
            if (GuideTools.needShowGuide()) {
                SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                    @Override
                    public void done() {
                        GuideActivity.showGuide(SplashBaseActivity.this, configModel);
                        finish();
                    }
                });
                return;
            } else {
                SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                    @Override
                    public void done() {
                        WebViewActivity.load(SplashBaseActivity.this, url);
                        finish();
                    }
                });
                return;
            }
        }
        toMain();
    }

    protected abstract void toMain();

    protected abstract
    @DrawableRes
    int getSplashImageRes();
}

