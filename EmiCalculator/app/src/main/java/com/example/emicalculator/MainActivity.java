package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout EMI,FD_Calculator,RD_Calculator,PPF_Calculator,Currency_conversion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intentview();


    }

    private void Intentview() {


        EMI=findViewById(R.id.EMI);
        FD_Calculator=findViewById(R.id.FD_Calculator);
        RD_Calculator=findViewById(R.id.RD_Calculator);
        PPF_Calculator=findViewById(R.id.PPF_Calculator);
        Currency_conversion=findViewById(R.id.Currency_conversion);

        EMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    EMi();
            }
        });


        FD_Calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FD_Calculator();
            }
        });

        RD_Calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RD_Calculator();
            }
        });

        PPF_Calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PPF_Calculator();
            }
        });

        Currency_conversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Currency_conversion();
            }
        });

    }

    private void Currency_conversion() {
        Intent i = new Intent(MainActivity.this, CurrencyConvertActivity.class);
        startActivity(i);
    }

    private void PPF_Calculator() {
        Intent i = new Intent(MainActivity.this, PpfActivity.class);
        startActivity(i);
    }

    private void RD_Calculator() {
        Intent i = new Intent(MainActivity.this, RdActivity.class);
        startActivity(i);
    }

    private void FD_Calculator() {

        Intent i = new Intent(MainActivity.this, FdActivity.class);
        startActivity(i);


    }

    private void EMi() {


        Intent i = new Intent(MainActivity.this, EmiActivity.class);
        startActivity(i);


    }

}