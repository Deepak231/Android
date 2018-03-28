package com.example.mahe.prg_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.donut);
        registerForContextMenu(imageView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView textView = new TextView(getApplicationContext());
        Toast to = new Toast(getApplicationContext());
        switch (item.getItemId()) {
            case R.id.image1:
                textView.setBackground(getDrawable(R.drawable.eclair));
                to.setView(textView);
                to.setDuration(Toast.LENGTH_SHORT);
                to.show();
                return true;
            case R.id.image2:
                textView.setBackground(getDrawable(R.drawable.froyo));
                to.setView(textView);
                to.setDuration(Toast.LENGTH_SHORT);
                to.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
