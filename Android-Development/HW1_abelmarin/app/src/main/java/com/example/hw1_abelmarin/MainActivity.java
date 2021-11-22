package com.example.hw1_abelmarin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView totalWTaxEditText;
    private RadioGroup radioGroup;
    private TextView tipAmountEditText;
    private TextView tipTotalEditText;

    private TextView numOfPeopleText;
    private TextView totalPerPersonText;
    private TextView overageText;

    private float totalWithTip;

    public float tipAmount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalWTaxEditText = findViewById(R.id.totalWTaxEditText);
        tipAmountEditText = findViewById(R.id.tipAmountEditText);
        tipTotalEditText = findViewById(R.id.tipTotalEditText);
        radioGroup = findViewById(R.id.radioGroup);

        numOfPeopleText = findViewById(R.id.numPeopleEditText);
        totalPerPersonText = findViewById(R.id.totalPerPersonEditText);
        overageText = findViewById(R.id.overageEditText);

    }



    public void radioBtnClick(View v) {
        try {
            String label = ((RadioButton)v).getText().toString();

            if (v.getId() == R.id.radioBtn1) {
                tipAmount = (float) .12;
            } else if (v.getId() == R.id.radioBtn2) {
                tipAmount = (float) .15;

            } else if (v.getId() == R.id.radioBtn3) {
                tipAmount = (float) .18;

            } else if (v.getId() == R.id.radioBtn4) {
                tipAmount = (float) .2;

            } else {

                Log.d(TAG, "radioBtnClick: Unexpected radio button click: " + label);
            }

            float totalWTaxNum = Float.valueOf(totalWTaxEditText.getText().toString());
            float newTipAmount = totalWTaxNum*tipAmount;
            totalWithTip = totalWTaxNum+newTipAmount;


            String newTipAmountStr = "$" + String.format("%.02f", newTipAmount);
            String newTipTotalStr = "$" + String.format("%.02f", totalWithTip);

            tipAmountEditText.setText(newTipAmountStr);
            tipTotalEditText.setText(newTipTotalStr);
        } catch (Exception e) {

        }


    }

    public void goBtnClick(View v) {
        try {
            float numPeople = Float.valueOf(numOfPeopleText.getText().toString());

            float totalPerPersonNum =  totalWithTip/numPeople;
            String totalPerPersonString = String.format("%.02f", totalPerPersonNum);
            totalPerPersonNum = Float.parseFloat(totalPerPersonString);

            float overage = (totalPerPersonNum*numPeople) - totalWithTip;
            String overageString = "$" + String.format("%.02f", overage);


            totalPerPersonText.setText("$" + totalPerPersonString);
            overageText.setText(overageString);
        } catch (Exception e) {

        }



    }

    public void clearBtnClick(View v) {
        totalWTaxEditText.setText("");
        radioGroup.clearCheck();
        tipAmountEditText.setText("");
        tipTotalEditText.setText("");

        numOfPeopleText.setText("");
        totalPerPersonText.setText("");
        overageText.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {



        outState.putString("TOTAL_W_TAX", totalWTaxEditText.getText().toString());
        outState.putString("TIP_AMOUNT", tipAmountEditText.getText().toString());
        outState.putString("TOTAL_W_TIP", tipTotalEditText.getText().toString());

        outState.putString("NUMBER_OF_PEOPLE", numOfPeopleText.getText().toString());
        outState.putString("TOTAL_PER_PERSON", totalPerPersonText.getText().toString());
        outState.putString("OVERAGE", overageText.getText().toString());


        // Call super last
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // Call super first
        super.onRestoreInstanceState(savedInstanceState);

        totalWTaxEditText.setText(savedInstanceState.getString("TOTAL_W_TAX"));
        tipAmountEditText.setText(savedInstanceState.getString("TIP_AMOUNT"));
        tipTotalEditText.setText(savedInstanceState.getString("TOTAL_W_TIP"));

        numOfPeopleText.setText(savedInstanceState.getString("NUMBER_OF_PEOPLE"));
        totalPerPersonText.setText(savedInstanceState.getString("TOTAL_PER_PERSON"));
        overageText.setText(savedInstanceState.getString("OVERAGE"));


    }

    }