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
        Union(conjA, conjB);
        //System.out.println(this);
        Object aux;
        if(!c1.estaVacia() || !c2.estaVacia()){
            //Recorermos la lista y vamos eliminando por elementos
            while(!c1.estaVacia()){
                aux = c1.sacar();
                eliminar(aux);
            }
            //Recorremos el otro conjunto
        }
    }
}
