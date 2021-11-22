package com.example.civiladvocacy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PhotoActivity extends AppCompatActivity {
    private static final String TAG = "PhotoActivity";


    private TextView photoLocationText;
    private TextView photoOfficeText;
    private TextView photoNameText;
    private ConstraintLayout photoLayout;


    private ImageView photoOfficialImage;
    private ImageView photoPartyLogoImage;
    private Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        photoLocationText = findViewById(R.id.photoLocationText);
        photoOfficeText = findViewById(R.id.photoOfficeText);
        photoNameText = findViewById(R.id.photoNameText);

        photoLayout = findViewById(R.id.photoLayout);

        Intent data = getIntent();
        String office = data.getStringExtra("OFFICE");
        String name = data.getStringExtra("NAME");
        String party = data.getStringExtra("PARTY");
        String location = data.getStringExtra("LOCATION");
        photoLocationText.setText(location);
        photoOfficeText.setText(office);
        photoNameText.setText(name);

        photoOfficialImage = findViewById(R.id.photoOfficialImage);
        photoPartyLogoImage = findViewById(R.id.photoPartyLogoImage);
        picasso = Picasso.get();

        if (party.equals("Democratic Party")) {
            photoPartyLogoImage.setImageResource(R.drawable.dem_logo);
            photoLayout.setBackgroundColor(Color.BLUE);
        } else if (party.equals("Republican Party")) {
            photoPartyLogoImage.setImageResource(R.drawable.rep_logo);
            photoLayout.setBackgroundColor(Color.RED);
        } else {
            photoPartyLogoImage.setVisibility(View.INVISIBLE);
            photoLayout.setBackgroundColor(Color.BLACK);
        }

        loadRemoteImage(data.getStringExtra("PHOTO"));
    }

    private void loadRemoteImage(String imageURL) {
        // Needs gradle  implementation 'com.squareup.picasso:picasso:2.71828'

        long millisS = System.currentTimeMillis();

        picasso.load(imageURL)
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.missing)
                .into(photoOfficialImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        long millisE = System.currentTimeMillis();
                        Log.d(TAG, "loadRemoteImage: Duration: " +
                                (millisE-millisS) + " ms");
                    }

                    @Override
                    public void onError(Exception e) {
                        long millisE = System.currentTimeMillis();
                        Log.d(TAG, "loadRemoteImage: Duration: " +
                                (millisE-millisS) + " ms");
                    }
                });
    }


}
