package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PpfActivity extends AppCompatActivity {

    EditText edtIA,edtT;
    Button btnCalculate,btnClear;
    TextView txtMaturity_Value,txtRI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppf);

        initview();

    }

    private void initview() {


        edtIA = findViewById(R.id.IA);
        txtRI = findViewById(R.id.expInterest);
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
        txtRI.setText(null);
        edtT.setText(null);
        txtMaturity_Value.setText(null);
    }

    private void calculateRD() {
        String investmentText = edtIA.getText().toString();
        String interestText = txtRI.getText().toString();
        String tenureText = edtT.getText().toString();

        if (!investmentText.isEmpty() && !tenureText.isEmpty()) {
            double principalAmount = Double.parseDouble(investmentText);

            int numberOfYears = Integer.parseInt(tenureText);

            // Calculate the maturity amount

            double maturityAmount = principalAmount * Math.pow(1 + 0.071, numberOfYears);


            // Display the result
            txtMaturity_Value.setText("Maturity Amount: " + String.format("%.2f", maturityAmount));


        } else {

            Toast.makeText(this, "Please enter all values.", Toast.LENGTH_SHORT).show();

        }
    }

}