package com.christopherhield.paddingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.christopherhield.paddingrecyclerview.activity1.ActivityRV1;
import com.christopherhield.paddingrecyclerview.activity2.ActivityRV2;
import com.christopherhield.paddingrecyclerview.activity3.ActivityRV3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAct1(View v) {
        startActivity(new Intent(this, ActivityRV1.class));
    }

    public void openAct2(View v) {
        startActivity(new Intent(this, ActivityRV2.class));
    }

    public void openAct3(View v) {
        startActivity(new Intent(this, ActivityRV3.class));
    }
}