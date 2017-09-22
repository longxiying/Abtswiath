package com.abtswiath;

import android.os.AsyncTask;

/**
 * Created by longx on 2017/9/22.
 */

public class MyAsyncTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... params) {
        String str1 = params[0];
        String str2 = params[1];
        int i= 0;
        while (true){
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(""+i);
            if(i>100){
                break;
            }
        }
        return str1 + str2;
    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
