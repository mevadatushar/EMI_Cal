package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FdActivity extends AppCompatActivity {

    EditText edtIA,edtRI,edtT;
    Button btnCalculate,btnClear;
    TextView Maturity_Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fd);


        initview();

    }

    private void initview() {


        edtIA = findViewById(R.id.IA);
        edtRI = findViewById(R.id.expInterest);
        edtT = findViewById(R.id.tenureTime);
        btnCalculate = findViewById(R.id.calculate);
        btnClear = findViewById(R.id.clear);
        Maturity_Value = findViewById(R.id.ans);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateFD();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFD();
            }
        });


    }

    private void clearFD() {
        edtIA.setText(null);
        edtRI.setText(null);
        edtT.setText(null);
        Maturity_Value.setText(null);
    }

    private void calculateFD() {
        String investmentText = edtIA.getText().toString();
        String interestText = edtRI.getText().toString();
        String tenureText = edtT.getText().toString();

        if (!investmentText.isEmpty() && !interestText.isEmpty() && !tenureText.isEmpty()) {
            Double InvestmentAMT = Double.parseDouble(investmentText);
            Double RateOFInterest = Double.parseDouble(interestText);
            Double Tenure = Double.parseDouble(tenureText);

            // Calculate the maturity value here
            // You can use the formula to calculate the FD maturity value

            // For example, if it's simple interest, you can calculate it like this

            // https://cleartax.in/s/simple-compound-interest-calculator


          Double rate = (InvestmentAMT * RateOFInterest * Tenure)/100;
          Double Amount = InvestmentAMT+rate;

            // Display the result
            Maturity_Value.setText(String.format("%.2f", Amount));
        } else {

            Toast.makeText(this, "Please enter all values.", Toast.LENGTH_SHORT).show();

        }
    }

}