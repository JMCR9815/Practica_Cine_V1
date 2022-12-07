package com.example.appprototipe.ui.actionMenuItemsScreens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appprototipe.MainActivity;
import com.example.appprototipe.R;

import java.util.ArrayList;
import java.util.List;

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

        List<Ticket>listaTickets= new ArrayList<>();


        agregarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(buyTicketActivity.this, "Tiquet añadido a la lista de compras", Toast.LENGTH_SHORT).show();

                Intent intentolistaCompra = new Intent(v.getContext(), MainActivity.class);

            }
        });
    }


}