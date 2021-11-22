package com.christopherhield.alarmserviceexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView message = findViewById(R.id.message);

        if (getIntent().hasExtra("DATA"))
            message.setText(
                    String.format("%s%s", getString(R.string.back), getIntent().getStringExtra("DATA")));
        else
            message.setText(R.string.first);
    }


    public void setupRestart(View v) {

        String secondsText = ((EditText) findViewById(R.id.editText)).getText().toString();
        if (secondsText.isEmpty()) {
            Toast.makeText(MainActivity.this, "You must enter a number of seconds!", Toast.LENGTH_SHORT).show();
            return;
        }
        int seconds = Integer.parseInt(secondsText);


        Intent intentToExecute = // Specify the receiver
                new Intent(MainActivity.this, OnAlarmReceive.class);

        intentToExecute.putExtra("DATA", "I was gone for " + seconds + " seconds."); // Add some data

        // Make a PendingIntent that will perform a broadcast upon execution
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                MainActivity.this, 0, intentToExecute,
                PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);
        // FLAG_UPDATE_CURRENT = Flag indicating that if the described PendingIntent already exists,
        // then keep it but replace its extra data with what is in this new Intent.


        Calendar cal = Calendar.getInstance(); // Current time/date
        cal.add(Calendar.SECOND, seconds); // Add the specified seconds to the current time/date

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        if (am == null) {
            Toast.makeText(this, "No Alarm Service available", Toast.LENGTH_SHORT).show();
            return;
        }

        // Setup the "alarm" using RTC, the time for execution, and the pending intent holding the action to perform.
        am.set(AlarmManager.RTC, cal.getTimeInMillis(), pendingIntent); // RTC = Real Time Clock

        Toast.makeText(MainActivity.this, "See you in " + seconds + " seconds!", Toast.LENGTH_LONG).show();

        finish();
    }

    ///////////////

    public static class OnAlarmReceive extends BroadcastReceiver {

        private static final String TAG = "OnAlarmReceive";

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "OnAlarmReceive onReceive called!");

            String msg = "";

            if (intent.hasExtra("DATA"))
                msg = intent.getStringExtra("DATA");

            // Start MainActivity
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("DATA", msg + "\nWhat did I miss?");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
