package com.abtswiath;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.bean.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends BaseActivity {

    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) this.findViewById(R.id.button1);
        button2 = (Button) this.findViewById(R.id.button2);
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
    }
}
