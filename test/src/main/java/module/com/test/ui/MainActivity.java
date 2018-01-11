package module.com.test.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.library.ui.ChatActivity;

import module.com.test.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chat(View v) {
        ChatActivity.chat(this, "bb4ff289-bdbb-6116-420a-35695a03e566");
    }
}
