package com.masavi.yasearmo.models;

/**
 * Created by Masavi on 31/5/2017.
 */

public class Item {

    private String nombre;
    private String url;
    private String descripcion;
    private String categoria;
    private float rating;

    public Item(){

    }

    public Item(String nombre, String url, String descripcion, String categoria, float rating) {
        this.nombre = nombre;
        this.url = url;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", url='" + url + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", rating=" + rating +
                '}';
    }
}
