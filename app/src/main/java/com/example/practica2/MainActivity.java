package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica2.Lista.Nodo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etGuardar;
    private Button bAgregar;
    private TextView tvSueldo;
    private Nodo primero = null;
    private ListView lvLista;
    private ArrayList <Double> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGuardar = findViewById(R.id.etGuardar);
        bAgregar = findViewById(R.id.bAgregar);
        tvSueldo = findViewById(R.id.tvSueldo);
        lvLista = findViewById(R.id.lvLista);

        list = new ArrayList<>();

        ArrayAdapter <Double> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, list);

        lvLista.setAdapter(adapter);

        bAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(etGuardar.getText().toString().trim().equals("") || etGuardar.getText().toString().trim().equals(".")){
                    System.out.println("Error");
                }else {
                    double aux = Double.parseDouble(etGuardar.getText().toString().trim());
                    primero = new Nodo(aux, primero);
                    list.add(aux);
                    lvLista.setAdapter(adapter);
                }

                String resultado = "";
                Nodo auxPri = primero;
                while (auxPri != null){
                    resultado += auxPri + " ->";
                    auxPri = auxPri.getEnlace();
                }
                Log.i("Log", resultado);

                double total = 0;
                for (int i = 0; i < list.size(); i++) {
                    total += Double.parseDouble(etGuardar.getText().toString().trim());
                }

                tvSueldo.setText("total "+total+" Promedio "+(total/list.size())+" Sueldos Ingresados "+list.size());

                etGuardar.setText(null);

            }
        });

    }
}