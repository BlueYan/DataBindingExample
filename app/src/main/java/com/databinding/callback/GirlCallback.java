package com.databinding.callback;

import android.util.Log;

import com.databinding.model.Girl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Response;

/**
 * Author Yan.
 * Date 16/6/3.
 */
public abstract class GirlCallback extends Callback<List<Girl>> {

    private final String TAG = GirlCallback.class.getSimpleName();

    @Override
    public List<Girl> parseNetworkResponse(Response response, int id) throws Exception {
        /*JsonObject mObject = new JsonObject();
        String result = mObject.getAsJsonObject(response.body().string()).get("newslist").getAsString();
        Log.i(TAG, "result = " + result);
        Gson mGson = new Gson();
        Type listType = new TypeToken<List<Girl>>(){}.getType();
        List<Girl> mGirls = mGson.fromJson(result, listType);
        return mGirls;*/
        JSONObject mObject = new JSONObject(response.body().string());
        String list = mObject.getString("newslist");
        Log.i(TAG, "result = " + list);
        Gson mGson = new Gson();
        Type listType = new TypeToken<List<Girl>>(){}.getType();
        List<Girl> mGirls = mGson.fromJson(list, listType);
        return mGirls;
    }
}
