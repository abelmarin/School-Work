package com.example.stockwatch;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView symbolText;
    TextView stockPriceText;
    TextView stockPriceChangeText;
    TextView companyNameText;

    MyViewHolder(View view) {
        super(view);
        symbolText = view.findViewById(R.id.SymbolText);
        stockPriceText = view.findViewById(R.id.StockPriceText);
        stockPriceChangeText = view.findViewById(R.id.StockPriceChangeText);
        companyNameText = view.findViewById(R.id.CompanyNameText);

    }
}
