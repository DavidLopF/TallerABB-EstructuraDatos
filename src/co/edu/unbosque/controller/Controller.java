package co.edu.unbosque.controller;

import co.edu.unbosque.model.ArbolBinario;
import co.edu.unbosque.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ArbolBinario arbolBinario;
    private View view;

    public Controller() {

        arbolBinario = new ArbolBinario();
        view = new View();
        funcionar();
    }

    private void funcionar() {
        view.mostrarDato("...:: BIENVENDO SEÑOR USUARIO ::...");
        String menu =
                "\n1. INSERTAR." +
                        "\n2. ELIMINAR." +
                        "\n3. BUSCAR ELEMENTO." +
                        "\n4. RECORRIDO IN ORDER." +
                        "\n5. RECORRIDO PREORDEN" +
                        "\n6. RECORRIDO POSTORDEN";
        view.mostrarDato(menu);
        int opcion = view.capturarInt("\nESCRIBA ACCION A REALIZAR: ");

        switch (opcion) {
            case 1:
                int dato = view.capturarInt("\n\nINGRESE VALOR DEL NODO A INSERTAR : ");
                arbolBinario.Insertar(dato);
                view.mostrarDato("NODO INGRESADO CON EXITO");
                funcionar();
                break;

            case 4:
                arbolBinario.recorrerInOrder(arbolBinario.getRaiz());
                funcionar();
                break;

            case 5:
                arbolBinario.recorerPreOrden(arbolBinario.getRaiz());
                funcionar();
                break;

            case 6:
                arbolBinario.recorridoPostOrden(arbolBinario.getRaiz());
                funcionar();
                break;

        }

    }
}
