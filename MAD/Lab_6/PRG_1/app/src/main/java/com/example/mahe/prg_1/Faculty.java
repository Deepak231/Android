package com.example.mahe.prg_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Faculty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        final String ccomp[] = {"tesla","jaguar","bmw","audi","nissan","mitubushi"};

        GridView gridView = (GridView) findViewById(R.id.gridview1);
        gridView.setAdapter(new ImageAdapter(this));

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
                Intent intent1 = new Intent(Faculty.this, MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.course:
                Intent intent2 = new Intent(Faculty.this, Courses.class);
                startActivity(intent2);
                return true;
            case R.id.admission:
                Intent intent3 = new Intent(Faculty.this, Admission.class);
                startActivity(intent3);
                return true;
            case R.id.contact:
                Intent intent4 = new Intent(Faculty.this, ContactUs.class);
                startActivity(intent4);
                return true;
            case R.id.about:
                Intent intent5 = new Intent(Faculty.this, AboutUs.class);
                startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public class ImageAdapter extends BaseAdapter {
        private Context cont;
        public ImageAdapter(Context co) {
            cont = co;
        }

        @Override
        public int getCount() {
            return logo.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView iv;
            if(view == null)
            {
                iv = new ImageView(cont);
                iv.setLayoutParams(new GridView.LayoutParams(400,400));
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv.setPadding(30 ,30,30,30);
            }
            else
            {
                iv = (ImageView)view;
            }
            iv.setImageResource(logo[i]);
            return iv;
        }
        private  Integer[] logo = {
                R.drawable.tesla,
                R.drawable.jaguar,
                R.drawable.bmw,
                R.drawable.audi,
                R.drawable.nissan,
                R.drawable.mitubushi
        };
    }
}
