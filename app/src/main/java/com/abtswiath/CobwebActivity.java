package com.abtswiath;

import android.os.Bundle;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.view.CobwebView;

/**
 * Created by longx on 2017/10/13.
 */

public class CobwebActivity extends BaseActivity {

    private CobwebView cobwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobweb);
        cobwebView = (CobwebView) this.findViewById(R.id.cobweb_view);
        cobwebView.setData(new double[]{60, 20, 66, 15, 100, 88});
        cobwebView.setTitles(new String[]{"击杀", "爆头", "吃鸡", "KDA", "排行", "战力"});
        cobwebView.setMainPaintColor(getResources().getColor(R.color.colorPrimary));
        cobwebView.setValuePaintColor(getResources().getColor(R.color.colorAccent));
        cobwebView.invalidate();
    }
}
