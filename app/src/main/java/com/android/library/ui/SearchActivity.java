package com.android.library.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.library.R;
import com.android.library.adapter.UserAdapter;
import com.android.library.base.RefreshActivity;
import com.android.library.manager.UserManager;
import com.android.library.models.BaseModel;
import com.android.library.models.UserModel;
import com.android.library.utils.SoftKeyboardUtils;
import com.android.library.utils.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joanzapata.android.QuickAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;

import java.util.List;

import static com.android.library.utils.Cons.SEARCH_URL;


public class SearchActivity extends RefreshActivity<UserModel> implements View.OnClickListener, Runnable {


    private ImageView ivSearch;
    private EditText edtSearch;
    private String key;
    private UserModel userModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected boolean enableLoadmore() {
        return false;
    }

    @Override
    protected void init() {
        tvTitle.setText("搜索");
        userModel = UserManager.getCurrentUser();
        handler.postDelayed(this, 300);
        ivSearch = (ImageView) findViewById(R.id.iv_search);
        edtSearch = (EditText) findViewById(R.id.edt_search);
        ivSearch.setOnClickListener(this);
        super.init();
    }


    @Override
    protected QuickAdapter<UserModel> getAdapter() {
        return new UserAdapter(context, true);
    }

    @Override
    public void run() {
        SoftKeyboardUtils.showSoftKeyboard(context, edtSearch);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_search) {
            search();
        }
    }

    private void search() {
        key = edtSearch.getText().toString().trim();
        if (TextUtils.isEmpty(key)) {
            ToastUtils.toastError(context, "请输入要搜索的用户名");
            return;
        }
        adapter.clear();
        showProgress();
        query();
    }


    @Override
    public void finish() {
        super.finish();
        SoftKeyboardUtils.togSoftkeybord(context, edtSearch, true);
    }

    @Override
    protected boolean needQueryInInit() {
        return false;
    }

    @Override
    protected void query() {
        GetRequest request = OkGo.<String>get(SEARCH_URL + key);
        if (userModel != null) {
            request.params("user_id", userModel.getUserid());
        }
        request.execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                dismissProgress();
                String result = response.body();
                BaseModel<List<UserModel>> baseModel = new Gson().fromJson(result, new TypeToken<BaseModel<List<UserModel>>>() {
                }.getType());
                if (baseModel.getSuccess() == 1) {
                    UserAdapter userAdapter = (UserAdapter) adapter;
                    userAdapter.setKey(key);
                    if (isRefresh) {
                        adapter.clear();
                    }
                    adapter.addAll(baseModel.getData());
                }
                smartRefreshLayout.finishRefresh();
                smartRefreshLayout.finishLoadmore();
                refreshView();
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                dismissProgress();
                smartRefreshLayout.finishRefresh();
                smartRefreshLayout.finishLoadmore();
                refreshView();
            }
        });
    }
}
