package com.masavi.yasearmo.models;

/**
 * Created by Masavi on 31/5/2017.
 */

public class Item {

    private int id;
    private String nombre;
    private String url;
    private String descripcion;
    private String categoria;
    private int rating;

    public Item(){

    }

    public Item(String nombre, String url, String descripcion, String categoria, int rating) {
        this.nombre = nombre;
        this.url = url;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.rating = rating;
    }

    public Item(int id, String nombre, String url) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
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

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", url='" + url + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", rating=" + rating +
                '}';
    }
}
