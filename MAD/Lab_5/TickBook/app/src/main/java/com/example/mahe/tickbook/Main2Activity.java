package com.example.mahe.tickbook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ToggleButton toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        toggleButton2.setText("General");
        toggleButton2.setTextOff("General");
        toggleButton2.setTextOn("TatKal");

        Bundle bundle = getIntent().getExtras();
        final String source = bundle.getString("Source");
        final String dest = bundle.getString("Dest");
        final String toggle = bundle.getString("Toggle");
        final String date = bundle.getString("Date");
        final String time = bundle.getString("Time");

        TextView text1 = (TextView) findViewById(R.id.textView7);
        TextView text2 = (TextView) findViewById(R.id.textView8);
        TextView text3 = (TextView) findViewById(R.id.textView9);
        TextView text4 = (TextView) findViewById(R.id.textView10);
        TextView text5 = (TextView) findViewById(R.id.textView11);

        text1.setText(source);
        text2.setText(dest);
        text3.setText(toggle);
        text4.setText(date);
        text5.setText(time);

    }
}
