package com.example.mahe.prg_4;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class SViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sview);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("students",MODE_PRIVATE,null);

        TextView textView = (TextView) findViewById(R.id.view);
        String store = "";
        Cursor result = mydatabase.rawQuery("SELECT * from students",null);
        if(result.moveToFirst()) {
            do {
                String sid = result.getString(0);
                String sname = result.getString(1);
                String sem = result.getString(2);
                String branch = result.getString(3);
                String faculty = result.getString(4);
                store = store + sid + " " + sname + " " + sem + " " + branch + " " + faculty + "\n\n\n";

            } while (result.moveToNext());
        }

        textView.setText(store);

        result.close();
        mydatabase.close();
    }
}
