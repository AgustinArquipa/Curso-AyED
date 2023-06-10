package Contenedores;

import Recursos.Nodo;

public abstract class PriopertyQueu extends AbsQueu{
    
    public abstract boolean equals(Object element1, Object element2);
    public abstract boolean isOlder(Object element1, Object element2);
    public abstract boolean isLess(Object element1, Object element2);

    @Override
    public void meter(Object element){
        Nodo nodo;
        nodo = new Nodo(element);
        if(estaVacia()){
            this.frenteC = this.finalC = nodo;
        }else {
            if(isOlder(element, this.frenteC.getNodoObject()) 
                || equals(element, this.frenteC.getNodoObject())){
                nodo.setNextNodo(this.frenteC);
                this.frenteC = nodo;
            }else {
                //inserte the element in end
                if(isLess(element, this.finalC.getNodoObject())){
                    this.finalC.setNextNodo(nodo);
                    this.finalC = nodo;
                }else {
                    Nodo prev, next;
                    boolean flag = false;
                    prev = this.frenteC;
                    next = this.frenteC.getNextNodo();
                    while(prev.getNextNodo() != null && next.getNextNodo() != null && !flag){
                        if(isLess(element, prev.getNodoObject()) && isOlder(element, next.getNodoObject())){
                            flag = true;
                        }else {
                            prev = prev.getNextNodo();
                            next = next.getNextNodo();
                        }
                    }
                    nodo.setNextNodo(next);
                    prev.setNextNodo(nodo);
                }
            }
        }
    }
}
