package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RdActivity extends AppCompatActivity {

    EditText edtIA,edtRI,edtT;
    Button btnCalculate,btnClear;
    TextView txtMaturity_Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rd);


        initview();

    }

    private void initview() {

        edtIA = findViewById(R.id.IA);
        edtRI = findViewById(R.id.expInterest);
        edtT = findViewById(R.id.tenureTime);
        btnCalculate = findViewById(R.id.calculate);
        btnClear = findViewById(R.id.clear);
        txtMaturity_Value = findViewById(R.id.ans);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateRD();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearRD();
            }
        });



    }

    private void clearRD() {
        edtIA.setText(null);
        edtRI.setText(null);
        edtT.setText(null);
        txtMaturity_Value.setText(null);
    }

    private void calculateRD() {
        String investmentText = edtIA.getText().toString();
        String interestText = edtRI.getText().toString();
        String tenureText = edtT.getText().toString();

        if (!investmentText.isEmpty() && !interestText.isEmpty() && !tenureText.isEmpty()) {
            Double InvestmentAMT = Double.parseDouble(investmentText);
            Double RateOFInterest = Double.parseDouble(interestText) / 100;
            int Tenure = Integer.parseInt(tenureText);



            // RD Calculation Formula
            double monthlyInterestRate = RateOFInterest / 12;
            double maturityAmount = InvestmentAMT * ((Math.pow(1 + monthlyInterestRate, Tenure) - 1) / monthlyInterestRate);

            // Display the result
            txtMaturity_Value.setText("Maturity Amount: " + String.format("%.2f", maturityAmount));


        } else {

            Toast.makeText(this, "Please enter all values.", Toast.LENGTH_SHORT).show();

        }
    }

}