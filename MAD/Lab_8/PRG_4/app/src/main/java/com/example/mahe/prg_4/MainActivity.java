package com.example.mahe.prg_4;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase mydatabase = openOrCreateDatabase("students",MODE_PRIVATE,null);

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS students(sid NUMERIC(10,0)," +
                "sname VARCHAR(10)," +
                "sem NUMERIC(2,0)," +
                "branch VARCHAR(10)," +
                "faculty VARCHAR(10)," +
                "primary key(sid));");

        mydatabase.close();

        Button button1 = (Button) findViewById(R.id.create);
        Button button2 = (Button) findViewById(R.id.view);
        Button button3 = (Button) findViewById(R.id.edit);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SDetailActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SViewActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SEditActivity.class);
                startActivity(intent);
            }
        });
    }
}
