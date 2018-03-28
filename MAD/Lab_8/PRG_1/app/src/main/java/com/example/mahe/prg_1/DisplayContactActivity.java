package com.example.mahe.prg_1;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("mycontacts",MODE_PRIVATE,null);

        TextView textView = (TextView) findViewById(R.id.display);
        String store = "";
        Cursor result = mydatabase.rawQuery("SELECT * from contacts",null);
        if(result.moveToFirst()) {
            do {
                String name = result.getString(0);
                String phone = result.getString(1);
                String email = result.getString(2);
                store = store + name + " " + phone + " " + email + "\n\n\n";

            } while (result.moveToNext());
        }

        textView.setText(store);

        result.close();
        mydatabase.close();
    }
}
