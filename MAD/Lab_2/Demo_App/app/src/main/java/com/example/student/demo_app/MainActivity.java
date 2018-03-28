package com.example.student.demo_app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_val = (Button) findViewById(R.id.button);
        button_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text_col = (TextView) findViewById(R.id.textView);
                text_col.setBackgroundColor(Color.parseColor("#aaaaaa"));

            }
        });
    }
}
