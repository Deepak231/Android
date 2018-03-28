package com.example.mahe.grid_view_use;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String ccomp[] = {"tesla","jaguar","bmw","audi","nissan","mitubushi"};

        GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,ccomp[i],Toast.LENGTH_SHORT).show();
            }
        });
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
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
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
