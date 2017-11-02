package com.abtswiath.http;


import android.database.Observable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by longx on 2017/10/17.
 */

public class MyHttp {

    private Retrofit retrofit;

    private MyHttpService myHttpService;

    public MyHttp() {
        retrofit = new Retrofit.Builder().baseUrl("http://ip.taobao.com")
                .build();
        myHttpService = retrofit.create(MyHttpService.class);
    }

    public Call<ResponseBody> get(String ip) {
        return myHttpService.getData(ip);
    }

}
