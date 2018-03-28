package com.example.student.toast_app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_val = (Button) findViewById(R.id.button);
        button_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit1 = (EditText) findViewById(R.id.editText);
                EditText edit2 = (EditText) findViewById(R.id.editText2);
                String name = edit1.getText().toString();
                String pass = edit2.getText().toString();
                Log.d("CREATION"," Username "+ name + " Password " + pass);
            }
        });
    }
}
