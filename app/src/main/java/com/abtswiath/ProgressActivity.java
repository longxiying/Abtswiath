package com.abtswiath;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.view.MyViewProgress;

/**
 * Created by longx on 2017/10/17.
 */

public class ProgressActivity extends BaseActivity implements View.OnClickListener {

    private MyViewProgress myViewProgress;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        myViewProgress = (MyViewProgress) this.findViewById(R.id.p);
        button = (Button) this.findViewById(R.id.button6);
        button.setOnClickListener(this);
    }

    private int i = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button6:
                i++;
                button.setText(i+"");
                myViewProgress.setProgress(i);
                myViewProgress.setLineW(6);
                break;
        }
    }
}
