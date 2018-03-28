package com.example.mahe.vehparkreg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        final String type = bundle.getString("Type");
        final String Vehno = bundle.getString("Vehicle No");
        final String rcno = bundle.getString("RC No.");

        TextView textView1 = (TextView) findViewById(R.id.textView7);
        TextView textView2 = (TextView) findViewById(R.id.textView8);
        TextView textView3 = (TextView) findViewById(R.id.textView9);

        textView1.setText(type);
        textView2.setText(Vehno);
        textView3.setText(rcno);

        Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this," Type :"+ type+
                        "\nVehicle no :" +Vehno +
                        "\nRC No : "+ rcno ,Toast.LENGTH_LONG).show();
            }
        });

    }
}
