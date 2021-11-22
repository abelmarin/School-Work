package com.example.stockwatch;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class SymbolRunnable implements java.lang.Runnable {

    private static final String TAG = "SymbolRunnable";
    private final MainActivity mainActivity;
    private static final String DATA_URL_SYMBOL = "https://api.iextrading.com/1.0/ref-data/symbols";

    SymbolRunnable(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void run() {
        Uri dataUriSymbol = Uri.parse(DATA_URL_SYMBOL);
        String urlToUseSymbol = dataUriSymbol.toString();
        Log.d(TAG, "run: " + urlToUseSymbol);

        StringBuilder sb = new StringBuilder();
        try {
            URL urlSymbol = new URL(urlToUseSymbol);

            HttpURLConnection conn = (HttpURLConnection) urlSymbol.openConnection();
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

    private void handleResults(String s) {

        if (s == null) {
            Log.d(TAG, "handleResults: Failure in data download");
            mainActivity.runOnUiThread(mainActivity::downloadFailed);
            return;
        }

        final ArrayList<String> symbolArrayList = parseJSON(s);
        mainActivity.runOnUiThread(() -> {
            if (symbolArrayList != null)
                Toast.makeText(mainActivity, "Loaded " + symbolArrayList.size() + " symbols.", Toast.LENGTH_LONG).show();
            mainActivity.loadStockSymbols(symbolArrayList);
        });
    }

    private ArrayList<String> parseJSON(String s) {

        ArrayList<String> symbolList = new ArrayList<>();
        try {
            JSONArray jObjMain = new JSONArray(s);

            for (int i = 0; i < jObjMain.length(); i++) {
                JSONObject jStock = (JSONObject) jObjMain.get(i);

                String symbol = jStock.getString("symbol");

                symbolList.add(symbol);
            }
            return symbolList;
        } catch (Exception e) {
            Log.d(TAG, "parseJSON: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
