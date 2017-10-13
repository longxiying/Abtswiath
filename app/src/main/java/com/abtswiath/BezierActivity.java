package com.abtswiath;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.view.bezier.Bezier;
import com.abtswiath.view.bezier.Bezier2;

/**
 * Created by longx on 2017/10/13.
 */

public class BezierActivity extends BaseActivity {

    private Bezier bezier;
    private Bezier2 bezier2;
    private TextView one, two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
        bezier2 = (Bezier2) this.findViewById(R.id.bezier2);
        one = (TextView) this.findViewById(R.id.one);
        two = (TextView) this.findViewById(R.id.two);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                bezier2.setMode(true);
                one.setTextColor(Color.parseColor("#A020F0"));
                two.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.two:
                bezier2.setMode(false);
                two.setTextColor(Color.parseColor("#A020F0"));
                one.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }

}
