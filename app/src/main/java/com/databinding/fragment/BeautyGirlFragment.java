package com.databinding.fragment;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.databinding.activity.R;
import com.databinding.activity.databinding.FragmentGirlBinding;
import com.databinding.adapter.GirlAdapter;
import com.databinding.base.Constant;
import com.databinding.callback.GirlCallback;
import com.databinding.model.Girl;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Author Yan.
 * Date 16/5/31.
 */
public class BeautyGirlFragment extends Fragment {

    private final String TAG = BeautyGirlFragment.class.getSimpleName();

    private final String API_URL = "http://apis.baidu.com/txapi/mvtp/meinv";

    private FragmentGirlBinding mGirlBinding; //在fragment中，数据绑定命名规则貌似跟在Activity中有点不一样。

    private GirlAdapter mAdapter;

    private List<Girl> mGirls;

    public static BeautyGirlFragment newInstance(){
        return new BeautyGirlFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mGirlBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_girl, container, false); //在Fragment下获取ViewDataBinding类型
        mGirls = new ArrayList<Girl>();
        getData();
        return mGirlBinding.getRoot();
    }

    private void getData() {
        final ProgressDialog mPDiglog = ProgressDialog.show(getContext(), null, "获取数据中...");
        Log.i(TAG, "BeautyGirlFragment");
        OkHttpUtils
                .get()
                .tag(this)
                .url(API_URL)
                .addHeader("apikey", Constant.API_KEY)
                .addParams("num", "10")
                .build()
                .execute(new GirlCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i(TAG, "e = " + e.getMessage());
                        e.printStackTrace();
                        mPDiglog.dismiss();
                    }

                    @Override
                    public void onResponse(final List<Girl> response, int id) {
                        mPDiglog.dismiss();
                        Log.i(TAG, "onResponse");
                        mGirls.clear();
                        mGirls = response;
                        if ( mAdapter == null ) {
                            mAdapter = new GirlAdapter(getContext(), mGirls);
                            mGirlBinding.idMRv.setAdapter(mAdapter);
                            mGirlBinding.idMRv.setLayoutManager(new LinearLayoutManager(getContext()));
                            mAdapter.setOnItemClickListener(new GirlAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(getContext(), "Click " + response.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                                }
                            });
                            mAdapter.setOnItemLongClickListener(new GirlAdapter.OnItemLongClickListener() {
                                @Override
                                public void onItemLongClick(View view, int position) {
                                    Toast.makeText(getContext(), "Long Click " + response.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                                }
                            });
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
