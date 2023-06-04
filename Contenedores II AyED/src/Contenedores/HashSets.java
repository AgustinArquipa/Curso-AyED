package Contenedores;

import Recursos.Nodo;
import Recursos.OperacionesST1;

public abstract class HashSets extends AbsSets implements OperacionesST1{
    
    //methods
    public void eliminar(Object element){
        Nodo temp;
        boolean flag;

        if(!estaVacia()){
            if(pertenece(element)){
                //Buscamos en la primera posicion
                temp = this.sets;
                if(equals(element, temp.getNodoInf())){
                    this.sets = this.sets.getNextNodo();
                }else {
                    //Sino lo encontramos buscamos el elemento
                    flag = false;
                    while(temp.getNextNodo() != null && !flag){
                        if(equals(element, temp.getNextNodo().getNodoInf())){
                            flag = true;
                        }else {
                            temp = temp.getNextNodo();
                        }
                    }
                    temp.setNextNodo(temp.getNextNodo().getNextNodo());
                }
                this.card--;

                if(estaVacia()){
                    limpiar();
                }
            }else {
                System.out.println("Error... El Elemento no se encuentra!");
            }
        }else {
            System.out.println("Error... Conjunto Vacio!");
        }
    }

    //Methods that implements the main operations
    public void Union(Object conjA, Object conjB){
        HashSets c1 = (HashSets)conjA;
        HashSets c2 = (HashSets)conjB;
        Object aux;
        if(!c1.estaVacia() || !c2.estaVacia()){
            limpiar();
            while(!c1.estaVacia()){
                aux = c1.sacar();
                meter(aux);
            }

            while(!c2.estaVacia()){
                aux = c2.sacar();
                //Tenemos que volver a meter al conjunto y controlar que no este
                if(!pertenece(aux)){
                    meter(aux);
                }
            }
        }else {
            System.out.println("Error al hacer UNION... Conjuntos Vacios!");
        }
    }

    public void Interseccion(Object conjA, Object conjB){
        HashSets c1 = (HashSets)conjA;
        HashSets c2 = (HashSets)conjB;
        Object aux;
        if(!c1.estaVacia() || !c2.estaVacia()){
            limpiar();
            Nodo temp = c1.getNodo();
            Nodo temp2;
            while(temp != null){
                temp2 = c2.getNodo();
                aux = temp.getNodoInf();
                //System.out.println("Object 1: " + aux.toString());
                while(temp2 != null){
                    Object aux2 = temp2.getNodoInf();
                    //System.out.println("Object 2: " + aux2.toString());
                    if(equals(aux, aux2)){
                        meter(aux);
                    }
                    temp2 = temp2.getNextNodo();
                    
                }
                temp = temp.getNextNodo();
            }
        }
    }
}
