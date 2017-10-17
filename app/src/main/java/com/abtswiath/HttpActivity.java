package com.abtswiath;

import android.content.res.ObbInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.bean.City;
import com.abtswiath.bean.Result;
import com.abtswiath.bean.Result1;
import com.abtswiath.http.MyHttp;
import com.abtswiath.utils.ThreadPoolManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by longx on 2017/10/17.
 */

public class HttpActivity extends BaseActivity implements View.OnClickListener {

    private Button button;
    private MyHttp myHttp;
    private static final String TAG = "HttpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);
        myHttp = new MyHttp();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                ThreadPoolManager.executeInCachePool(new Runnable() {
                    @Override
                    public void run() {
                        Call<ResponseBody> call = myHttp.get();
                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                try {
                                    Log.e(TAG, "onResponse: "+response.body().string() );
                                    String json = response.body().string();
                                    button.setText(json);
//                                    Gson gson = new Gson();
//                                    Type jsonType = new TypeToken<Result<Result1<City>>>() {
//                                    }.getType();
//                                    Result<Result1<City>> result = gson.fromJson(json, jsonType);
//                                    Log.e(TAG, "onResponse: "+result.toString());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable throwable) {

                            }
                        });

                    }
                });
                break;
        }
    }
}
