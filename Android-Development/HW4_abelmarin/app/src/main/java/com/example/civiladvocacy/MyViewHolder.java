package com.example.civiladvocacy;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView officeText;
    TextView nameAndPartyText;

    MyViewHolder(View view) {
        super(view);
        officeText = view.findViewById(R.id.officeText);
        nameAndPartyText = view.findViewById(R.id.nameAndPartyText);

    }
}
