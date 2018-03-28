package com.example.mahe.prg_3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    String name[] = {"Android 1.6","Android 2.0","Android 2.2","Android 2.3","Android 3.0"};
    Integer img[] = {R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<dataset> arrayList = new ArrayList<dataset>();

        for(int i=0; i< name.length;i++) {
            dataset ds = new dataset(name[i],img[i]);
            arrayList.add(ds);
        }

        customAdapter cust = new customAdapter(this,arrayList);

        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(cust);
    }

    public class dataset {
        public String name;
        public Integer img;
        public dataset(String name,Integer img) {
            this.name = name;
            this.img = img;
        }

    }

    public class customAdapter extends ArrayAdapter<dataset> {

        public Activity context;

        public customAdapter(Activity context, ArrayList<dataset> ds) {
            super(context, R.layout.activity_button,ds);
            this.context = context;
        }

        @Override
        public View getView(int position, final View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View view = inflater.inflate(R.layout.activity_button,null,true);

            final dataset ds = getItem(position);

            Button button = (Button) view.findViewById(R.id.button1);

            button.setText(ds.name);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast to = new Toast(context);

                    TextView textView = new TextView(context);
                    textView.setText(ds.name);
                    textView.setBackground(getDrawable(ds.img));
                    to.setDuration(Toast.LENGTH_SHORT);

                    to.setView(textView);
                    to.show();
                }
            });

            return view;
        }
    }
}
