package testing;

import Arbol.IntTSB;

public class testTreeInt {
    
    public static void main(String[] args){
        IntTSB tree = new IntTSB();
        tree.meter(10);
        tree.meter(7);
        tree.meter(20);
        tree.meter(15);
        tree.meter(35);
        tree.meter(27);
        tree.meter(38);
        tree.meter(3);
        tree.meter(1);
        tree.meter(8);
        tree.meter(3);
        tree.meter(2);
        tree.meter(6);

        //System.out.println("Mostrando en inOrder: ");
        //tree.muestraInOrder();
        System.out.println("\nMostrando en preOrder: ");
        tree.muestraPreOrder();
        //System.out.println("\nMostrando en postOrder: ");
        //tree.muestraPostOrder();
        System.out.println("\nEliminando 15, 7 y 20");
        tree.sacar(15);
        tree.sacar(7);
        tree.sacar(20);

        System.out.println("\nDespues de eliminar");
        tree.muestraPreOrder();
    }
}
