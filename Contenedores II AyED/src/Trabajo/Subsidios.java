package Trabajo;

import Contenedores.HashSets;

public class Subsidios extends HashSets{

    @Override
    public boolean equals(Object element1, Object element2) {
        // TODO Auto-generated method stub
        Persona p1 = (Persona)element1;
        Persona p2 = (Persona)element2;
        return p1.getDNI() == p2.getDNI();
    }
    //esta clase extiende de conjuntos, ya que en la consiga tenemos una lista de personas no repetidas
    //para comparar entre personas, comparamos por identificacion DNI

}
