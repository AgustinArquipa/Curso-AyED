package Ejemplos;

import Contenedores.HashSets;

public class ConjEnt extends HashSets{

    @Override
    public boolean equals(Object element1, Object element2) {
        Integer e1 = (Integer)element1;
        Integer e2 = (Integer)element2;
        return e1 == e2;
    }
    
}
