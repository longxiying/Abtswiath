package com.abtswiath;

import android.database.Observable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.http.MyHttp;
import com.abtswiath.utils.ThreadPoolManager;
import com.abtswiath.view.MyButton;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by longx on 2017/10/17.
 */

public class HttpActivity extends BaseActivity implements View.OnClickListener {

    private MyButton button;
    private MyHttp myHttp;
    private static final String TAG = "HttpActivity";
    private EditText editTextIp;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        button = (MyButton) this.findViewById(R.id.button);
        editTextIp = (EditText) this.findViewById(R.id.edit_ip);
        textResult = (TextView) this.findViewById(R.id.text_result);
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
                        Call<ResponseBody> call = myHttp.get(editTextIp.getText().toString());
                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                try {
                                    textResult.setTextColor(MyButton.getColor());
                                    textResult.setText(response.body().string());
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
