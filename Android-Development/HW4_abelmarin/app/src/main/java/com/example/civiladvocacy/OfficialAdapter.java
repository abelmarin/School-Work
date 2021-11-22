package com.example.civiladvocacy;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OfficialAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final String TAG = "StockAdapter";
    private final List<Official> officialList;
    private final MainActivity mainAct;

    OfficialAdapter(List<Official> officialList, MainActivity ma) {
        this.officialList = officialList;
        mainAct = ma;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: MAKING NEW");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.official_list_row, parent, false);

        itemView.setOnClickListener(mainAct);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Official official = officialList.get(position);

        holder.officeText.setText(official.getOffice());
        String name = official.getName();
        String party = official.getParty();

        holder.nameAndPartyText.setText(name + " (" + party + ")");



    }

    @Override
    public int getItemCount() {
        return officialList.size();
    }
}
