package com.android.library.utils;

import com.android.library.Library;
import com.android.library.models.UserModel;

/**
 * author: Rea.X
 * date: 2018/1/10.
 */

public class UserManager {
    private static final String KEY_CURRENT_USER = "current_user";

    public static UserModel getCurrentUser() {
        Object o = SharedPreferencesUtils.readObject(Library.get(), KEY_CURRENT_USER);
        if (o != null) {
            return (UserModel) o;
        }
        return null;
    }

    public static boolean isLogin() {
        return getCurrentUser() != null;
    }

    public static void saveOtherUser(UserModel model) {
        SharedPreferencesUtils.saveObject(Library.get(), model.getUsername(), model);
    }

    public static UserModel getUser(String username) {
        Object o = SharedPreferencesUtils.readObject(Library.get(), username);
        if (o != null)
            return (UserModel) o;
        return null;
    }
}
