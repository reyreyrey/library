package module.com.test.ui;

import android.content.Intent;
import android.text.TextUtils;

import com.android.bmoblibrary.ui.SplashInterfaceCheckBaseActivity;
import com.android.bmoblibrary.ui.WebViewActivity;
import com.android.bmoblibrary.utils.ResourceUtil;

import module.com.test.BuildConfig;
import module.com.test.models.InterfaceCheckModel;

/**
 * author: Rea.X
 * date: 2017/12/20.
 */

public class SplashInterfaceCheckActivity extends SplashInterfaceCheckBaseActivity<InterfaceCheckModel>{
    @Override
    public void onQuerySuccess(InterfaceCheckModel interfaceCheckModel) {
        //接口请求返回，根据返回的model来判断是否需要跳转
        if(interfaceCheckModel != null
                && interfaceCheckModel.getStatus() == 1
                && interfaceCheckModel.getIsshowwap().equalsIgnoreCase("1")){
            String url = interfaceCheckModel.getWapurl();
            if(!TextUtils.isEmpty(url)){
                WebViewActivity.load(this, url);
                return;
            }
        }
        toMain();
    }

    @Override
    protected void toMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected String getQueryUrl() {
        //获取接口地址，BuildConfig.INTERFACE_URL在global.gradle中配置
        return BuildConfig.INTERFACE_URL;
    }

    @Override
    protected Class<? extends InterfaceCheckModel> getQueryClass() {
        return InterfaceCheckModel.class;
    }

    @Override
    protected int getSplashImageRes() {
        return ResourceUtil.getDrawableId(this, BuildConfig.SPLASH_PIC);
    }

    @Override
    protected boolean hasInnerClass() {
        //model中是否有List、ArrayList、内部类，如果有就返回true
        return false;
    }
}
