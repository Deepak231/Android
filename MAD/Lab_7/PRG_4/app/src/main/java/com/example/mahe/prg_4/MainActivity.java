package com.example.mahe.prg_4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

import static android.R.attr.end;

public class MainActivity extends Activity {

    TextView textview; String result; String fulltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        registerForContextMenu(button);
        textview = (TextView) this.findViewById(R.id.textView);
        fulltext = textview.getText().toString();
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(fulltext);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                LayoutInflater li = getLayoutInflater();
                View view = li.inflate(R.layout.activity_search, null);

                final AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(MainActivity.this);
                alertdialogbuilder.setView(view);

                final EditText editText = (EditText) view.findViewById(R.id.editText);

                alertdialogbuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int flag = 0;
                        result = editText.getText().toString();
                        String strArray[] = fulltext.split(" ");
                        SpannableStringBuilder sorted = new SpannableStringBuilder("");
                        for (int j = 0; j < strArray.length; j++) {
                            SpannableString store = new SpannableString(strArray[j]);
                           if(strArray[j].equals(result)) {
                                store.setSpan(new BackgroundColorSpan(Color.parseColor("yellow")),
                                        0,strArray[j].length(),0);
                               flag = 1;

                            }
                            sorted.append(store);
                            sorted.append(" ");
                        }
                        textview.setText(sorted);
                        if(flag == 0)
                            Toast.makeText(MainActivity.this, "Not present", Toast.LENGTH_SHORT).show();

                    }
                })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });


                AlertDialog alertDialog = alertdialogbuilder.create();
                alertDialog.show();
                return true;

            case R.id.sort:
                String strArray[] = fulltext.split(" ");
                Arrays.sort(strArray);
                String sorted = "";
                for (int i = 0; i < strArray.length; i++) {
                    sorted = sorted + strArray[i] + " ";
                }
                textview.setText(sorted);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
