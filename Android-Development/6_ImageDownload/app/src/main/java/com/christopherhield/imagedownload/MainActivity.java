package com.christopherhield.imagedownload;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private ImageView imageView;
    private Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        picasso = Picasso.get();

        // picasso.setLoggingEnabled(true);
        // picasso.setIndicatorsEnabled(true);
        // Network - red
        // Disk - blue
        // Memory - green
    }

    public void loadImage(View v) {
        if (v.getId() == R.id.button1) {
            loadRemoteImage(getString(R.string.image1));
        } else if (v.getId() == R.id.button2) {
            loadRemoteImage(getString(R.string.image2));
        } else {
            loadRemoteImage(getString(R.string.image3));
        }
    }

    private void loadRemoteImage(String imageURL) {
        // Needs gradle  implementation 'com.squareup.picasso:picasso:2.71828'

        long millisS = System.currentTimeMillis();

        picasso.load(imageURL)
                .error(R.drawable.image_not_found)
                .placeholder(R.drawable.placeholder)
                .into(imageView, new Callback() {
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
        /*
        picasso.load(imageURL)
                .error(R.drawable.image_not_found)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
         */

    }

}
