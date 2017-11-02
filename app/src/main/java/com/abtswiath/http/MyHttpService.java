package com.abtswiath.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by longx on 2017/10/17.
 */

public interface MyHttpService {

    @GET("service/getIpInfo.php")
    Call<ResponseBody> getData(@Query("ip") String ip);

}
