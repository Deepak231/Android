package com.example.mahe.prg_1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView list = (ListView) this.findViewById(R.id.listView1);

        ArrayList<dataset> array = new ArrayList<dataset>();

        dataset img1 = new dataset( "Android 1.6",R.drawable.donut);
        dataset img2 = new dataset( "Android 2.0",R.drawable.eclair);
        dataset img3 = new dataset( "Android 2.2",R.drawable.froyo);
        dataset img4 = new dataset( "Android 2.3",R.drawable.gingerbread);
        dataset img5 = new dataset( "Android 3.0",R.drawable.honeycomb);
        


        array.add(img1);
        array.add(img2);
        array.add(img3);
        array.add(img4);
        array.add(img5);

        customAdapter adapter = new customAdapter(this, array);
        list.setAdapter(adapter);


    }

    public class dataset{
        public String name;
        public Integer img;
        public dataset(String name, Integer img) {
            this.name = name;
            this.img = img;
        }
    }

    public class customAdapter extends ArrayAdapter<dataset> {

        private Activity context;
        public customAdapter(Activity context,ArrayList<dataset> ds) {
            super(context, R.layout.activity_image_text, ds);
            this.context = context;
        }

        public View getView (int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View view1 = inflater.inflate(R.layout.activity_image_text,null,true);

            dataset ds = getItem(position);

            TextView text = (TextView) view1.findViewById(R.id.textView);
            ImageView img = (ImageView) view1.findViewById(R.id.imageView);

            text.setText(ds.name);
            img.setImageResource(ds.img);

            return view1;
        }
    }
}
