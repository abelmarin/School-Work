package com.christopherhield.paddingrecyclerview.activity1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.christopherhield.paddingrecyclerview.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder1> {

    private final List<String> stringList;
    private final ActivityRV1 activity;

    MyAdapter(List<String> stringList, ActivityRV1 activity) {
        this.stringList = stringList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_entry1, parent, false);
        itemView.setOnClickListener(activity);
        itemView.setOnLongClickListener(activity);

        return new ViewHolder1(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {
        String stringValue = stringList.get(position);

        holder.stringValue.setText(stringValue);

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
