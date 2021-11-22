package com.example.civiladvocacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private static final int LOCATION_REQUEST = 111;

    private final ArrayList<Official> officialList = new ArrayList<>();

    private RecyclerView recyclerView;
    private OfficialAdapter mAdapter;

    private FusedLocationProviderClient mFusedLocationClient;
    private static String locationString = "Unspecified Location";

    private TextView locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recycler View
        recyclerView = findViewById(R.id.recycler);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mAdapter = new OfficialAdapter(officialList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Location Info
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        determineLocation();

        locationText = findViewById(R.id.locationText);

        for (int i = 0; i < 10; i++) {
            Official joe = new Official("Joe Biden", "Democratic Party", "President of the United States");
            joe.setAddress("1234234");
            joe.setPhoneNumber("(324) 234-6789");
            joe.setWebsite("www.website.com");
            joe.setEmail("joe@gmail.com");
            joe.setFacebook("facebook");
            joe.setTwitter("twitter");
            joe.setYoutube("youtube");
            officialList.add(joe);
            officialList.add(new Official("Donald Trump", "Republican Party", "President of the United States"));
        }

//        CivicRunnable civicRunnable = new CivicRunnable(this);
//        new Thread(civicRunnable).start();
    }

    // Official clicked
    @Override
    public void onClick(View v) {
        int pos = recyclerView.getChildLayoutPosition(v);
        Official o = officialList.get(pos);

        Intent data = new Intent(MainActivity.this, OfficialActivity.class);
        data.putExtra("OFFICE", o.getOffice());
        data.putExtra("NAME", o.getName());
        data.putExtra("PARTY", o.getParty());
        data.putExtra("LOCATION", locationString);
        data.putExtra("PHOTO", o.getPhoto());
        data.putExtra("ADDRESS", o.getAddress());
        data.putExtra("PHONE", o.getPhoneNumber());
        data.putExtra("EMAIL", o.getEmail());
        data.putExtra("WEBSITE", o.getWebsite());
        data.putExtra("FACEBOOK", o.getFacebook());
        data.putExtra("TWITTER", o.getTwitter());
        data.putExtra("YOUTUBE", o.getYoutube());

        setResult(RESULT_OK, data);
        startActivity(data);
    }

    // Option Menu Methods
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.aboutMenuItem:
                Intent intent1 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent1);
                break;

            case R.id.searchMenuItem:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Enter a City, State, or a Zip Code");
                final EditText input = new EditText(this);
                input.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

                break;


        }
        return true;
    }

    // Handle Location
    private void determineLocation() {
        if (checkPermission()) {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        // Got last known location. In some situations this can be null.
                        if (location != null) {
                            locationString = getPlace(location);
                            locationText.setText(locationString);
                        }
                    })
                    .addOnFailureListener(this, e -> Toast.makeText(MainActivity.this,
                            e.getMessage(), Toast.LENGTH_LONG).show());
        }
    }

    public String determineZip() {
        AtomicReference<String> zipStr = new AtomicReference<>("");
        if (checkPermission()) {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        if (location != null) {
                            zipStr.set(getZip(location));
                            locationText.setText(locationString);
                        }
                    })
                    .addOnFailureListener(this, e -> Toast.makeText(MainActivity.this,
                            e.getMessage(), Toast.LENGTH_LONG).show());
        }
        return zipStr.get();
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, LOCATION_REQUEST);
            return false;
        }
        return true;
    }

    private String getZip(Location loc) {
        StringBuilder sb = new StringBuilder();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;

        try {
            addresses = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
            String zip = addresses.get(0).getPostalCode();

            sb.append(zip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    private String getPlace(Location loc) {

        StringBuilder sb = new StringBuilder();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;

        try {
            addresses = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String zip = addresses.get(0).getPostalCode();

            sb.append(String.format(
                    Locale.getDefault(),
                    "%s, %s %s",
                    city, state, zip));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_REQUEST) {
            if (permissions[0].equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    determineLocation();
                } else {
                    Toast.makeText(this, locationString, Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    // Handle Json
    public void updateData(ArrayList<Official> cList) {
        officialList.addAll(cList);
        mAdapter.notifyItemRangeChanged(0, cList.size());
    }

    public void downloadFailed() {
        officialList.clear();
        mAdapter.notifyItemRangeChanged(0, officialList.size());
    }

    public void loadOfficials(ArrayList<Official> listOfSymbols) { officialList.addAll(listOfSymbols); }

}