package com.christopherhield.paddingrecyclerview.activity3;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.christopherhield.paddingrecyclerview.R;

public class ViewHolder3 extends RecyclerView.ViewHolder {

    TextView stringValue;

    ViewHolder3(View view) {
        super(view);
        stringValue = view.findViewById(R.id.string_entry_value);
    }
}
