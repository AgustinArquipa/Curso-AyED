package testing;

import Arbol.IntTSB;

public class testTreeInt {
    
    public static void main(String[] args){
        IntTSB tree = new IntTSB();
        tree.meter(28);
        tree.meter(49);
        tree.meter(14);
        tree.meter(51);
        tree.meter(40);
        tree.meter(78);
        tree.meter(83);
        tree.meter(92);
        tree.meter(66);
        tree.meter(20);
        tree.meter(71);
        tree.meter(67);
        
        //System.out.println("Mostrando en inOrder: ");
        //tree.muestraInOrder();
        System.out.println("\nMostrando en preOrder: ");
        tree.muestraPreOrder();
        System.out.println("\nMostrando en postOrder: ");
        tree.muestraPostOrder();
        System.out.println("\nEliminando 15, 7 y 20");
        tree.sacar(78);
        tree.sacar(7);
        tree.sacar(20);

        System.out.println("\nDespues de eliminar");
        tree.muestraPreOrder();
    }
}
