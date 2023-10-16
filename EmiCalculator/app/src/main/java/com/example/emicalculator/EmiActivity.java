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

public class EmiActivity extends AppCompatActivity {

    EditText edtPA, edtInt, edtLT;
    Button btnCalculate, btnClear;
    TextView txtMainTotal;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);

        initview();

    }

    private void initview() {

        edtPA = findViewById(R.id.PA);
        edtInt = findViewById(R.id.IntrestAMT);
        edtLT = findViewById(R.id.loanAMT);
        btnCalculate = findViewById(R.id.calculate);
        btnClear = findViewById(R.id.clear);
        txtMainTotal = findViewById(R.id.ans);
        back = findViewById(R.id.back);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculateEMI();

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clearAll();

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
        Intent i = new Intent(EmiActivity.this, MainActivity.class);
        startActivity(i);
    }


    private void clearAll() {

        edtPA.setText(null);
        edtInt.setText(null);
        edtLT.setText(null);
        txtMainTotal.setText(null);


    }

    private void calculateEMI() {
        // Taking input from user on EditText


        String payment = edtPA.getText().toString();
        String interest = edtInt.getText().toString();
        String tenure = edtLT.getText().toString();

        if (!payment.isEmpty() && !interest.isEmpty() && !tenure.isEmpty()) {


            // Taking input from user on EditText
            double principal = Double.parseDouble(edtPA.getText().toString());
            double annualInterestRate = Double.parseDouble(edtInt.getText().toString());
            double loanTenure = Double.parseDouble(edtLT.getText().toString());


// Convert annual interest rate to monthly rate
            double monthlyInterestRate = (annualInterestRate / 12) / 100;

// Calculate the number of monthly payments
            int numberOfPayments = (int) (loanTenure * 12);

// Calculate EMI
            double emi = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

// Display result in TextView
            txtMainTotal.setText(String.format("%.2f", emi));

        } else {

            Toast.makeText(this, "Please enter all values.", Toast.LENGTH_SHORT).show();
        }

    }
}
