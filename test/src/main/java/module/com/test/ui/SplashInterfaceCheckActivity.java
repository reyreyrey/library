package module.com.test.ui;

import android.content.Intent;

import com.android.library.ui.SplashBaseActivity;
import com.android.library.utils.ResourceUtil;

import module.com.test.BuildConfig;

/**
 * author: Rea.X
 * date: 2017/12/20.
 */

public class SplashInterfaceCheckActivity extends SplashBaseActivity{

    @Override
    protected void toMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected String getAppID() {
        return "1";
    }



    @Override
    protected int getSplashImageRes() {
        return ResourceUtil.getDrawableId(this, BuildConfig.SPLASH_PIC);
    }

    @Override
    protected boolean isShowGuide() {
        return false;
    }

    @Override
    protected int[] guideRess() {
        return new int[0];
    }

}
