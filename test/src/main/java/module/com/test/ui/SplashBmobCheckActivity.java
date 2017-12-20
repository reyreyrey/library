package module.com.test.ui;

import android.content.Intent;

import com.android.bmoblibrary.ui.DefaultSplashBmobCheckBaseActivity;
import com.android.bmoblibrary.utils.ResourceUtil;

import module.com.test.BuildConfig;


public class SplashBmobCheckActivity extends DefaultSplashBmobCheckBaseActivity {
    @Override
    protected void toMain() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected int getSplashImageRes() {
        return ResourceUtil.getDrawableId(this, BuildConfig.SPLASH_PIC);
    }
}
