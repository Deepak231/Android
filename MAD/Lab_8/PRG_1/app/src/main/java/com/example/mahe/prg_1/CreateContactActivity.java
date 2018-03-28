package com.example.mahe.prg_1;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("mycontacts",MODE_PRIVATE,null);

        final EditText editText1 = (EditText) findViewById(R.id.name_edit);
        final EditText editText2 = (EditText) findViewById(R.id.phone_edit);
        final EditText editText3 = (EditText) findViewById(R.id.email_edit);

        Button button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                String phone = editText2.getText().toString();
                String email = editText3.getText().toString();

                int flag = 0;

                try {

                    mydatabase.execSQL("INSERT INTO contacts(username,phone,email) " +
                            "VALUES('" + name + "'," + phone + ",'" + email + "')");
                } catch (Exception e) {
                    Toast.makeText(CreateContactActivity.this,"user with the entered phone " +
                            "already exist",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
                if(flag == 0)
                    Toast.makeText(CreateContactActivity.this," user is entered ",Toast.LENGTH_SHORT).show();
                mydatabase.close();

            }
        });

    }
}
