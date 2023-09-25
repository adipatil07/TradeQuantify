package com.example.tradequantify;

import static java.lang.Math.abs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class target extends AppCompatActivity {
    TextView entryTv , stopTv, quantityTv,moneyTv ,targetTv, profitTv, lossTv;
    EditText ratioEt;
    Button calculateButton;
    float entry , stop , profit , loss , money , quantity,target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        initiate();
    }

    public void initiate() {
        entryTv = findViewById(R.id.entryTv);
        stopTv = findViewById(R.id.slTv);
        quantityTv = findViewById(R.id.quantityTv);
        targetTv = findViewById(R.id.targetTv);
        profitTv = findViewById(R.id.profitTv);
        moneyTv = findViewById(R.id.moneyTv);
        lossTv = findViewById(R.id.lossTv);
        ratioEt = findViewById(R.id.ratioEt);
        calculateButton = findViewById(R.id.calculateButton);


        Intent i = getIntent();
        entry = Float.parseFloat(i.getStringExtra("Entry"));
        stop = Float.parseFloat(i.getStringExtra("Stop"));
        quantity = Float.parseFloat(i.getStringExtra("Quantity"));

        entryTv.setText(String.valueOf(entry));
        stopTv.setText(String.valueOf(stop));
        quantityTv.setText(String.valueOf(quantity));

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float diff = entry - stop;
                // Calculate the target value first
                float factor = 2.0f; // Default factor is 1 if the user doesn't enter anything
                if (!ratioEt.getText().toString().isEmpty()) {
                    factor = Float.parseFloat(ratioEt.getText().toString());
                }


                if (entry < stop) {
                    target = entry - (abs(diff) * factor); // When entry is less than stop
                } else {
                    target = entry + (abs(diff) * factor); // When entry is greater than or equal to stop
                }

                // Now calculate the other values based on the target
                money = entry * quantity;
                profit = target * quantity;
                loss = stop * quantity;

                moneyTv.setText(String.valueOf(money));
                targetTv.setText(String.valueOf(target));
                profitTv.setText(String.valueOf(profit));
                lossTv.setText(String.valueOf(loss));
            }
        });
    }
}