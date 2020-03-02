package com.example.joe.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// Agrego mis Imports para poder usar mis elementos XML.
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    // Declaro mis variables que serán asignadas con los valores de mis elementos XML
    EditText precio, dolar;
    Switch envio;
    Button calcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazo mis elementos XML para poder asignarselos a mis variables.
        precio = (EditText) findViewById(R.id.eTxtPrecio);
        dolar = (EditText) findViewById(R.id.eTxtDolar);
        envio = (Switch) findViewById(R.id.SwBxEnvio);
        calcular = (Button) findViewById(R.id.btnCal);
        resultado = (TextView) findViewById(R.id.txtViRes);

        // Evento que ejecutará las intstrucciones para realizar el cálculo cuando se toca el botón.
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float superRes;
                // Primero verifico si mi Switch está checkeado para saber si aplico o no el subsidio de 25usd.
                // Luego convierto mis variables "precio" y "dolar" a Float, las sumo y el resultado lo muestro como String.
                if (envio.isChecked() == true) {
                    superRes = ((((Float.parseFloat(precio.getText().toString()) - 25) / 2) + (Float.parseFloat(precio.getText().toString()))) * (Float.parseFloat(dolar.getText().toString())));
                }

                else {
                    superRes = (((Float.parseFloat(precio.getText().toString()) / 2) + (Float.parseFloat(precio.getText().toString()))) * (Float.parseFloat(dolar.getText().toString())));
                }
                resultado.setText("Cuesta: $" + String.valueOf(superRes) + " aproximadamente");
            }
        });
    }
}