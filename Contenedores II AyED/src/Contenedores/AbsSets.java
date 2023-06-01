package Contenedores;

import Recursos.OperacionesST;
import Recursos.Nodo;

public abstract class AbsSets implements OperacionesST{
    //Attributes
    protected Nodo sets;
    protected int card; //Con este atributo obtengo el cardinal del conjunto
    //builders
    public AbsSets(){
        limpiar();
    }
    //methods
    public void limpiar(){
        this.sets = null;
        this.card = 0;
    }
    public int cardinal(){
        return this.card;
    }

    public boolean estaVacia(){
        return (this.sets == null);
    }

    public abstract boolean equals(Object element1, Object element2);

    public boolean pertenece(Object element){
        Nodo temp;
        boolean flag = false;
        if(!estaVacia()){
            temp = this.sets;
            while(temp != null && !flag){
                if(equals(element, temp.getNodoInf())){
                    flag = true;
                }else {
                    temp = temp.getNextNodo();
                }
            }
        }

        return flag;
    }

    public void meter(Object element){
        if(!pertenece(element)){
            this.sets = new Nodo(element, this.sets);
            this.card++;
        }else {
            System.out.println("Error... Elemento Repetido!");
        }
    }

    public Object sacar(){
        Object element = null;
        if(!estaVacia()){
            element = this.sets.getNodoInf();
            this.sets = this.sets.getNextNodo();
            //Si es el ultimo elemento y la lista se vacia, volvemos a limpiar
            if(estaVacia()){
                limpiar();
            }
        }else {
            System.out.println("Error... Conjunto Vacio!");
        }
        return element;
    }

    public abstract void eliminar(Object element);

    public String toString(){
        Nodo aux = this.sets;
        String cad = "{";
        while(aux != null){
            if(aux.getNextNodo() == null){
                cad += aux.getNodoInf().toString();
            }else {
                cad += aux.getNodoInf().toString() + ", ";
            }
            aux = aux.getNextNodo();
        }
        cad += "}";
        return cad;
    }
}
