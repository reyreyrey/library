package com.android.library.manager;

import android.content.Context;
import android.content.Intent;

import com.android.library.ui.ArtActivity;
import com.android.library.ui.XiaohuaActivity;

public class UIManager {

    /**
     * 艺术家列表
     * @param context context
     * @param title 标题栏显示文字
     */
    public static void art(Context context, String title) {
        Intent intent = new Intent(context, ArtActivity.class);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    /**
     * 艺术列表（使用默认标题）
     * @param context context
     */
    public static void art(Context context) {
        art(context, "");
    }

    /**
     * 笑话列表页面
     * @param context context
     * @param title 标题栏显示文字
     */
    public static void xiaohua(Context context, String title) {
        Intent intent = new Intent(context, XiaohuaActivity.class);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    /**
     * 笑话列表页面（显示默认标题）
     * @param context context
     */
    public static void xiaohua(Context context) {
        xiaohua(context, "");
    }
}
