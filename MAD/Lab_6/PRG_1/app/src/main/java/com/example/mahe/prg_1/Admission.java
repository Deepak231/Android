package com.example.mahe.prg_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Admission extends Activity {

    String[] values = { "Step1","Step2","Step3","Step4","Step5","Step6"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        ListView list = (ListView) this.findViewById(R.id.listview1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_textview,R.id.textView101,values);
        list.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent1 = new Intent(Admission.this, MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.course:
                Intent intent2 = new Intent(Admission.this, Courses.class);
                startActivity(intent2);
                return true;
            case R.id.faculty:
                Intent intent3 = new Intent(Admission.this, Faculty.class);
                startActivity(intent3);
                return true;
            case R.id.contact:
                Intent intent4 = new Intent(Admission.this, ContactUs.class);
                startActivity(intent4);
                return true;
            case R.id.about:
                Intent intent5 = new Intent(Admission.this, AboutUs.class);
                startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
