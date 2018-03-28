package com.example.mahe.prg_3;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DetailsActivity extends Activity {

    private TextView getTextView(int id, String title) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextSize(18);
        tv.setTextColor(Color.parseColor("#FFFFFF"));
        tv.setBackgroundColor(Color.parseColor("#000000"));
        tv.setPadding(40, 40, 40, 40);
        tv.setLayoutParams(getLayoutParams());
        return tv;
    }

    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }

    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        String uname = bundle.getString("uname");

        final SQLiteDatabase mydatabase = openOrCreateDatabase("movies",MODE_PRIVATE,null);

        TableLayout tl = findViewById(R.id.tableLayout1);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "MNAME"));
        tr.addView(getTextView(0, "YEAR"));
        tr.addView(getTextView(0, "POINTS"));
        tl.addView(tr, getTblLayoutParams());

        int i = 1;
        Cursor result = mydatabase.rawQuery("SELECT * from movies WHERE uname = '"+uname+"'",null);
        if(result.moveToFirst()) {
            do {
                String mname = result.getString(1);
                String year = result.getString(2);
                String points = result.getString(3);
                TableRow tr1 = new TableRow(this);
                tr1.setLayoutParams(getLayoutParams());
                tr1.addView(getTextView(i,mname ));
                tr1.addView(getTextView(i,year));
                tr1.addView(getTextView(i,points));
                tl.addView(tr1, getTblLayoutParams());
                i++;

            } while (result.moveToNext());
        }

    }
}
