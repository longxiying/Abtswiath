package com.abtswiath;

import android.os.Bundle;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.bean.PieData;
import com.abtswiath.view.PieView;

import java.util.ArrayList;

/**
 * Created by longx on 2017/11/1.
 */

public class PieActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pie);


        PieView view = new PieView(this);
        setContentView(view);

        ArrayList<PieData> datas = new ArrayList<>();
        PieData pieData = new PieData("1", 60);
        PieData pieData2 = new PieData("2", 30);
        PieData pieData3 = new PieData("3", 40);
        PieData pieData4 = new PieData("4", 20);
        PieData pieData5 = new PieData("5", 20);
        datas.add(pieData);
        datas.add(pieData2);
        datas.add(pieData3);
        datas.add(pieData4);
        datas.add(pieData5);
        view.setData(datas);
    }
}
