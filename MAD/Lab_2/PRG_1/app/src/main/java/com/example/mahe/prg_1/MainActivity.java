package com.example.mahe.prg_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private final static String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag,"On Create....");
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SubActivity1.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag,"On Restart....");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag,"On Start....");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag,"On Pause....");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag,"On Resume....");
    }
}
