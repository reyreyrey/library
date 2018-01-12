package com.android.library.utils;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.exceptions.HyphenateException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wiki on 11/01/2018.
 */

public class ChatUtils {

    public static void loadAll(){
        EMClient.getInstance().chatManager().loadAllConversations();
        EMClient.getInstance().groupManager().loadAllGroups();
    }

    public static boolean isLoggedIn() {
        return EMClient.getInstance().isLoggedInBefore();
    }


}
