package com.example.student.url_web;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text_val = (EditText) findViewById(R.id.editText);
                String text_str = text_val.getText().toString();
                try {
                    String query = URLEncoder.encode(text_str,"utf-8");
                    String url_val = "https://www.google.com/search?q="+query;
                    Uri uri_val = Uri.parse(url_val);
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri_val);
                    startActivity(intent);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
