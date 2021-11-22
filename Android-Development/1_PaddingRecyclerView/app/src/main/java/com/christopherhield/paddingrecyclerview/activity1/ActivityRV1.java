package com.christopherhield.paddingrecyclerview.activity1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.christopherhield.paddingrecyclerview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ActivityRV1 extends AppCompatActivity
        implements View.OnClickListener, View.OnLongClickListener {

    // Constraint to bottom adds spacing
    private final List<String> stringList = new ArrayList<>();  // Main content is here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv1);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        // Data to recyclerview adapter
        MyAdapter mAdapter = new MyAdapter(stringList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 30; i++) {
            stringList.add(String.format(Locale.getDefault(),
                    "List Element %d", i + 1));
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
}