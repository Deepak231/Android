package com.example.mahe.vehparkreg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] type = {"Car", "Bike", "Scooter" , "Bus" , "Truck"};
        final Spinner spinner = (Spinner) this.findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,type);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        final EditText editText1 = (EditText) this.findViewById(R.id.editText);
        final EditText editText2 = (EditText) this.findViewById(R.id.editText2);

        Button button1 = (Button) this.findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);

                intent.putExtra("Type",spinner.getSelectedItem().toString());
                intent.putExtra("Vehicle No",editText1.getText().toString());
                intent.putExtra("RC No.",editText2.getText().toString());

                startActivity(intent);


            }
        });

    }
}
