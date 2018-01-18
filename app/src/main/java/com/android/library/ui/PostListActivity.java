package com.android.library.ui;

import com.android.library.R;
import com.android.library.base.UIActivity;
import com.android.library.databinding.ActivityPostListBinding;

/**
 * Created by wiki on 2018/1/17.
 */

public class PostListActivity extends UIActivity<ActivityPostListBinding>{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_post_list;
    }

    @Override
    protected void init() {
        tvTitle.setText("帖子列表");
    }

}
