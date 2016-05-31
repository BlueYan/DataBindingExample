package com.databinding.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author Yan.
 * Date 16/5/31.
 */
public class BeautiGirlFragment extends Fragment {

    private final String TAG = BeautiGirlFragment.class.getSimpleName();

    private final String API_URL = "http://apis.baidu.com/txapi/mvtp/meinv";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
