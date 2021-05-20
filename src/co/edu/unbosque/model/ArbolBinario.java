package co.edu.unbosque.model;

import java.util.ArrayList;


public class ArbolBinario {

    private NodoArbol raiz;
    private ArrayList<Integer> elementos;

    public ArbolBinario() {
        raiz = null;
        elementos = new ArrayList<Integer>();
    }

    public boolean arbolVacio() {
        return raiz == null;
    }

    public void Insertar(int dato) {
        NodoArbol newNodo = new NodoArbol(dato);
        if (elementoNOExite(dato)) {
            if (arbolVacio()) {
                elementos.add(newNodo.getDato());
                raiz = newNodo;
            } else {
                elementos.add(newNodo.getDato());
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
    }

    public Boolean eliminar(int dato) {
        NodoArbol aux = raiz; //va a recorrer el arbol
        NodoArbol padre = raiz; //va a sabeer el padre del que estamos recorriendo
        boolean esHijoIzq = true; //para saber si es hijo izquierdo o derecho

        while (aux.getDato() != dato) {
            padre = aux;
            if (dato < aux.getDato()) {
                esHijoIzq = true;
                aux = aux.getHijoIzquierdo();
            } else {
                esHijoIzq = false;
                aux = aux.getHijoDerecho();
            }
            if (aux == null) {
                return false;
            }
        }
        //si ecuentra el nodo
        if (aux.getHijoIzquierdo() == null && aux.getHijoDerecho() == null) { //para saber si ese nodo es una hoja
            if (aux == raiz) { //para saber si solo tengo un nodo
                raiz = null;
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(null);
            } else {
                padre.setHijoDerecho(null);
            }
        } else if (aux.getHijoDerecho() == null) { //se reacomoda los punteros
            if (aux == raiz) {
                raiz = aux.getHijoIzquierdo();
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(aux.getHijoIzquierdo());
            } else {
                padre.setHijoDerecho(aux.getHijoIzquierdo());
            }
        } else if (aux.getHijoIzquierdo() == null) {
            if (aux == raiz) {
                raiz = aux.getHijoDerecho();
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(aux.getHijoDerecho());
            } else {
                padre.setHijoDerecho(aux.getHijoIzquierdo());
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplaz(aux); // remplazar el nodo que vamos a eliminar
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(reemplazo);
            } else {
                padre.setHijoDerecho(reemplazo);
            }
            reemplazo.setHijoIzquierdo(aux.getHijoIzquierdo());
        }

        return true;

    }

    public NodoArbol busqueda(int a) {
        NodoArbol aux = raiz;
        while (aux.getDato() != a) {
            if (a < aux.getDato()) {
                aux = aux.getHijoIzquierdo();
            } else {
                aux = aux.getHijoDerecho();
            }
            if (aux == null) { //saber si ya estamos en el fina
                return null;
            }
        }
        return aux;
    }

    private NodoArbol obtenerNodoReemplaz(NodoArbol aux) {
        NodoArbol reemplazarPadre = aux;
        NodoArbol reemplazo = aux;
        NodoArbol auxiliar = aux.getHijoDerecho();
        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.getHijoIzquierdo();
        }
        if (reemplazo != aux.getHijoDerecho()) { //para reacomodar los enlases
            reemplazarPadre.setHijoIzquierdo(reemplazo.getHijoDerecho());
            reemplazo.setHijoDerecho(aux.getHijoDerecho());
        }
        System.out.println("El nodo de reemplazo es " + reemplazo.getDato());
        return reemplazo;

    }

    public boolean elementoNOExite(int a) {
        int cont = 0;
        if (!arbolVacio()) {
            for (int i = 0; i < elementos.size(); i++) {
                if (a == elementos.get(i)) {
                    cont++;

                }
            }
        }
        return cont == 0;
    }

    public ArrayList recorridoPostOrden(NodoArbol nodo, ArrayList a) {
        if (nodo != null) {
            recorridoPostOrden(nodo.getHijoIzquierdo(), a);
            recorridoPostOrden(nodo.getHijoDerecho(), a);
            a.add(nodo.getDato());

        }
        return a;
    }

    public ArrayList recorrerInOrder(NodoArbol nodo, ArrayList a) {
        if (nodo != null) {
            recorrerInOrder(nodo.getHijoIzquierdo(), a);
            a.add(nodo.getDato());
            recorrerInOrder(nodo.getHijoDerecho(), a);
        }
        return a;
    }

    public ArrayList recorerPreOrden(NodoArbol nodo, ArrayList a) {
        if (nodo != null) {
            a.add(nodo.getDato());
            recorerPreOrden(nodo.getHijoIzquierdo(), a);
            recorerPreOrden(nodo.getHijoDerecho(), a);

        }
        return a;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
}
