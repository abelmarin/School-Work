package com.christopherhield.notes;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText name1, name2, name3;
    private EditText description1, description2, description3;
    private final ArrayList<Product> productList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = findViewById(R.id.prodName1);
        description1 = findViewById(R.id.prodDesc1);
        description1.setMovementMethod(new ScrollingMovementMethod());

        name2 = findViewById(R.id.prodName2);
        description2 = findViewById(R.id.prodDesc2);
        description2.setMovementMethod(new ScrollingMovementMethod());

        name3 = findViewById(R.id.prodName3);
        description3 = findViewById(R.id.prodDesc3);
        description3.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    protected void onResume() {
        productList.clear();
        productList.addAll(loadFile());

        if (productList.size() != 3) {
            super.onResume();
            return;
        }

        // We're hard-coded to 3 in the layout so do the same here
        Product p = productList.get(0);
        name1.setText(p.getName());
        description1.setText(p.getDescription());

        p = productList.get(1);
        name2.setText(p.getName());
        description2.setText(p.getDescription());

        p = productList.get(2);
        name3.setText(p.getName());
        description3.setText(p.getDescription());

        super.onResume();
    }

    private ArrayList<Product> loadFile() {

        Log.d(TAG, "loadFile: Loading JSON File");
        ArrayList<Product> prodList = new ArrayList<>();
        try {
            InputStream is = getApplicationContext().openFileInput(getString(R.string.file_name));
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONArray jsonArray = new JSONArray(sb.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String desc = jsonObject.getString("description");
                Product product = new Product(name, desc);
                prodList.add(product);
            }

        } catch (FileNotFoundException e) {
            Toast.makeText(this, getString(R.string.no_file), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prodList;
    }

    @Override
    protected void onPause() {
        if (!name1.getText().toString().isEmpty() && !description1.toString().isEmpty()) {
            Product p = new Product(name1.getText().toString(), description1.getText().toString());
            productList.add(p);
        }
        if (!name2.getText().toString().isEmpty() && !description2.toString().isEmpty()) {
            Product p = new Product(name2.getText().toString(), description2.getText().toString());
            productList.add(p);
        }
        if (!name3.getText().toString().isEmpty() && !description3.toString().isEmpty()) {
            Product p = new Product(name3.getText().toString(), description3.getText().toString());
            productList.add(p);
        }
        saveProduct();
        super.onPause();
    }

    private void saveProduct() {

        Log.d(TAG, "saveProduct: Saving JSON File");

        try {
            FileOutputStream fos = getApplicationContext().
                    openFileOutput(getString(R.string.file_name), Context.MODE_PRIVATE);

            PrintWriter printWriter = new PrintWriter(fos);
            printWriter.print(productList);
            printWriter.close();
            fos.close();

            Log.d(TAG, "saveProduct: JSON:\n" + productList.toString());

            Toast.makeText(this, getString(R.string.saved), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
