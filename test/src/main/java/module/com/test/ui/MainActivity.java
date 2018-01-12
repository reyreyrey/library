package module.com.test.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.library.ui.ChatActivity;
import com.android.library.ui.ChatListActivity;
import com.android.library.utils.ToastUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import module.com.test.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {

//                    EMClient.getInstance().createAccount("rea", "rea");
                    EMClient.getInstance().createAccount("rey", "rea");
                    EMClient.getInstance().createAccount("kk", "rea");
                } catch (HyphenateException e) {
                    Log.e("11111", e.toString());
                    e.printStackTrace();
                }
            }
        }.start();


    }

    public void chatList(View v) {
        ChatListActivity.chatList(this);
    }

    public void chat(View v) {

        EMClient.getInstance().login("rea", "rea", new EMCallBack() {

            @Override
            public void onSuccess() {

                ChatActivity.chat(MainActivity.this, "kk");
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String error) {
                Log.e("111111", code + "     " + error);
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "login failed", 0).show();
                    }
                });
            }
        });

    }
}
