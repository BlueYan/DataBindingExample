package com.databinding.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.databinding.activity.R;
import com.databinding.activity.databinding.FragmentStarBinding;
import com.databinding.adapter.StarAdapter;
import com.databinding.base.Constant;
import com.databinding.callback.StarCallback;
import com.databinding.model.Star;
import com.databinding.utils.DividerItemDecoration;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Author Yan.
 * Date 16/6/4.
 */
public class StarFragment extends Fragment {

    private final String TAG = StarFragment.class.getSimpleName();

    private FragmentStarBinding mStarBinding;

    private final String API_URL = "http://apis.baidu.com/txapi/huabian/newtop";

    private StarAdapter mAdapter;

    public static StarFragment newInstance() {
        return new StarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mStarBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_star, container, false);
        getData();
        return mStarBinding.getRoot();
    }


    private void getData() {
        OkHttpUtils
                .get()
                .tag(this)
                .url(API_URL)
                .addHeader("apikey", Constant.API_KEY)
                .addParams("num", "10")
                .addParams("page", "1")
                .build()
                .execute(new StarCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i(TAG, e.getMessage());
                    }

                    @Override
                    public void onResponse(List<Star> mStars, int id) {
                        if ( mAdapter == null ) {
                            mAdapter = new StarAdapter(getContext(), mStars);
                            mStarBinding.idMRv.setAdapter(mAdapter);
                            mStarBinding.idMRv.setLayoutManager(new LinearLayoutManager(getContext()));
                            mStarBinding.idMRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
                        } else {
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        OkHttpUtils.getInstance().cancelTag(this);
    }
}
