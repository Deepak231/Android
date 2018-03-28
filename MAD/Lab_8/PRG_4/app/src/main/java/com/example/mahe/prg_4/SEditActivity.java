package com.example.mahe.prg_4;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SEditActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sedit);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("students",MODE_PRIVATE,null);

        final EditText editText1 = (EditText) findViewById(R.id.sid_edit1);
        final EditText editText2 = (EditText) findViewById(R.id.sname_edit1);
        final EditText editText3 = (EditText) findViewById(R.id.sem_edit1);
        final EditText editText4 = (EditText) findViewById(R.id.branch_edit1);
        final EditText editText5 = (EditText) findViewById(R.id.faculty_edit1);

        Button button = (Button) findViewById(R.id.submit_1);
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

                    mydatabase.execSQL("UPDATE students SET sname = '"+ sname +"',sem = "+sem+"," +
                            "branch = '"+ branch +"',faculty = '"+ faculty  +"' WHERE" +
                            " sid = "+ sid );
                } catch (Exception e) {
                    Toast.makeText(SEditActivity.this,"update error ",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
                if(flag == 0)
                    Toast.makeText(SEditActivity.this," student data is updated ",Toast.LENGTH_SHORT).show();
                mydatabase.close();

            }
        });
    }
}
