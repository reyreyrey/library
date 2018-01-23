package com.android.library.ui;

import android.text.TextUtils;

import com.android.library.R;
import com.android.library.base.UIActivity;
import com.android.library.databinding.ActivitySettingBinding;

/**
 * Created by wiki on 2018/1/23.
 */

public class SettingActivity extends UIActivity<ActivitySettingBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {
        String title = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(title))
            tvTitle.setText(title);
        else
            tvTitle.setText("设置");
    }
}
