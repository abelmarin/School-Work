package com.christopherhield.geocoder;

import android.location.Address;
import android.location.Geocoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

/*41.9484424, -87.6575214 Wrigley
  41.8788129, -87.6381175 Sears
  38.8892728, -77.0523647 Lincoln
  48.8606146, 2.3354553 Louvre
*/

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.textView)).setMovementMethod(new ScrollingMovementMethod());
    }

    public void doLatLon(View v) {
        new Thread(this::handleGetFromLocation).start();
    }

    private void handleGetFromLocation() {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses;

            String loc = ((EditText) findViewById(R.id.editText)).getText().toString();
            if (loc.trim().isEmpty()) {
                Toast.makeText(this, "Enter Lat & Lon coordinates first!", Toast.LENGTH_LONG).show();
                return;
            }
            String[] latLon = loc.split(",");
            double lat = Double.parseDouble(latLon[0]);
            double lon = Double.parseDouble(latLon[1]);

            addresses = geocoder.getFromLocation(lat, lon, 10);
            runOnUiThread(() -> displayAddresses(addresses));
            Log.d(TAG, "doLatLon: " + addresses.get(0));
        } catch (IOException e) {
            runOnUiThread(() -> Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show());
            e.printStackTrace();
        }
    }

    public void doLocationName(View v) {
        new Thread(this::handleGetFromLocationName).start();
    }

    public void handleGetFromLocationName() {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses;

            String loc = ((EditText) findViewById(R.id.editText)).getText().toString();
            addresses = geocoder.getFromLocationName(loc, 10);
            runOnUiThread(() -> displayAddresses(addresses));
        } catch (IOException e) {
            runOnUiThread(() -> Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show());
            e.printStackTrace();
        }
    }

    private void displayAddresses(List<Address> addresses) {
        StringBuilder sb = new StringBuilder();
        if (addresses.size() == 0) {
            ((TextView) findViewById(R.id.textView)).setText(R.string.nothing_found);
            return;
        }

        for (Address ad : addresses) {

            String a = String.format("%s %s %s %s %s %s",
                    (ad.getSubThoroughfare() == null ? "" : ad.getSubThoroughfare()),
                    (ad.getThoroughfare() == null ? "" : ad.getThoroughfare()),
                    (ad.getLocality() == null ? "" : ad.getLocality()),
                    (ad.getAdminArea() == null ? "" : ad.getAdminArea()),
                    (ad.getPostalCode() == null ? "" : ad.getPostalCode()),
                    (ad.getCountryName() == null ? "" : ad.getCountryName()));

            if (!a.trim().isEmpty())
                sb.append("* ").append(a.trim());

            sb.append("\n");
        }
        ((TextView) findViewById(R.id.textView)).setText(sb.toString());
    }
}
