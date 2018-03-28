package com.example.mahe.prg_1;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("mycontacts",MODE_PRIVATE,null);

        final EditText editText1 = (EditText) findViewById(R.id.name_edit1);
        final EditText editText2 = (EditText) findViewById(R.id.phone_edit1);
        final EditText editText3 = (EditText) findViewById(R.id.email_edit1);

        Button button = (Button) findViewById(R.id.submit_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                String phone = editText2.getText().toString();
                String email = editText3.getText().toString();

                int flag = 0;

                try {

                    mydatabase.execSQL("UPDATE contacts SET username = '"+ name +"',email = '"+email+"' WHERE" +
                            " phone = "+ phone );
                } catch (Exception e) {
                    Toast.makeText(EditContactActivity.this,"update error ",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
                if(flag == 0)
                    Toast.makeText(EditContactActivity.this," user data is updated ",Toast.LENGTH_SHORT).show();
                mydatabase.close();

            }
        });
    }
}
