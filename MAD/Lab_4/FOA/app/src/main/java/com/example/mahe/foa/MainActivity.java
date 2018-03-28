package com.example.mahe.foa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    String[] values = { "Britannia Cake","Lays","Bingo","Treat","Hide n Seek","Oreo","Dark Fantasy","Bread","Jim Jam"};
    Integer[] price = {30,10,10,20,25,20,25,30,20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listView1);
        final CustomAdapter cust = new CustomAdapter(this,values);
        listView.setAdapter(cust);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = listView.getCount();
                String res = ""; int sum = 0;int i;
                for( i=0; i< count;i++) {
                    LinearLayout linearLayout = (LinearLayout) listView.getChildAt(i);
                    CheckBox chkbox = (CheckBox) linearLayout.getChildAt(0);
                    if(chkbox.isChecked()) {
                        res += " "+values[i]+" Rs."+price[i]+" \n";
                        sum = sum + price[i];
                    }
                }
                res += " Total: "+sum + " \n";
                Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
                for ( i=0;i<count;i++) {
                    LinearLayout linearLayout = (LinearLayout) listView.getChildAt(i);
                    CheckBox chkbox = (CheckBox) linearLayout.getChildAt(0);
                    chkbox.setEnabled(false);
                }

            }
        });
    }

    public class CustomAdapter extends ArrayAdapter<String> {

        public Activity context;
        public CustomAdapter(Activity context, String[] name) {
            super(context, R.layout.activity_checkbox,name);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View view = inflater.inflate(R.layout.activity_checkbox,null,true);
            String array = getItem(position);
            CheckBox chkbox = (CheckBox) view.findViewById(R.id.checkBox);
            chkbox.setText(array);
            return view;
        }
    }
}
