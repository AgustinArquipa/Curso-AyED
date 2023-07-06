package Tests;

import Contenedores.PilaLinkedList;
import Evaluacion.Cajas;
import Evaluacion.Pantalla;

public class testEvaluacion {
    
    public static void main(String[] args){
        //Intanciamos 3 Pantallas
        Pantalla p1 = new Pantalla(12);
        Pantalla p2 = new Pantalla(15);
        Pantalla p3 = new Pantalla(18);

        PilaLinkedList pila = new PilaLinkedList();
        pila.meter(p1);
        pila.meter(p2);
        pila.meter(p3);

        Cajas caja = new Cajas(pila);
        System.out.println(caja);
    }
}
