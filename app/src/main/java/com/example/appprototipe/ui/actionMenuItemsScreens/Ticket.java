package com.example.appprototipe.ui.actionMenuItemsScreens;

import com.example.appprototipe.ui.articulos.Productos;

public class Ticket {
    private Productos pelicula;
    private int numeroEntradas;
    private int numeroFila;

    public Ticket(Productos pelicula, int numeroEntradas, int numeroFila) {
        this.pelicula = pelicula;
        this.numeroEntradas = numeroEntradas;
        this.numeroFila = numeroFila;
    }

    public Productos getPelicula() {
        return pelicula;
    }

    public void setPelicula(Productos pelicula) {
        this.pelicula = pelicula;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }

    public int getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(int numeroFila) {
        this.numeroFila = numeroFila;
    }
}
