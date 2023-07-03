package testing;

import Arbol.IntTSB;

public class testTreeInt {
    
    public static void main(String[] args){
        IntTSB tree = new IntTSB();
        tree.meter(7);
        tree.meter(5);
        tree.meter(20);
        tree.meter(6);
        tree.meter(14);
        tree.meter(35);
        tree.meter(10);
        tree.meter(7);

        System.out.println("Mostrando en inOrder: ");
        tree.muestraInOrder();
        System.out.println("\nMostrando en preOrder: ");
        tree.muestraPreOrder();
        System.out.println("\nMostrando en postOrder: ");
        tree.muestraPostOrder();
    }
}
