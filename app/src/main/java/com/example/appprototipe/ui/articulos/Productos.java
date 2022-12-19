package com.example.appprototipe.ui.articulos;

import android.media.Image;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Productos implements Serializable {

    private String nombre;
    private String sesion;
    private int calificacion;


    public Productos(String nombre, String sesion, int calificacion) {
        this.nombre = nombre;
        this.sesion = sesion;
        this.calificacion = calificacion;
        ;
    }

    public Productos(String nombre, String descripcion) {
        this.nombre = nombre;
        this.sesion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Productos)) return false;

        Productos productos = (Productos) o;

        if (getCalificacion() != productos.getCalificacion()) return false;
        if (getNombre() != null ? !getNombre().equals(productos.getNombre()) : productos.getNombre() != null)
            return false;
        return getSesion() != null ? getSesion().equals(productos.getSesion()) : productos.getSesion() == null;
    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getSesion() != null ? getSesion().hashCode() : 0);
        result = 31 * result + getCalificacion();
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "Productos{" + "nombre='" + nombre + '\'' + ", descripcion='" + sesion + '\'' + ", calificacion=" + calificacion + '}';
    }
}
