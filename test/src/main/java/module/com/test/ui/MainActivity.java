package module.com.test.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.library.ui.ChatActivity;
import com.android.library.ui.ChatListActivity;
import com.android.library.ui.LoginActivity;
import com.android.library.ui.PostListActivity;
import com.android.library.ui.RegisterActivity;
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
    }

    public void postList(View view){
        startActivity(new Intent(this, PostListActivity.class));
    }

    public void reg(View view){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void login(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

}
