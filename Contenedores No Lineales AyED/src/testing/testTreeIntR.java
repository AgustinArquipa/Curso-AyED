package testing;

import Arbol.IntTSB;

public class testTreeIntR {
    
    public static void main(String[] args){
        //Testeando el meter recursivo
        IntTSB arbolR = new IntTSB();
        arbolR.meter(8);
        arbolR.meter(4);
        arbolR.meter(5);
        arbolR.meter(7);
        arbolR.meter(10);
        arbolR.meter(14);
        arbolR.meter(9);
        arbolR.meter(12);
    }
}
