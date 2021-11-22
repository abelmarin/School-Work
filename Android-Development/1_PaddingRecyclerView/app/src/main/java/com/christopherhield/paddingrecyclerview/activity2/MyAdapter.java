package com.christopherhield.paddingrecyclerview.activity2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.christopherhield.paddingrecyclerview.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder2> {

    private final List<String> stringList;
    private final ActivityRV2 activity;

    MyAdapter(List<String> stringList, ActivityRV2 activity) {
        this.stringList = stringList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_entry2, parent, false);
        itemView.setOnClickListener(activity);
        itemView.setOnLongClickListener(activity);

        return new ViewHolder2(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        String stringValue = stringList.get(position);

        holder.stringValue.setText(stringValue);

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
