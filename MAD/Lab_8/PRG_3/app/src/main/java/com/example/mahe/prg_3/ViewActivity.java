package com.example.mahe.prg_3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("movies",MODE_PRIVATE,null);
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor result = mydatabase.rawQuery("SELECT * from movies",null);
        if(result.moveToFirst()) {
            do {
                String name = result.getString(0);
                if(!arrayList.contains(name))
                    arrayList.add(name);

            } while (result.moveToNext());
        }

        final String store[] = new String[arrayList.size()];

        for (int i = 0 ; i < arrayList.size() ; i++) {
            store[i] = arrayList.get(i);
        }

        ListView listView = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.layout_textview,R.id.textView,store);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent(ViewActivity.this,DetailsActivity.class);
                intent.putExtra("uname",store[pos]);
                startActivity(intent);
            }
        });


    }
}
