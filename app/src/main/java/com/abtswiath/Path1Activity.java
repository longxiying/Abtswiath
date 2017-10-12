package com.abtswiath;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.view.View2;

/**
 * Created by longx on 2017/10/12.
 */

public class Path1Activity extends BaseActivity implements View.OnClickListener {

    private TextView title;
    private View2 view2;
    private static final String TAG = "Path1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path1);
        view2 = (View2) this.findViewById(R.id.view);
        title = (TextView) this.findViewById(R.id.tv_title);
        title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_title:
                Log.e(TAG, "onClick: tv_title" );
                view2.change();
                break;
        }
    }
}
