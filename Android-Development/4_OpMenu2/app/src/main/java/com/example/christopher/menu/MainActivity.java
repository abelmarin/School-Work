package com.example.christopher.menu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuA) {
            Toast.makeText(this, "You want to do A", Toast.LENGTH_SHORT).show();
            textView.setText(R.string.a);
            return true;
        } else if (item.getItemId() == R.id.menuB) {
            Toast.makeText(this, "You have chosen B", Toast.LENGTH_SHORT).show();
            textView.setText(R.string.b);
            return true;
        } else if (item.getItemId() == R.id.menuC) {
            Toast.makeText(this, "C is your selection", Toast.LENGTH_SHORT).show();
            textView.setText(R.string.c);
            return true;
        } else if (item.getItemId() == R.id.menuD) {
            Toast.makeText(this, "D is your selection", Toast.LENGTH_SHORT).show();
            textView.setText(R.string.d);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


}
