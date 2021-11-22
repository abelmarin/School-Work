package com.example.civiladvocacy;

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

public class CivicRunnable implements java.lang.Runnable {

    private static final String TAG = "SymbolRunnable";
    private final MainActivity mainActivity;
    private static final String DATA_URL_ZIP = "https://www.googleapis.com/civicinfo/v2/representatives?key=AIzaSyCWCNDoJbLveTr-1EOhZcYWU79zU7NCXk0&address=";


    CivicRunnable(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void run() {
        String newUrl = DATA_URL_ZIP + mainActivity.determineZip();
        Uri dataUri = Uri.parse(DATA_URL_ZIP);
        String urlToUse = dataUri.toString();
        Log.d(TAG, "run: " + urlToUse);

        StringBuilder sb = new StringBuilder();
        try {
            URL urlSymbol = new URL(urlToUse);

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

        final ArrayList<Official> officialArrayList = parseJSON(s);
        mainActivity.runOnUiThread(() -> {
            if (officialArrayList != null)
                Toast.makeText(mainActivity, "Loaded " + officialArrayList.size() + " symbols.", Toast.LENGTH_LONG).show();
            mainActivity.loadOfficials(officialArrayList);
        });
    }

    private ArrayList<Official> parseJSON(String s) {

        ArrayList<Official> officialList = new ArrayList<>();
        try {
            JSONArray jObjMain = new JSONArray(s);

            for (int i = 0; i < jObjMain.length(); i++) {
                JSONObject highLevel = (JSONObject) jObjMain.get(i);

                JSONObject normalizedInput = (JSONObject) highLevel.getJSONObject("normalizedInput");
                JSONObject offices = (JSONObject) highLevel.getJSONObject("offices");
                JSONObject officials = (JSONObject) highLevel.getJSONObject("officials");

                String office = normalizedInput.getString("name");
                JSONArray officialIndices = normalizedInput.getJSONArray("officialIndices");

//                for (int j = 0; i < officialIndices.length(); j++) {
//
//                }

                officialList.add(new Official("Abel Marin", "Democratic party", office));
            }
            return officialList;
        } catch (Exception e) {
            Log.d(TAG, "parseJSON: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
