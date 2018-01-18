package com.android.library.utils;


/**
 * author: Rea.X
 * date: 2017/5/16.
 */

public class Cons {


    /**
     * Prefrences
     */
    public static class PrefrencesKeys {
        public static final String VERSION = "version_app";
    }


    /**
     * 每一页的展示数量
     */
    public static final int PAGE_COUNT = 20;


    public static final String BASE_URL = "http://59.110.228.73/mj/interface/";

    public static final String CONTROL_URL = BASE_URL + "control.php?appid=";
    public static final String USERINFO_URL = BASE_URL + "userinfo.php?user_name=";
    public static final String POST_LIST_URL = BASE_URL + "postList.php";
    public static final String POST_DETAIL_URL = BASE_URL + "postDetail.php?id=";
    public static final String REG_URL = BASE_URL + "reg.php";
    public static final String LOGIN_URL = BASE_URL + "login.php";

    public static final String POST_SAVE_URL = BASE_URL + "postSave.php";
    public static final String POST_STAR_URL = BASE_URL + "postStar.php";

    public static final String POST_COMMENT_URL = BASE_URL + "postComment.php?post_id=";
    public static final String ADD_COMMENT_URL = BASE_URL + "addComment.php";
}
