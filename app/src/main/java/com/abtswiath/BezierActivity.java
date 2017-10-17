package com.abtswiath;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.view.bezier.Bezier;
import com.abtswiath.view.bezier.Bezier2;
import com.abtswiath.view.bezier.Bezier3;
import com.abtswiath.view.bezier.Bezier4;

/**
 * Created by longx on 2017/10/13.
 */

public class BezierActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private Bezier bezier1;
    private Bezier2 bezier2;
    private Bezier3 bezier3;
    private Bezier4 bezier4;
    private TextView one, two;
    private LinearLayout linearLayoutBezier2;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
        bezier2 = (Bezier2) this.findViewById(R.id.bezier2);
        bezier3 = (Bezier3) this.findViewById(R.id.bezier3);
        bezier4 = (Bezier4) this.findViewById(R.id.bezier4);
        one = (TextView) this.findViewById(R.id.one);
        two = (TextView) this.findViewById(R.id.two);
        bezier1 = (Bezier) this.findViewById(R.id.bezier1);
        linearLayoutBezier2 = (LinearLayout) this.findViewById(R.id.lin_bezier2);
        radioGroup = (RadioGroup) this.findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);
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

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb1:
                bezier1.setVisibility(View.VISIBLE);
                linearLayoutBezier2.setVisibility(View.GONE);
                bezier3.setVisibility(View.GONE);
                bezier4.setVisibility(View.GONE);
                break;
            case R.id.rb2:
                linearLayoutBezier2.setVisibility(View.VISIBLE);
                bezier1.setVisibility(View.GONE);
                bezier3.setVisibility(View.GONE);
                bezier4.setVisibility(View.GONE);
                break;
            case R.id.rb3:
                linearLayoutBezier2.setVisibility(View.GONE);
                bezier1.setVisibility(View.GONE);
                bezier3.setVisibility(View.VISIBLE);
                bezier4.setVisibility(View.GONE);
                break;
            case R.id.rb4:
                linearLayoutBezier2.setVisibility(View.GONE);
                bezier1.setVisibility(View.GONE);
                bezier3.setVisibility(View.GONE);
                bezier4.setVisibility(View.VISIBLE);
                bezier4.startAnimation();
                break;
        }
    }
}
