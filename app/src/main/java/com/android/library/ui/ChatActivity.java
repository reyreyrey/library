package com.android.library.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.android.library.R;
import com.android.library.base.UIActivity;
import com.android.library.databinding.ActivityChatBinding;
import com.hyphenate.chat.EMMessage;

/**
 * author: Rea.X
 * date: 2018/1/10.
 */

public class ChatActivity extends UIActivity<ActivityChatBinding> {
    public static void chat(AppCompatActivity appCompatActivity, String chatUserid) {
        Intent intent = new Intent(appCompatActivity, ChatActivity.class);
        intent.putExtra("userid", chatUserid);
        appCompatActivity.startActivity(intent);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }

    @Override
    protected void init() {
        String chatUserid = getIntent().getStringExtra("userid");
        databinding.messageList.init(chatUserid, 1, null);
    }
}
