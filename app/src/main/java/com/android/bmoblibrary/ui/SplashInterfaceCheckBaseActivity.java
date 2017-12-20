package com.android.bmoblibrary.ui;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.bmoblibrary.utils.OnInterfaceCheckCallback;
import com.android.bmoblibrary.utils.SplashTools;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * author: Rea.X
 * date: 2017/12/20.
 */

public abstract class SplashInterfaceCheckBaseActivity<T> extends AppCompatActivity implements OnInterfaceCheckCallback<T> {
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
        OkGo.<String>get(getQueryUrl())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            String result = response.body();
                            final T t;
                            if (hasInnerClass()) {
                                t = new Gson().fromJson(result, new TypeToken<T>() {
                                }.getType());
                            } else {
                                t = new Gson().fromJson(result, getQueryClass());
                            }
                            SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                                @Override
                                public void done() {
                                    onQuerySuccess(t);
                                }
                            });
                        } catch (Exception e) {
                            SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                                @Override
                                public void done() {
                                    toMain();
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                            @Override
                            public void done() {
                                toMain();
                            }
                        });
                    }
                });
    }

    protected abstract void toMain();

    protected abstract String getQueryUrl();

    protected abstract Class<? extends T> getQueryClass();


    protected abstract
    @DrawableRes
    int getSplashImageRes();

    protected abstract boolean hasInnerClass();

//    private boolean hasInnerClass() {
//        Class<?> cls = getQueryClass();
//        // 获取内部类
//        Class innerClazz[] = cls.getDeclaredClasses();
//        if (innerClazz != null && innerClazz.length > 0)
//            return true;
//        // 获取匿名内部类实例
//        try {
//            Field field = cls.getDeclaredField("r");
//            if (field != null)
//                return true;
//        } catch (NoSuchFieldException e) {
//
//        }
//        Field[] fields = cls.getDeclaredFields();
//        for (Field f : fields) {
//            String type = f.getGenericType().toString();
//            if (!type.equals("class java.lang.String")
//                    && !type.equals("class java.lang.Integer")
//                    && !type.equals("class java.lang.Double")
//                    && !type.equals("class java.lang.Boolean")
//                    && !type.equals("class java.lang.Short")
//                    && !type.equals("class java.lang.Float")
//                    && !type.equals("class java.lang.Long")
//                    && !type.equals("boolean")
//                    && !type.equals("int")
//                    && !type.equals("long")
//                    && !type.equals("double")
//                    && !type.equals("short")
//                    && !type.equals("float"))
//                return true;
//        }
//        return false;
//    }

}
