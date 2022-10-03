package com.example.practica2.Lista;

public class Enlaze {

    private Nodo primero;

    public Enlaze(){
        primero = null;
    }

    public void crearLista(){

    }

    @Override
    public String toString() {

        String resultado = "";
        Nodo aux = primero;
        while (aux != null){
            resultado += aux + " ->";
            aux = aux.getEnlace();
        }

        return resultado;
    }

}
