package Ejemplos;

import Contenedores.HashSets;

public class ConjEnt extends HashSets{

    @Override
    public boolean equals(Object element1, Object element2) {
        int e1 = (int)element1;
        int e2 = (int)element2;
        return e1 == e2;
    }
    
}
