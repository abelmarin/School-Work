package com.example.stockwatch;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class StockAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final String TAG = "StockAdapter";
    private final List<Stock> stockList;
    private final MainActivity mainAct;

    StockAdapter(List<Stock> stockList, MainActivity ma) {
        this.stockList = stockList;
        mainAct = ma;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: MAKING NEW");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_list_row, parent, false);

        itemView.setOnClickListener(mainAct);
        itemView.setOnLongClickListener(mainAct);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Stock stock = stockList.get(position);
        holder.symbolText.setText(stock.getSymbolName());
        holder.stockPriceText.setText(Double.toString(stock.getStockPrice()));

        holder.companyNameText.setText(stock.getCompanyName());
        if (stock.getStockPriceChange() < 0) {
            holder.symbolText.setTextColor(Color.RED);
            holder.stockPriceText.setTextColor(Color.RED);
            holder.stockPriceChangeText.setTextColor(Color.RED);
            holder.companyNameText.setTextColor(Color.RED);
            holder.stockPriceChangeText.setText("\u25Bc" + String.format("%.2f", stock.getStockPriceChange()));
        } else {
            holder.symbolText.setTextColor(Color.GREEN);
            holder.stockPriceText.setTextColor(Color.GREEN);
            holder.stockPriceChangeText.setTextColor(Color.GREEN);
            holder.companyNameText.setTextColor(Color.GREEN);
            holder.stockPriceChangeText.setText("\u25B2" + String.format("%.2f", stock.getStockPriceChange()));
        }
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }

}
