package co.edu.unbosque.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ArbolBinario {

    private NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public boolean arbolVacio() {
        return raiz == null;
    }

    public void Insertar(int dato) {
        NodoArbol newNodo = new NodoArbol(dato);
        if (arbolVacio()) {
            raiz = newNodo;
        } else {
            NodoArbol aux = raiz;
            while (aux != null) {
                newNodo.setPadre(aux);
                if (newNodo.getDato() >= aux.getDato()) {
                    aux = aux.getHijoDerecho();
                } else {
                    aux = aux.getHijoIzquierdo();
                }
            }
            if (newNodo.getDato() < newNodo.getPadre().getDato()) {
                newNodo.getPadre().setHijoIzquierdo(newNodo);
            } else {
                newNodo.getPadre().setHijoDerecho(newNodo);
            }
        }
    }

    public List<String> recorrerInOrder(NodoArbol nodo) {
        List<String> temp = new ArrayList<>();
        if (nodo != null) {
            recorrerInOrder(nodo.getHijoIzquierdo());
            System.out.println("NUMERO DE NODO : " + nodo.getDato());
            recorrerInOrder(nodo.getHijoDerecho());
        }
        return temp;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
}
