package com.example.stockwatch;

import android.util.JsonWriter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.StringWriter;

public class Stock {

    private String symbolName;
    private double stockPrice;
    private double stockPriceChange;
    private String companyName;

    Stock(String title, double stockPrice, double stockPriceChange, String companyName) {
        this.symbolName = title;
        this.stockPrice = stockPrice;
        this.stockPriceChange = stockPriceChange;
        this.companyName = companyName;

    }

    public String getSymbolName() { return symbolName; }

    public double getStockPrice() { return stockPrice; }

    public double getStockPriceChange() { return stockPriceChange; }

    public String getCompanyName() { return companyName; }


    @NonNull
    public String toString() {
        try {
            StringWriter sw = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(sw);
            jsonWriter.setIndent("  ");
            jsonWriter.beginObject();
            jsonWriter.name("symbol").value(getSymbolName());
            jsonWriter.name("stock_price").value(getStockPrice());
            jsonWriter.name("stock_price_changed").value(getStockPriceChange());
            jsonWriter.name("company").value(getCompanyName());
            jsonWriter.endObject();
            jsonWriter.close();
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
