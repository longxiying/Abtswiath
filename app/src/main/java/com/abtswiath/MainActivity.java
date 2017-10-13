package com.abtswiath;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.bean.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

public class MainActivity extends BaseActivity {

    private Button button1, button2;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowAnimations();
        setContentView(R.layout.activity_main);
        button1 = (Button) this.findViewById(R.id.button1);
        button2 = (Button) this.findViewById(R.id.button2);
        String model = Build.MODEL;
//PROP
        Log.e(TAG, "onCreate: "+model+"-----"+getSN()+"--------"+ android.os.SystemProperties.get("gsm.serial2")+android.os.SystemProperties.get("ro.sunmi.devicecode"));
        
        final MyAsyncTask myAsyncTask = new MyAsyncTask() {
            @Override
            protected void onProgressUpdate(String... values) {
                button1.setText(values[0]);
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String s) {

                button1.setText(s + "----");

                super.onPostExecute(s);
            }

            @Override
            protected void onPreExecute() {
                button1.setText("开始----");
                super.onPreExecute();
            }
        };
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask.execute("88", "77");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(1, "Abtswiath丶", true);
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/sdcard/cc.txt"));
                    outputStream.writeObject(user);
                    outputStream.close();
                    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/sdcard/cc.txt"));
                    User user1 = (User) inputStream.readObject();
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        this.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TransitionActivity.class);
                startActivity(intent);
            }
        });
        this.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Path1Activity.class);
                startActivity(intent);
            }
        });
        this.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CobwebActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupWindowAnimations() {
        Explode explode = new Explode();
        explode.setDuration(2000);
        getWindow().setExitTransition(explode);
    }

    /**
     * 获取机器MSN码(完整)
     *
     * @return
     */
    public  String getSN() {
        String serial = null;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class);
            serial = (String) get.invoke(c, "ro.serialno");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return serial;
    }

    /**
     * 获取机器MSN码(完整)
     *
     * @return
     */
    public  String getSN2() {
        String serial = null;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class);
            serial = (String) get.invoke(c, "gsm.serial1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (serial == null) {
            return "";
        }
        if (serial.length() > 16) {
            serial = serial.substring(0, 15);
        }

        return serial;
    }

}
