package com.example.helde.trabalho1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fourth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Button btn1 = (Button) findViewById(R.id.botaoMedida1);
        Button btn2 = (Button) findViewById(R.id.botaoMedida2);

        btn1.setText(getString(R.string.m));
        btn2.setText(getString(R.string.cm));
    }

    public void btnCalcular(View v) {  //Enters on click on calcular button
        Button btn1 = (Button) findViewById(R.id.botaoMedida1);
        Button btn2 = (Button) findViewById(R.id.botaoMedida2);

        if (btn1.getText().toString().equals("m")) {
            calculateByMeters();
        } else {
            Log.d("Entrei", "btnCalcular: naoEntrei");
        }
    }

    private void calculateByMeters() {
        Button btn2 = (Button) findViewById(R.id.botaoMedida2);

        EditText e1 = (EditText) findViewById(R.id.InsertN);
        String v1 = e1.getText().toString();
        float valor;

        if (v1 != null && !v1.isEmpty()) {
            valor = Float.parseFloat(v1);

            if (btn2.getText().toString().equals("cm")) {
                printNumbers(Float.toString((valor * 1000)));
            }

        }
    }

    private void printNumbers(String number) {
        Log.d("Entrei", "printNumbers: "+number);
        TextView tvToPrint = (TextView) findViewById(R.id.printTV);

        double nReceived = Double.parseDouble(number);
        double fractionalPart = nReceived % 1;
        double integralPart = nReceived - fractionalPart;

        if (fractionalPart>0) {
            tvToPrint.setText(Double.toString(nReceived));
        } else {
            tvToPrint.setText(Integer.toString((int)integralPart));
        }
    }
}
