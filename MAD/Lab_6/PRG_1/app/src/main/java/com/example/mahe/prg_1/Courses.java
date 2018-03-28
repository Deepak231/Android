package com.example.mahe.prg_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Courses extends Activity {

    String[] values = { "Course1","Course2","Course3","Course4","Course5","Course6"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ListView list = (ListView) this.findViewById(R.id.listview2);
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
                Intent intent1 = new Intent(Courses.this, MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.admission:
                Intent intent2 = new Intent(Courses.this, Admission.class);
                startActivity(intent2);
                return true;
            case R.id.faculty:
                Intent intent3 = new Intent(Courses.this, Faculty.class);
                startActivity(intent3);
                return true;
            case R.id.contact:
                Intent intent4 = new Intent(Courses.this, ContactUs.class);
                startActivity(intent4);
                return true;
            case R.id.about:
                Intent intent5 = new Intent(Courses.this, AboutUs.class);
                startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
