package com.example.stockwatch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private static final String TAG = "MainActivity";

    private final ArrayList<Stock> stockList = new ArrayList<>();
    private final ArrayList<String> symbolList = new ArrayList<>();

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swiper;

    private StockAdapter mAdapter;

    private String m_Text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        mAdapter = new StockAdapter(stockList, this);

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        swiper = findViewById(R.id.swiper);
        swiper.setOnRefreshListener(this::doRefresh);

        boolean isFilePresent = isFilePresent(this, getString(R.string.file_name));
        if(isFilePresent) {
            String jsonString = read(this, getString(R.string.file_name));
            ArrayList<Stock> stockArrayList = parseJSON(jsonString);
            updateData(stockArrayList);
            mAdapter.notifyItemRangeChanged(0, stockList.size());
        } else {
            boolean isFileCreated = create(this, getString(R.string.file_name), "{}");
            if(isFileCreated) {
                //proceed with storing the first todo  or show ui
            } else {
                //show error or try again.
            }
        }

        SymbolRunnable countryLoaderRunnable = new SymbolRunnable(this);
        new Thread(countryLoaderRunnable).start();
    }

    private void doDownload(String symbol) {
        FinDataRunnable loaderTaskRunnable = new FinDataRunnable(this, symbol);
        new Thread(loaderTaskRunnable).start();
    }

    public void getStockData(Stock stock) {
        stockList.add(stock);
        mAdapter.notifyItemRangeChanged(0, 1);

    }

    private String read(Context context, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException fileNotFound) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }

    private boolean create(Context context, String fileName, String jsonString){
        try {
            FileOutputStream fos = context.openFileOutput(fileName,Context.MODE_PRIVATE);
            if (jsonString != null) {
                fos.write(jsonString.getBytes());
            }
            fos.close();
            return true;
        } catch (FileNotFoundException fileNotFound) {
            return false;
        } catch (IOException ioException) {
            return false;
        }

    }

    public boolean isFilePresent(Context context, String fileName) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }

    private void doRefresh() {
        mAdapter.notifyItemRangeChanged(0, stockList.size());
        swiper.setRefreshing(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.menuItem:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Stock Selection");
                builder.setMessage("Please enter a Stock Symbol:");
                final EditText input = new EditText(this);
                input.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();

                        if (symbolList.contains(m_Text) && checkStockExists(m_Text)==false) {
                            doDownload(m_Text);
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

                saveStock();
                mAdapter.notifyItemRangeChanged(0, stockList.size());
                break;

        }
        return true;
    }

    private boolean checkStockExists(String symbol) {

        for (int i = 0; i < stockList.size(); i++) {
            if (stockList.get(i).getSymbolName().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    private void saveStock() {

        Log.d(TAG, "saveProduct: Saving JSON File");

        try {
            FileOutputStream fos = getApplicationContext().
                    openFileOutput(getString(R.string.file_name), Context.MODE_PRIVATE);

            PrintWriter printWriter = new PrintWriter(fos);
            printWriter.print(stockList);
            printWriter.close();
            fos.close();

            Log.d(TAG, "saveProduct: JSON:\n" + stockList.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_action_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        int pos = recyclerView.getChildLayoutPosition(v);
        Stock s = stockList.get(pos);

        String currSymbol = s.getSymbolName();

        String url = "http://www.marketwatch.com/investing/stock/";

        String newURL = url + currSymbol;

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(newURL));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        int pos = recyclerView.getChildLayoutPosition(v);
        Stock s = stockList.get(pos);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Entry");
        builder.setMessage("Delete '" + s.getSymbolName() + "'");
        builder.setPositiveButton("Delete", (dialog, which) -> {
            stockList.remove(pos);
            mAdapter.notifyItemRemoved(pos);
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {});

        builder.create().show();

        return false;
    }

    public void updateData(ArrayList<Stock> sList) {
        try {
            stockList.addAll(sList);
            mAdapter.notifyItemRangeChanged(0, sList.size());
        } catch (NullPointerException e) {

        }

    }

    public void downloadFailed() {
        stockList.clear();
        mAdapter.notifyItemRangeChanged(0, stockList.size());
    }


    private ArrayList<Stock> parseJSON(String s) {

        ArrayList<Stock> stockArrayList = new ArrayList<>();
        try {
            JSONArray jObjMain = new JSONArray(s);

            for (int i = 0; i < jObjMain.length(); i++) {
                JSONObject jStock = (JSONObject) jObjMain.get(i);
                JSONObject nameObj = jStock.getJSONObject("name");

                String symbol = nameObj.getString("symbol");
                double stockPrice = jStock.getDouble("stock_price");
                double stockPriceChange = jStock.getDouble("stock_price_changed");
                String company = nameObj.getString("company");

                stockArrayList.add(new Stock(symbol, stockPrice, stockPriceChange, company));

            }
            return stockArrayList;
        } catch (Exception e) {
            Log.d(TAG, "parseJSON: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void loadStockSymbols(ArrayList<String> listOfSymbols) { symbolList.addAll(listOfSymbols); }
}