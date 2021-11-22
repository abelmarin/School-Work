package com.example.hw2_abelmarin;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView noteTitle;
    TextView noteText;
    TextView lastSaveDate;

    MyViewHolder(View view) {
        super(view);
        noteTitle = view.findViewById(R.id.noteTitle);
        noteText = view.findViewById(R.id.noteText);
        lastSaveDate = view.findViewById(R.id.lastSaveDate);
    }
}
