package com.example.mahe.prg_2;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class StoreActivity extends Activity {

    String item_name[] = {"PC","MAC","XBOX","Nintendo switch","PS3"};
    Integer item_cost[] = {60000,75000,25000,35000,15000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("mygrocery",MODE_PRIVATE,null);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button add = (Button) findViewById(R.id.add);

        int len = item_name.length;
        String items[] = new String[len];

        for (int i = 0 ; i < len ; i++) {
            items[i] = item_name[i] + " " + item_cost[i].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spinner.getSelectedItemPosition();
                int flag = 0;

                try {

                    mydatabase.execSQL("INSERT INTO mygrocery(item_name,item_cost) " +
                            "VALUES('" + item_name[pos] + "'," + item_cost[pos] + ")");
                } catch (Exception e) {
                    Toast.makeText(StoreActivity.this, "item already present",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
                if(flag == 0)
                    Toast.makeText(StoreActivity.this," item inserted ",Toast.LENGTH_SHORT).show();
                mydatabase.close();
            }
        });

    }
}
