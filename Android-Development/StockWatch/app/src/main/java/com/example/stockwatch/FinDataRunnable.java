package com.example.stockwatch;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FinDataRunnable implements java.lang.Runnable {
    private static final String TAG = "FinDataRunnable";
    private final MainActivity mainActivity;
    private final String symbol;

    FinDataRunnable(MainActivity mainActivity, String symbol) {
        this.mainActivity = mainActivity;
        this.symbol = symbol;
    }

    @Override
    public void run() {
        String DATA_URL = "https://cloud.iexapis.com/stable/stock/"+symbol+"/quote?token=pk_d598270193f2408790cb33a9f9c77429";

        Uri dataUriFinancial = Uri.parse(DATA_URL);
        String urlToUseFinancials = dataUriFinancial.toString();
        Log.d(TAG, "run: " + urlToUseFinancials);

        StringBuilder sb = new StringBuilder();
        try {
            URL urlFinancial = new URL(urlToUseFinancials);

            HttpURLConnection conn = (HttpURLConnection) urlFinancial.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                Log.d(TAG, "run: HTTP ResponseCode NOT OK: " + conn.getResponseCode());
                handleResults(null);
                return;
            }

            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader((new InputStreamReader(is)));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

            Log.d(TAG, "run: " + sb.toString());

        } catch (Exception e) {
            Log.e(TAG, "run: ", e);
            handleResults(null);
            return;
        }

        handleResults(sb.toString());

    }

    private void handleResults(final String jsonString) {

        final Stock s = parseJSON(jsonString);
        mainActivity.runOnUiThread(() -> mainActivity.getStockData(s));
    }

    private Stock parseJSON(String s) {

        try {
            JSONObject jObjMain = new JSONObject(s);

                double stockPrice = jObjMain.getDouble("latestPrice");
                double stockPriceChange = jObjMain.getDouble("changePercent");
                String company = jObjMain.getString("companyName");

                return new Stock(symbol, stockPrice, stockPriceChange, company);

        } catch (Exception e) {
            Log.d(TAG, "parseJSON: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
