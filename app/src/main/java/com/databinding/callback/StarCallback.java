package com.databinding.callback;

import android.util.Log;

import com.databinding.model.Girl;
import com.databinding.model.Star;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Response;

/**
 * Author Yan.
 * Date 16/6/5.
 */
public abstract class StarCallback extends Callback<List<Star>> {

    private final String TAG = StarCallback.class.getSimpleName();

    @Override
    public List<Star> parseNetworkResponse(Response response, int id) throws Exception {
        JSONObject mObject = new JSONObject(response.body().string());
        String list = mObject.getString("newslist");
        Log.i(TAG, "result = " + list);
        Gson mGson = new Gson();
        Type listType = new TypeToken<List<Star>>(){}.getType();
        List<Star> mStars = mGson.fromJson(list, listType);
        return mStars;
    }
}
