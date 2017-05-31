package com.masavi.yasearmo.models;

/**
 * Created by Masavi on 30/5/2017.
 */

public class Tarjeta {

    private int id;
    private String titulo;
    private String contenido;
    private String imgUrl;

    public Tarjeta(int id, String titulo, String contenido, String imgUrl) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
