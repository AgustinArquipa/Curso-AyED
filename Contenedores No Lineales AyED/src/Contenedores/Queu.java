package Contenedores;

import Recursos.Nodo;

public class Queu extends AbsQueu{
    
    @Override
    public void meter(Object element){
        if(!estaVacia()){
            this.finalC.setNextNodo(new Nodo(element));
            this.finalC = this.finalC.getNextNodo();
        }else {
            this.frenteC = this.finalC = new Nodo(element);
        }
    }
}
