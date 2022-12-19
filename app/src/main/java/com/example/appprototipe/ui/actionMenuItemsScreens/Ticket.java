package com.example.appprototipe.ui.actionMenuItemsScreens;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String nombrePelicula;
    private int numeroEntradas;
    private int numeroFila;

    public Ticket(String nombrePelicula, int numeroEntradas, int numeroFila) {
        this.nombrePelicula = nombrePelicula;
        this.numeroEntradas = numeroEntradas;
        this.numeroFila = numeroFila;
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

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    @Override
    public String toString() {
        return "Ticket{" + "nombrePelicula='" + nombrePelicula + '\'' + ", numeroEntradas=" + numeroEntradas + ", numeroFila=" + numeroFila + '}';
    }
}
