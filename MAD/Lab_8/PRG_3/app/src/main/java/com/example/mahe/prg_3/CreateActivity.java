package com.example.mahe.prg_3;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("movies",MODE_PRIVATE,null);

        final EditText editText1 = (EditText) findViewById(R.id.uname_edit);
        final EditText editText2 = (EditText) findViewById(R.id.mname_edit);
        final EditText editText3 = (EditText) findViewById(R.id.year_edit);
        final EditText editText4 = (EditText) findViewById(R.id.points_edit);

        Button button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = editText1.getText().toString();
                String mname = editText2.getText().toString();
                String year = editText3.getText().toString();
                String points = editText4.getText().toString();

                int flag = 0;

                try {

                    mydatabase.execSQL("INSERT INTO movies(uname,mname,year,points) " +
                            "VALUES('" + uname + "','"+ mname + "'," + year + "," + points + ")");
                } catch (Exception e) {
                    Toast.makeText(CreateActivity.this,"you have already reviewed the entered movie",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
                if(flag == 0)
                    Toast.makeText(CreateActivity.this," review has been recorded  ",Toast.LENGTH_SHORT).show();
                mydatabase.close();

            }
        });
    }
}
