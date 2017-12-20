package com.android.bmoblibrary.ui;

import com.android.bmoblibrary.models.Config;
import com.android.bmoblibrary.utils.GuideTools;
import com.android.bmoblibrary.utils.SplashTools;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public abstract class DefaultSplashBmobCheckBaseActivity extends SplashBmobCheckBaseActivity {


    @Override
    protected void query() {
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
                        GuideActivity.showGuide(DefaultSplashBmobCheckBaseActivity.this, configModel);
                        finish();
                    }
                });
                return;
            } else {
                SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                    @Override
                    public void done() {
                        WebViewActivity.load(DefaultSplashBmobCheckBaseActivity.this, url);
                        finish();
                    }
                });
                return;
            }
        }
        toMain();
    }


}

