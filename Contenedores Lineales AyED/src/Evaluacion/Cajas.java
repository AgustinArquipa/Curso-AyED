package Evaluacion;

import Contenedores.PilaLinkedList;

public class Cajas {
    private PilaLinkedList caja;
    //builder
    public Cajas(PilaLinkedList cja){
        this.caja = cja;
    }
    //methods
    public Object getObjetoCaja(){
        return this.caja.sacar();
    }

    public String toString(){
        String cad = "Caja";
        this.caja.muestra();
        return cad;
    }
}
