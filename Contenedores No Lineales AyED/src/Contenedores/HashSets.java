package Contenedores;

import Recursos.Nodo;
import Recursos.OperacionesSETS1;

public abstract class HashSets extends AbsSets implements OperacionesSETS1{
    
    //methods mains
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

            while (!c2.estaVacia()){
                aux = c2.sacar();
                if(pertenece(aux)){
                    meter(aux);
                }
            }
        }else {
            System.out.println("Error al hacer la UNION... Conjuntos Vacios!");
        }
    }

    public void Interseccion(Object conjA, Object conjB){
        HashSets c1 = (HashSets)conjA;
        HashSets c2 = (HashSets)conjB;
        Object aux;
        if(!c1.estaVacia() || !c2.estaVacia()){
            limpiar();
            Nodo temp = c1.getSets();
            Nodo temp2;
            while(temp != null){
                temp2 = c2.getSets();
                aux = temp.getNodoObject();
                while(temp2 != null){
                    Object aux2 = temp2.getNodoObject();
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
