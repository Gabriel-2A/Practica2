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
import android.widget.Toast;

import com.example.practica2.Lista.Nodo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etGuardar;
    private Button bAgregar, bBuscar;
    private TextView tvSueldo, tvPosicion, tvImparOPar;
    private Nodo primero = null;
    private ListView lvLista;
    private ArrayList <Double> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGuardar = findViewById(R.id.etGuardar);
        bAgregar = findViewById(R.id.bAgregar);
        bBuscar = findViewById(R.id.bBuscar);
        tvSueldo = findViewById(R.id.tvSueldo);
        tvPosicion = findViewById(R.id.tvPosicion);
        tvImparOPar = findViewById(R.id.tvImparOPar);
        lvLista = findViewById(R.id.lvLista);

        list = new ArrayList<>();

        ArrayAdapter <Double> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, list);

        lvLista.setAdapter(adapter);

        bAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(etGuardar.getText().toString().trim().equals("") || etGuardar.getText().toString().trim().equals(".")){
                    Toast.makeText(getApplicationContext(),"Dato no aceptado",Toast.LENGTH_SHORT).show();
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

        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etGuardar.getText().toString().trim().equals("") || etGuardar.getText().toString().trim().equals(".")) {
                    Toast.makeText(getApplicationContext(), "Dato no aceptado", Toast.LENGTH_SHORT).show();
                } else {
                    double aux = Double.parseDouble(etGuardar.getText().toString().trim());
                    int cont = 0, indice = -1;
                    Nodo auxPri = primero;
                    while (auxPri != null) {
                        cont++;
                        if (aux == auxPri.getDato()) {
                            indice = cont;
                            break;
                        }
                        auxPri = auxPri.getEnlace();
                    }
                    if (indice == -1) {
                        tvPosicion.setText("No existe el dato");
                        System.out.println("No existe el dato");
                    } else {
                        Log.i("Log", "El sueldo se encuentra en la posicion: " + cont);
                        tvPosicion.setText("El sueldo se encuentra en la posicion: " + cont);

                        if (indice % 2 == 0) {
                            Log.i("Log", "La posicion del sueldo es par");
                            tvImparOPar.setText("La posicion del sueldo es par");
                        } else {
                            Log.i("Log", "La posicion del sueldo es impar");
                            tvImparOPar.setText("La posicion del sueldo es impar");
                        }

                    }


                }
            }
        });

    }
}