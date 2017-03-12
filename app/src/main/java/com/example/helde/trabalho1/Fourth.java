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

        btn1.setText(getString(R.string.inch));
        btn2.setText(getString(R.string.cm));


        EditText tvToPrint = (EditText) findViewById(R.id.printTV);
        tvToPrint.setKeyListener(null);
    }

    public void btnCalcular(View v) {  //Enters on click on calcular button
        Button btn1 = (Button) findViewById(R.id.botaoMedida1);
        Button btn2 = (Button) findViewById(R.id.botaoMedida2);

        if (btn1.getText().toString().equals("inch")) {
            calculateByInches();
        } else {
            if (btn1.getText().toString().equals("cm")) {
                calculateByCentimeters();
            }
        }
    }

    private void calculateByInches() {
        Button btn2 = (Button) findViewById(R.id.botaoMedida2);

        EditText e1 = (EditText) findViewById(R.id.InsertN);
        String v1 = e1.getText().toString();
        float valor;

        if (v1 != null && !v1.isEmpty()) {
            valor = Float.parseFloat(v1);

            if (btn2.getText().toString().equals("cm")) {
                printNumbers(Double.toString((valor * 2.54)));
            }

        }
    }

    private void calculateByCentimeters() {
        Button btn2 = (Button) findViewById(R.id.botaoMedida2);

        EditText e1 = (EditText) findViewById(R.id.InsertN);
        String v1 = e1.getText().toString();
        float valor;

        if (v1 != null && !v1.isEmpty()) {
            valor = Float.parseFloat(v1);

            if (btn2.getText().toString().equals("inch")) {
                printNumbers(Double.toString((valor / 2.54)));
            }

        }
    }

    private void printNumbers(String number) {
        EditText tvToPrint = (EditText) findViewById(R.id.printTV);

        double nReceived = Double.parseDouble(number);
        double fractionalPart = nReceived % 1;
        double integralPart = nReceived - fractionalPart;

        if (fractionalPart>0) {
            tvToPrint.setText(Double.toString(nReceived));
        } else {
            tvToPrint.setText(Integer.toString((int)integralPart));
        }
    }

    public void switchMesures(View v) {
        Button btn1 = (Button) findViewById(R.id.botaoMedida1); // Change buttons text
        Button btn2 = (Button) findViewById(R.id.botaoMedida2);

        String stringBtn1 = btn1.getText().toString();
        String stringBtn2 = btn2.getText().toString();

        String aux1 = stringBtn1;

        btn1.setText(stringBtn2);
        btn2.setText(aux1);

        /*if (stringBtn2.equals("inch")) {
            calculateByInches();
        } else {
            if (stringBtn2.equals("cm")) {
                calculateByCentimeters();
            }
        }*/

        EditText e1 = (EditText) findViewById(R.id.InsertN); // Change EditText text
        EditText e2 = (EditText) findViewById(R.id.printTV);

        String srtE1 = e1.getText().toString();
        String srtE2 = e2.getText().toString();

        aux1 = srtE1;

        e1.setText(srtE2);
        e2.setText(aux1);


    }
}
