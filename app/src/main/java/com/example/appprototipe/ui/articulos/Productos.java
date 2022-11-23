package com.example.appprototipe.ui.articulos;

import androidx.annotation.NonNull;

public class Productos {
    private String nombre;
    private String descripcion;
    private int calificacion;

    public Productos(String nombre, String descripcion, int calificacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
    }

    public Productos(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return getDescripcion() != null ? getDescripcion().equals(productos.getDescripcion()) : productos.getDescripcion() == null;
    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getDescripcion() != null ? getDescripcion().hashCode() : 0);
        result = 31 * result + getCalificacion();
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "Productos{" + "nombre='" + nombre + '\'' + ", descripcion='" + descripcion + '\'' + ", calificacion=" + calificacion + '}';
    }
}
