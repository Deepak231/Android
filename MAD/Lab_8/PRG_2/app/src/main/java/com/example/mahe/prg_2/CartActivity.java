package com.example.mahe.prg_2;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class CartActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("mygrocery",MODE_PRIVATE,null);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);

        ArrayList<String> arrayList = new ArrayList<>();
        Cursor result = mydatabase.rawQuery("SELECT * from mygrocery",null);
        if(result.moveToFirst()) {
            do {
                String item_name = result.getString(0);
                String item_cost = result.getString(1);
                arrayList.add(item_name + " " + item_cost);

            } while (result.moveToNext());
        }
        String items[] = new String[arrayList.size()];
        for(int  i = 0 ; i < arrayList.size() ; i++) {
            items[i] = arrayList.get(i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        result.close();
        mydatabase.close();

    }
}
