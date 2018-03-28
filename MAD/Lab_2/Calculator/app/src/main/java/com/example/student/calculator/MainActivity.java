package com.example.student.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text_val = (TextView) findViewById(R.id.textView);
        Button button_0 = (Button) findViewById(R.id.button0);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "0");
            }
        });
        Button button_1 = (Button) findViewById(R.id.button1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "1");
            }
        });
        Button button_2 = (Button) findViewById(R.id.button2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "2");
            }
        });
        Button button_3 = (Button) findViewById(R.id.button3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "3");
            }
        });
        Button button_4 = (Button) findViewById(R.id.button4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "4");
            }
        });
        Button button_5 = (Button) findViewById(R.id.button5);
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "5");
            }
        });
        Button button_6 = (Button) findViewById(R.id.button6);
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "6");
            }
        });
        Button button_7 = (Button) findViewById(R.id.button7);
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "7");
            }
        });
        Button button_8 = (Button) findViewById(R.id.button8);
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "8");
            }
        });
        Button button_9 = (Button) findViewById(R.id.button9);
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "9");
            }
        });
        Button button_10 = (Button) findViewById(R.id.button10);
        button_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_val.setText("");
            }
        });
        Button button_11 = (Button) findViewById(R.id.button11);
        button_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "+");
            }
        });
        Button button_12 = (Button) findViewById(R.id.button12);
        button_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "-");
            }
        });
        Button button_13 = (Button) findViewById(R.id.button13);
        button_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "*");
            }
        });
        Button button_14 = (Button) findViewById(R.id.button14);
        button_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_val.getText().toString();
                text_val.setText(text + "/");
            }
        });



        Button button_15 = (Button) findViewById(R.id.button15);
        button_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String text = text_val.getText().toString();
                    int x = -1;
                    int len = text.length();
                    float res = 0,val1,val2;
                    try {
                        if (((x = text.indexOf('+')) > -1) || ((x = text.indexOf('-')) > -1) || ((x = text.indexOf('*')) > -1) || ((x = text.indexOf('/')) > -1)) {
                            if (x != 0)
                                val1 = Integer.parseInt(text.substring(0, x));
                            else
                                val1 = 0;
                            char op = text.charAt(x);
                            val2 = Integer.parseInt(text.substring(x + 1, len));
                            if (op == '+')
                                res = val1 + val2;
                            else if (op == '-')
                                res = val1 - val2;
                            else if (op == '*')
                                res = val1 * val2;
                            else
                                res = val1 / val2;
                            text_val.setText(String.valueOf(val1) + " " + " " + String.valueOf(op) + " "+String.valueOf(val2) + " " + " = "+String.valueOf(res));
                        } else {
                            res = Float.parseFloat(text);
                            text_val.setText(String.valueOf(res));
                        }
                    } catch (Exception e) {
                        text_val.setText("ERROR");
                    }

            }
        });
    }

}
