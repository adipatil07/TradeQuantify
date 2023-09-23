package com.example.tradequantify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText riskEntry, entry, sl;
    TextView risk, quantity1,text;
    Button calculate, five, one, oneFive, two, twoFive, three;
    float entryPrice,stopPrice,riskPrice, quantityPrice;
    float first, second, third, four, fivee, six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        riskPrice = 1000; // You can change this to your desired default value
        risk.setText(String.valueOf(riskPrice));

        // Add an OnFocusChangeListener to the riskEntry EditText
        riskEntry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // When the focus is lost (user finishes entering text), update the risk TextView
                    updateRisk();
                }
            }
        });

    }

    private void initialize() {
        riskEntry = findViewById(R.id.riskEntry);
        entry = findViewById(R.id.entry);
        sl = findViewById(R.id.sl);

        risk = findViewById(R.id.Risk);
        quantity1 = findViewById(R.id.quantity);
        text = findViewById(R.id.quantityText);

        calculate = findViewById(R.id.cal);

        five = findViewById(R.id.fiveHund);
        one = findViewById(R.id.oneThou);
        oneFive = findViewById(R.id.oneFive);
        two = findViewById(R.id.twoThos);
        twoFive = findViewById(R.id.twoFive);
        three = findViewById(R.id.three);

    }
    // Rest of your code for btn1 to btn6 methods
    public void btn1(View view) {
        first = 500; // Assuming you want to set the value to 500
        riskPrice = first;
        risk.setText(String.valueOf(first));
    }

    public void btn2(View view) {
        second = 1000; // Assuming you want to set the value to 1000
        riskPrice = second;
        risk.setText(String.valueOf(second));
    }

    public void btn3(View view) {
        third = 1500; // Assuming you want to set the value to 1500
        riskPrice = third;
        risk.setText(String.valueOf(third));
    }

    public void btn4(View view) {
        four = 2000; // Assuming you want to set the value to 2000
        riskPrice = four;
        risk.setText(String.valueOf(four));
    }

    public void btn5(View view) {
        fivee = 2500; // Assuming you want to set the value to 2500
        riskPrice = fivee;
        risk.setText(String.valueOf(fivee));
    }

    public void btn6(View view) {
        six = 3000; // Assuming you want to set the value to 3000
        riskPrice = six;
        risk.setText(String.valueOf(six));
    }
    public void QuaCalculate(View view) {
        try {
            // Calculate quantityPrice based on entered riskPrice
            updateRisk();
            entryPrice = Float.parseFloat(entry.getText().toString());
            stopPrice = Float.parseFloat(sl.getText().toString());
            quantityPrice = riskPrice / (entryPrice - stopPrice);

            // Round the quantityPrice to the nearest integer as per your criteria
            if (quantityPrice < 0) {
                // Make it positive if initially negative
                quantityPrice = -quantityPrice;
            }
            if (quantityPrice % 1 < 0.5) {
                quantityPrice = (float) Math.floor(quantityPrice);
            } else {
                quantityPrice = (float) Math.ceil(quantityPrice);
            }

            text.setVisibility(View.VISIBLE);
            quantity1.setText(String.valueOf(quantityPrice));
            riskEntry.setText("");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }


    public void reset(View view){
        riskEntry.setText("");
        entry.setText("");
        sl.setText("");
    }
    private void updateRisk() {
        String riskEntryText = riskEntry.getText().toString(); // Get the text and remove leading/trailing whitespace

//        riskPri = Integer.parseInt(risk.getText().toString());
//
//        // Set the initial text of the risk TextView
//        risk.setText(String.valueOf(riskPri));
        if (!riskEntryText.isEmpty()) {
            try {
                riskPrice = Integer.parseInt(riskEntryText);
                risk.setText(String.valueOf(riskPrice));
            } catch (NumberFormatException e) {
                Log.d("Debug", "Invalid Risk Entry: " + e.getMessage());
                Toast.makeText(this, "Invalid Risk Entry", Toast.LENGTH_SHORT).show();
            }
        }
    }



}
