package com.example.mahe.tickbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends Activity {

    String places[] = {"Select Place","Mangalore","Bangalore","Mumbai","Pune","Chennai","Hyderabad"};

    int myear,mmonth,mday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,places);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);

        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setText("To-Fro");
        toggleButton.setTextOff("To-Fro");
        toggleButton.setTextOn("One-Way");

        final EditText text = (EditText) findViewById(R.id.editText);
        final Calendar calender = Calendar.getInstance();

        String myFormat = "dd/MM/yyyy";
        final SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        text.setText(sdf.format(calender.getTime()));

        final DatePickerDialog.OnDateSetListener date = new OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calender.set(Calendar.YEAR, year);
                calender.set(Calendar.MONTH, month);
                calender.set(Calendar.DAY_OF_MONTH, day);
                text.setText(sdf.format(calender.getTime()));
            }


        };

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date, calender
                        .get(Calendar.YEAR), calender.get(Calendar.MONTH),
                        calender.get(Calendar.DAY_OF_MONTH)).show();
            }

        });

        final EditText text2 = (EditText) findViewById(R.id.editText2);

        String myFormat1 = "HH:mm";
        final SimpleDateFormat sdf1 = new SimpleDateFormat(myFormat1, Locale.US);
        text2.setText(sdf1.format(calender.getTime()));

        final TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                calender.set(Calendar.HOUR,hour);
                calender.set(Calendar.MINUTE,min);
                text2.setText(sdf1.format(calender.getTime()));
            }
        };

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(MainActivity.this,time,calender.get(Calendar.HOUR),
                        calender.get(Calendar.MINUTE),false).show();
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner1.setSelection(0);
                spinner2.setSelection(0);
                Calendar calender1 = Calendar.getInstance();
                text.setText(sdf.format(calender1.getTime()));
                text2.setText(sdf1.format(calender1.getTime()));
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinner1.getSelectedItem().equals(places[0]) || spinner2.getSelectedItem().equals(places[0])) {
                    Toast.makeText(getApplicationContext(),"Enter all Fields",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);

                    intent.putExtra("Source", spinner1.getSelectedItem().toString());
                    intent.putExtra("Dest", spinner2.getSelectedItem().toString());
                    intent.putExtra("Date", text.getText().toString());
                    intent.putExtra("Time", text2.getText().toString());
                    intent.putExtra("Toggle", toggleButton.getText().toString());


                    startActivity(intent);
                }
            }
        });

    }



}
