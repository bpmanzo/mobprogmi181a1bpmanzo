package com.example.convmilestokm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnConvMilesToKm = (Button) findViewById(R.id.btnConvMilesToKm);
        btnConvMilesToKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputMiles = (EditText) findViewById(R.id.milesInput);
                EditText inputKM = (EditText) findViewById(R.id.kmInput);

                double vMiles = Double.valueOf(inputMiles.getText().toString());
                double vKm = vMiles / 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                inputKM.setText(formatVal.format(vKm));



            }
        });

        Button btnConvKmToMiles = (Button) findViewById(R.id.btnConvKMtoMiles);
        btnConvMilesToKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputMiles = (EditText) findViewById(R.id.milesInput);
                EditText inputKM = (EditText) findViewById(R.id.kmInput);

                double vKm = Double.valueOf(inputKM.getText().toString());
                double vMiles = vKm * 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                inputMiles.setText(formatVal.format(vMiles));



            }
        });

    }
}
