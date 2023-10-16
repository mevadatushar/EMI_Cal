package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyConvertActivity extends AppCompatActivity {

    EditText Amount;
    Button btnCalculate;
    TextView converted;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_convert);

        initview();

    }

    private void initview() {


        Amount = findViewById(R.id.Amount);


        btnCalculate = findViewById(R.id.calculate);

        converted = findViewById(R.id.converted);
        back = findViewById(R.id.back);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate_currency();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

    }
    private void back() {
        Intent i = new Intent(CurrencyConvertActivity.this, MainActivity.class);
        startActivity(i);
    }


    private void calculate_currency() {
        String enterAmountStr = Amount.getText().toString();

        if (!enterAmountStr.isEmpty()) {
            double enterAmount = 0.0;

            try {
                enterAmount = Double.parseDouble(enterAmountStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid input. Please enter a valid amount.", Toast.LENGTH_SHORT).show();
                return; // Exit the method on error
            }

            double exchangeRate = 83.28250; // 1 USD to INR

            double convertedAmount = enterAmount * exchangeRate;
            converted.setText(String.format("%.2f", convertedAmount) + " ₹"); // Display the result in TextView
        } else {
            Toast.makeText(this, "Please Enter Your Amount.", Toast.LENGTH_SHORT).show();
        }
    }

}





