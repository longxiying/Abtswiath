package com.abtswiath.http;


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
        retrofit = new Retrofit.Builder().baseUrl("https://way.jd.com/")
                .build();
        myHttpService = retrofit.create(MyHttpService.class);
    }

    private static final String API_KEY = "e746b35c9b69c4f54ef59a0536f9bd78";

    public Call<ResponseBody> get() {
        return myHttpService.listRepos(API_KEY);
    }

}
