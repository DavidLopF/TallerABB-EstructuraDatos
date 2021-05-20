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

    public void recorridoPostOrden(NodoArbol nodo) {
        if (nodo != null) {
            recorridoPostOrden(nodo.getHijoIzquierdo());
            recorridoPostOrden(nodo.getHijoDerecho());
            System.out.print("NUMERO DE NODO : " + nodo.getDato());
        }
    }

    public void recorrerInOrder(NodoArbol nodo) {
        if (nodo != null) {
            recorrerInOrder(nodo.getHijoIzquierdo());
            System.out.println("NUMERO DE NODO : " + nodo.getDato());
            recorrerInOrder(nodo.getHijoDerecho());
        }

    }

    public void recorerPreOrden(NodoArbol nodo) {
        if (nodo == null) {
            return;//detener recursividad caso base
        } else {
            System.out.print("NUMERO DE NODO : " + nodo.getDato());
            recorerPreOrden(nodo.getHijoIzquierdo());
            recorerPreOrden(nodo.getHijoDerecho());

        }
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
}
