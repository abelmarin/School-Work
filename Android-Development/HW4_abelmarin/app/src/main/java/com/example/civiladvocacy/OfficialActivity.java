package com.example.civiladvocacy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class OfficialActivity extends AppCompatActivity {

    private static final String TAG = "OfficialActivity";

    private TextView officialLocationText;
    private TextView officialOfficeText;
    private TextView officialNameText;
    private TextView officialPartyText;

    private TextView addressText;
    private TextView phoneText;
    private TextView emailText;
    private TextView websiteText;

    private ImageView facebookImage;
    private ImageView twitterImage;
    private ImageView youtubeImage;

    private ImageView officialImage;
    private ImageView partyLogoImage;
    private Picasso picasso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official);

        officialLocationText = findViewById(R.id.officialLocationText);
        officialOfficeText = findViewById(R.id.officialOfficeText);
        officialNameText = findViewById(R.id.officialNameText);
        officialPartyText = findViewById(R.id.officialPartyText);

        addressText = findViewById(R.id.addressText);
        phoneText = findViewById(R.id.phoneText);
        emailText = findViewById(R.id.emailText);
        websiteText = findViewById(R.id.websiteText);

        facebookImage = findViewById(R.id.facebookImage);
        twitterImage = findViewById(R.id.twitterImage);
        youtubeImage = findViewById(R.id.youtubeImage);

        Intent data = getIntent();
        String office = data.getStringExtra("OFFICE");
        String name = data.getStringExtra("NAME");
        String party = data.getStringExtra("PARTY");
        String location = data.getStringExtra("LOCATION");
        officialLocationText.setText(location);
        officialOfficeText.setText(office);
        officialNameText.setText(name);
        officialPartyText.setText(party);

        officialImage = findViewById(R.id.officialImage);
        partyLogoImage = findViewById(R.id.partyLogoImage);
        picasso = Picasso.get();

        if (party.equals("Democratic Party")) {
            partyLogoImage.setImageResource(R.drawable.dem_logo);
        } else if (party.equals("Republican Party")) {
            partyLogoImage.setImageResource(R.drawable.rep_logo);
        } else {
            partyLogoImage.setVisibility(View.INVISIBLE);
        }

        if (data.getStringExtra("ADDRESS").isEmpty()) addressText.setVisibility(View.GONE);
        if (data.getStringExtra("PHONE").equals("")) phoneText.setVisibility(View.GONE);
        if (data.getStringExtra("EMAIL").equals("")) emailText.setVisibility(View.GONE);
        if (data.getStringExtra("WEBSITE").equals("")) websiteText.setVisibility(View.GONE);
        if (data.getStringExtra("FACEBOOK").equals("")) facebookImage.setVisibility(View.GONE);
        if (data.getStringExtra("TWITTER").equals("")) twitterImage.setVisibility(View.GONE);
        if (data.getStringExtra("YOUTUBE").equals("")) youtubeImage.setVisibility(View.GONE);


        loadRemoteImage(data.getStringExtra("PHOTO"));

    }

    public void onClickPartyLogo(View v) {
        String demUrl = "https://democrats.org";
        String repUrl = "https://www.gop.com";

        String currURL = "";
        if (officialPartyText.getText().equals("Democratic Party")) {
            currURL = demUrl;
        } else if (officialPartyText.getText().equals("Republican Party")) {
            currURL = repUrl;
        } else {
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(currURL));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickOfficialImage(View v) {


        Intent data = new Intent(OfficialActivity.this, PhotoActivity.class);
        data.putExtra("OFFICE", officialOfficeText.getText());
        data.putExtra("NAME", officialNameText.getText());
        data.putExtra("PARTY", officialPartyText.getText());
        data.putExtra("LOCATION", officialLocationText.getText());

        setResult(RESULT_OK, data);
        startActivity(data);
    }

    private void loadRemoteImage(String imageURL) {
        // Needs gradle  implementation 'com.squareup.picasso:picasso:2.71828'

        long millisS = System.currentTimeMillis();

        picasso.load(imageURL)
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.missing)
                .into(officialImage, new Callback() {
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
