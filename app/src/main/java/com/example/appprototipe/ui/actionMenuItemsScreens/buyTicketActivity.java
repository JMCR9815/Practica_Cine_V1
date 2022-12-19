package com.example.appprototipe.ui.actionMenuItemsScreens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appprototipe.MainActivity;
import com.example.appprototipe.R;
import com.example.appprototipe.ui.articulos.Productos;

@SuppressLint("Registered")
public class buyTicketActivity extends AppCompatActivity {
    private EditText numeroEntradas, numeroFila;
    private Button agregarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        numeroEntradas = findViewById(R.id.cantidadEntradas);
        numeroFila = findViewById(R.id.numeroFila);
        agregarCompra = findViewById(R.id.buttonCompra);


        agregarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroEntrada = numeroEntradas.getText().toString();
                String numeroFilas = numeroFila.getText().toString();
                SharedPreferences pref = buyTicketActivity.this.getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();
                Toast.makeText(buyTicketActivity.this, "Tiquet añadido a la lista de compras", Toast.LENGTH_SHORT).show();
                Bundle bundle;
                bundle = getIntent().getExtras();
                Productos producto = (Productos) bundle.getSerializable("pelicula");
                Ticket tiketCompra = new Ticket(producto.getNombre(), Integer.parseInt(numeroEntrada), Integer.parseInt(numeroFilas));
                editor.putString("peliculaName", tiketCompra.getNombrePelicula());
                editor.putInt("NumeroEntradas", tiketCompra.getNumeroFila());
                editor.putInt("NumeroFila", tiketCompra.getNumeroFila());
                Intent intentolistaCompra = new Intent(v.getContext(), MainActivity.class);
                editor.commit();
                startActivity(intentolistaCompra);
            }
        });
    }


}