package com.example.mahe.prg_4;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdetail);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("students",MODE_PRIVATE,null);

        final EditText editText1 = (EditText) findViewById(R.id.sid_edit);
        final EditText editText2 = (EditText) findViewById(R.id.sname_edit);
        final EditText editText3 = (EditText) findViewById(R.id.sem_edit);
        final EditText editText4 = (EditText) findViewById(R.id.branch_edit);
        final EditText editText5 = (EditText) findViewById(R.id.faculty_edit);

        Button button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid = editText1.getText().toString();
                String sname = editText2.getText().toString();
                String sem = editText3.getText().toString();
                String branch = editText4.getText().toString();
                String faculty = editText5.getText().toString();

                int flag = 0;

                try {

                    mydatabase.execSQL("INSERT INTO students(sid,sname,sem,branch,faculty) " +
                            "VALUES(" + sid + ",'" + sname + "'," + sem + ",'" +
                                        branch + "','" + faculty + "')");
                } catch (Exception e) {
                    Toast.makeText(SDetailActivity.this,"student with the student id " +
                            "already exist",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
                if(flag == 0)
                    Toast.makeText(SDetailActivity.this," Success",Toast.LENGTH_SHORT).show();
                mydatabase.close();

            }
        });
    }
}
