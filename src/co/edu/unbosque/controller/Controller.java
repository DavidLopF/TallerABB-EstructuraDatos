package co.edu.unbosque.controller;

import co.edu.unbosque.model.ArbolBinario;
import co.edu.unbosque.view.View;

import java.util.ArrayList;

public class Controller {

    private ArbolBinario arbolBinario;
    private View view;

    public Controller() {

        arbolBinario = new ArbolBinario();
        view = new View();
        view.mostrarDato("...:: BIENVENDO SEÑOR USUARIO ::...");
        funcionar();
    }

    private void funcionar() {
        ArrayList list = new ArrayList();
        view.mostrarDato("elementos en el arbol : " + arbolBinario.recorrerInOrder(arbolBinario.getRaiz(), list));
        String menu =
                "\n1. INSERTAR." +
                        "\n2. ELIMINAR." +
                        "\n3. BUSCAR ELEMENTO." +
                        "\n4. RECORRIDO IN ORDER." +
                        "\n5. RECORRIDO PRE ORDER" +
                        "\n6. RECORRIDO POST ORDER";
        view.mostrarDato(menu);
        int opcion = view.capturarInt("\nESCRIBA ACCION A REALIZAR: ");

        if (opcion <= 6) {
            switch (opcion) {
                case 1:
                    int dato = view.capturarInt("\n\nINGRESE VALOR DEL NODO A INSERTAR : ");
                    arbolBinario.Insertar(dato);

                    if (arbolBinario.elementoNOExite(dato)) {
                        view.mostrarDato("NODO INGRESADO CON EXITO");
                    } else {
                        view.mostrarDato("IMPOSIBLE AGREGAR: ELEMENTO YA ESTA EN EL ARBOL");
                    }

                    funcionar();
                    break;

                case 2:
                    ArrayList listElim = new ArrayList();
                    dato = view.capturarInt("elementos en el arbol : " + arbolBinario.recorrerInOrder(arbolBinario.getRaiz(), listElim) +
                            "\nINGRESE ELEMENTO A ELIMINAR DEL ARBOL: ");
                    if (arbolBinario.eliminar(dato)) {
                        view.mostrarDato("NODO ELIMINADO CON EXITO");
                    }else{
                        view.mostrarDato("NO SE HA ELIMINADO EL NODO");
                    }
                    funcionar();

                    break;

                case 4:
                    view.mostrarDato("\n");
                    ArrayList listIN = new ArrayList();
                    System.out.println("RESULTAOD DE RECORRIDO IN ORDER:\n" + arbolBinario.recorrerInOrder(arbolBinario.getRaiz(), listIN));
                    funcionar();
                    break;

                case 5:
                    view.mostrarDato("\n");
                    ArrayList listPre = new ArrayList();
                    view.mostrarDato("RESULTAOD DE RECORRIDO PRE ORDER:\n" + arbolBinario.recorerPreOrden(arbolBinario.getRaiz(), listPre));
                    funcionar();
                    break;

                case 6:
                    view.mostrarDato("\n");
                    ArrayList listPost = new ArrayList();
                    view.mostrarDato("RESULTAOD DE RECORRIDO POST ORDER:\n" + arbolBinario.recorridoPostOrden(arbolBinario.getRaiz(), listPost));
                    funcionar();
                    break;

            }
        } else {
            view.mostrarDato("Opcion invalida :(");
            funcionar();
        }

    }
}
