package com.example.mahe.prg_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    int mode; Integer[] states = {R.drawable.ringing,R.drawable.silent};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setText("Current Profile");
        toggleButton.setTextOff("Current Profile");
        toggleButton.setTextOn("Current Profile");

        mode = 0;
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()) {
                    mode = 0;
                    Toast.makeText(getApplicationContext(),"Ringing",Toast.LENGTH_SHORT).show();
                } else {
                    mode = 1;
                    Toast.makeText(getApplicationContext(),"Silent",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast to = new Toast(getApplicationContext());
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setImageResource(states[mode]);
                to.setView(imageView);
                to.setDuration(Toast.LENGTH_SHORT);
                to.show();
            }
        });
    }
}
