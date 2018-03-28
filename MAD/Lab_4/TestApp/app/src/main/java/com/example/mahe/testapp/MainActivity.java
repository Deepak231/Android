package com.example.mahe.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    public Toast disptoast(Integer res) {
        Toast toast = new Toast(getApplicationContext());
        ImageView view = new ImageView(getApplicationContext());
        view.setImageResource(res);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        return toast;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        final ToggleButton tbutton = (ToggleButton) findViewById(R.id.toggleButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disptoast(R.drawable.power).show();
            }
        });
        tbutton.setText("Pause");
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tbutton.isChecked()) {
                    disptoast(R.drawable.pause).show();
                    tbutton.setText("Play");
                } else {
                    disptoast(R.drawable.play).show();
                    tbutton.setText("Pause");
                }
            }
        });


    }
}
