package testing;

import Ejemplos.ConjEnt;

public class mainConjE {
    
    public static void main(String[] artgs){
        ConjEnt conj = new ConjEnt();

        conj.meter(5);
        conj.meter(6);
        conj.meter(7);
        
        System.out.println(conj);
        //System.out.println(conj.estaVacia());
        //System.out.println(conj.cardinal());

        ConjEnt conjB = new ConjEnt();
        
        conjB.meter(4);
        conjB.meter(6);
        conjB.meter(9);
        conjB.meter(7);

        System.out.println(conjB);

        ConjEnt conjC = new ConjEnt();
        //conjC.Union(conj, conjB);
        //System.out.println("Conjunto Union: " + conjC); 
        conjC.Interseccion(conj, conjB);
        System.out.println(conjC);
    }
}
