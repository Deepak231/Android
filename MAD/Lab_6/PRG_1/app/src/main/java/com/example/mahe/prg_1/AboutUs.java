package com.example.mahe.prg_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutUs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
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
                Intent intent1 = new Intent(AboutUs.this, MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.course:
                Intent intent2 = new Intent(AboutUs.this, Courses.class);
                startActivity(intent2);
                return true;
            case R.id.admission:
                Intent intent3 = new Intent(AboutUs.this, Admission.class);
                startActivity(intent3);
                return true;
            case R.id.faculty:
                Intent intent4 = new Intent(AboutUs.this, Faculty.class);
                startActivity(intent4);
                return true;
            case R.id.contact:
                Intent intent5 = new Intent(AboutUs.this, ContactUs.class);
                startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
