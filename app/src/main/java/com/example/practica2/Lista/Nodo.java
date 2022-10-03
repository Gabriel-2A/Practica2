package com.example.practica2.Lista;

public class Nodo {


    double dato;
    Nodo enlace;

    public Nodo(double x) {
        dato = x;
        enlace = null;
    }

    public Nodo(double x, Nodo n){
        dato = x;
        enlace = n;
    }

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString(){
        return String.valueOf(dato);
    }

}
