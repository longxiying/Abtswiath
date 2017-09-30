package com.abtswiath;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.abtswiath.base.BaseActivity;
import com.abtswiath.view.View1;

/**
 * Created by longx on 2017/9/28.
 */

public class TransitionActivity extends BaseActivity {

    private View1 view1;
    private TextView txt;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene1);
        view1 = (View1) this.findViewById(R.id.my_view);
        txt = (TextView) this.findViewById(R.id.txt);
        spinner = (Spinner) this.findViewById(R.id.spinner);
        String[] flags = {"ANTI_ALIAS_FLAG", "DEV_KERN_TEXT_FLAG", "DITHER_FLAG", "EMBEDDED_BITMAP_TEXT_FLAG", "FAKE_BOLD_TEXT_FLAG", "LINEAR_TEXT_FLAG", "SUBPIXEL_TEXT_FLAG", "STRIKE_THRU_TEXT_FLAG"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, flags);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        view1.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
                        break;
                    case 1:
                        view1.setPaintFlags(Paint.DEV_KERN_TEXT_FLAG);
                        break;
                    case 2:
                        view1.setPaintFlags(Paint.DITHER_FLAG);
                        break;
                    case 3:
                        view1.setPaintFlags(Paint.EMBEDDED_BITMAP_TEXT_FLAG);
                        break;
                    case 4:
                        view1.setPaintFlags(Paint.FAKE_BOLD_TEXT_FLAG);
                        break;
                    case 5:
                        view1.setPaintFlags(Paint.LINEAR_TEXT_FLAG);
                        break;
                    case 6:
                        view1.setPaintFlags(Paint.SUBPIXEL_TEXT_FLAG);
                        break;
                    case 7:
                        view1.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
