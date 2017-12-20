package com.android.bmoblibrary;

import android.app.Application;
import android.text.TextUtils;

import cn.bmob.v3.Bmob;
import cn.jpush.android.api.JPushInterface;

/**
 * author: Rea.X
 * date: 2017/12/18.
 */

public class Library {

    public static void init(Application app, String bmobKey, boolean isDebug){
        Library.app = app;
        Library.isDebug = isDebug;
        JPushInterface.setDebugMode(isDebug);
        JPushInterface.init(app);
        if (!TextUtils.isEmpty(bmobKey))
            Bmob.initialize(app, bmobKey);
    }

    private static Application app;
    private static boolean isDebug;
    public static Application get(){
        return app;
    }

    public static boolean isDebug() {
        return isDebug;
    }
}
