package testing;

import Ejemplos.ConjEnt;

public class mainConjE {
    
    public static void main(String[] artgs){
        ConjEnt conj = new ConjEnt();

        conj.meter(5);
        conj.meter(6);
        conj.meter(7);
        conj.meter(5);
        
        System.out.println("Conjunto A: " + conj);
        //System.out.println(conj.estaVacia());
        //System.out.println(conj.cardinal());
        
        ConjEnt conjB = new ConjEnt();
        
        conjB.meter(4);
        conjB.meter(6);
        conjB.meter(9);
        conjB.meter(7);

        System.out.println("Conjunto B: " + conjB);

        ConjEnt conjC = new ConjEnt();
        //conjC.Union(conj, conjB);
        //System.out.println("Conjunto Union: " + conjC); 
        //conjC.meter(6);
        //conjC.eliminar(new Integer(6));
        conjC.Interseccion(conj, conjB);
        System.out.println("Conjunto Interseccion: " + conjC);
    }
}
