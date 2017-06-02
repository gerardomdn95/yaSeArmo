package com.masavi.yasearmo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masavi on 02/06/2017.
 */

public class Paquete {

    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("imagen")
    private String imagen;

    @SerializedName("productos")
    private List<Producto> productos = new ArrayList<>();

    public Paquete(int id, String nombre, String imagen, List<Producto> productos)
    {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", productos=" + productos +
                '}';
    }
}
