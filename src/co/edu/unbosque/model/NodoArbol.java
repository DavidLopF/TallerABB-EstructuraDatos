package co.edu.unbosque.model;

public class NodoArbol {

    private int dato;
    private NodoArbol padre;
    private NodoArbol hijoIzquierdo;
    private NodoArbol hijoDerecho;

    public NodoArbol() {
        this.dato = 0;
        this.padre = null;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public NodoArbol(int dato) {
        this.dato = dato;
        this.padre = null;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }
}
