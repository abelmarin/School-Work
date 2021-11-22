package com.christopherhield.radiobutton_toast;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView actionDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionDisplay = findViewById(R.id.actionDisplay);
    }

    public void radioClicked(View v) {
        String message = "Group 1: You Selected ";
        if (v.getId() == R.id.androidButton) {
            message += "Android";
        } else if (v.getId() == R.id.iosButton) {
            message += "iOS";
        } else if (v.getId() == R.id.windowsButton) {
            message += "Windows";
        }
        actionDisplay.setText(message);
    }

    public void radioClicked2(View v) {
        String message = "Group 2: You Selected ";
        if (v.getId() == R.id.uberButton) {
            message += "Uber";
        } else if (v.getId() == R.id.lyftButton) {
            message += "Lyft";
        } else if (v.getId() == R.id.taxiButton) {
            message += "Taxi";
        }

        actionDisplay.setText(message);
    }

}
