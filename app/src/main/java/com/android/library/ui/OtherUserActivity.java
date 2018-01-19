package com.android.library.ui;

import com.android.library.R;
import com.android.library.base.UIActivity;
import com.android.library.databinding.ActivityOtherUserBinding;

/**
 * Created by wiki on 2018/1/19.
 */

public class OtherUserActivity extends UIActivity<ActivityOtherUserBinding>{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_other_user;
    }

    @Override
    protected void init() {
        databinding.tablayout.addTab(databinding.tablayout.newTab().setText("主页"));
        databinding.tablayout.addTab(databinding.tablayout.newTab().setText("喜欢"));
    }
}
