package com.example.mahe.prg_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends Activity {

    String contacts[] = {"Nidhesh","Karthik","Gururaj","Mohan","Harshith"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_textview,R.id.textView,contacts);
        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select an Option");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sim :
                makeText(MainActivity.this,"Save in Sim1/Sim2 is Selected", LENGTH_SHORT).show();
                return true;
            case R.id.message:
                makeText(MainActivity.this,"Call/Message selected", LENGTH_SHORT).show();
                return true;
            case R.id.whatsapp_gmail:
                makeText(MainActivity.this,"Whatsapp/Gmail is selected", LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}
