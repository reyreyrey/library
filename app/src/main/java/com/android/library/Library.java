package com.android.library;

import android.app.Application;
import android.text.TextUtils;

import com.android.library.models.BaseModel;
import com.android.library.models.UserModel;
import com.android.library.utils.SharedPreferencesUtils;
import com.android.library.utils.UserManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.utils.EaseCommonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.io.IOException;

import cn.jpush.android.api.JPushInterface;

import static com.android.library.utils.Cons.USERINFO_URL;

/**
 * author: Rea.X
 * date: 2017/12/18.
 */

public class Library {

    public static void init(Application app, boolean isDebug) {
        Library.app = app;
        Library.isDebug = isDebug;
        JPushInterface.setDebugMode(isDebug);
        JPushInterface.init(app);

        initEaseUI(app);
    }


    private static void initEaseUI(Application app) {
        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(true);
        EaseUI.getInstance().init(app, options);
        EaseUI.getInstance().setUserProfileProvider(new EaseUI.EaseUserProfileProvider() {
            @Override
            public EaseUser getUser(String userid) {
                EaseUser easeUser = new EaseUser(userid);
                UserModel userModel = UserManager.getUser(userid);
                if (userModel != null) {
                    easeUser.setNickname(userModel.getNickname());
                    easeUser.setAvatar(userModel.getPhoto());
                    return easeUser;
                }
                try {
                    okhttp3.Response response = OkGo.<String>get(USERINFO_URL + userid).execute();
                    String result = response.body().string();
                    BaseModel<UserModel> model = new Gson().fromJson(result, new TypeToken<BaseModel<UserModel>>() {
                    }.getType());
                    UserModel userModel1 = model.getData();
                    UserManager.saveOtherUser(userModel1);
                    easeUser.setNickname(userModel1.getNickname());
                    easeUser.setAvatar(userModel1.getPhoto());
                    return easeUser;
                } catch (Exception e) {
                }
                return null;
            }
        });
    }

    private static Application app;
    private static boolean isDebug;

    public static Application get() {
        return app;
    }

    public static boolean isDebug() {
        return isDebug;
    }


}
