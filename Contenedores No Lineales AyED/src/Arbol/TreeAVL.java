package Arbol;

import Recursos.NodoAVL;

public abstract class TreeAVL {
    protected NodoAVL root;

    //methods abstarcts that class
    public abstract boolean mayor(Object nodoA, Object nodoB);
    public abstract boolean menor(Object nodoA, Object nodoB);
    public abstract boolean iguales(Object nodoA, Object nodoB);
    public abstract void imprimir(Object nodoInf);

    //methods that class TREEAVL
    public boolean estaVacio(){
        return this.root == null;
    }
    public void meterAVL(Object nodoInfo){
        System.out.println("Metiendo -> " + nodoInfo.toString());
        this.root = meterR(this.root, nodoInfo);
    }
    private NodoAVL meterR(NodoAVL nodo, Object nodoInfo){
        int b, izq, der;
        if(nodo == null){
            nodo = new NodoAVL(nodoInfo);
        }else {
            if(mayor(nodo.getNodoInfo(), nodoInfo)){
                nodo.setLeftChild(meterR(nodo.getLeftChild(), nodoInfo));
                nodo = balancear(nodo);
            } else {
                nodo.setRightChild(meterR(nodo.getRightChild(), nodoInfo));
                nodo = balancear(nodo);
            }
        }

        izq = altura(nodo.getLeftChild());
        der = altura(nodo.getRightChild());

        b = max(izq, der) + 1;
        nodo.setHeight(b);

        return nodo;
    }
    //methods that are static the class AVL
    private static int altura(NodoAVL nodo){
        if(nodo == null){
            return -1;
        }else {
            return nodo.getHeight();
        }
    }
    private static int max(int heightIzq, int heightDer){
        if (heightIzq > heightDer){
            return heightIzq;
        }else {
            return heightDer;
        }
    }
    //Metodo para balancear un arbol no AVL
    public NodoAVL balancear(NodoAVL nodo){
        if(altura(nodo.getLeftChild()) - altura(nodo.getRightChild()) == 2){
            System.out.println("Hay desequilibrio a la izquierda <-");
            //El desequilibrio esta en la izquierda puede ser simple o doble
            if(altura(nodo.getLeftChild().getLeftChild()) >= altura(nodo.getLeftChild().getRightChild())){
                System.out.println("-> Rot. Simple a la Derecha");
                return rotacionSimple(nodo, false);
            }else {
                System.out.println("->-> Rot. Doble a la Derecha");
                return rotacionDoble(nodo, false);
            }
        }else {
            if(altura(nodo.getRightChild()) - altura(nodo.getLeftChild()) == 2){
                System.out.println("Hay desequilibrio a la derecha ->");
                //El desequilibrio esta en la derecha
                if (altura(nodo.getRightChild().getRightChild()) >= altura(nodo.getRightChild().getLeftChild())){
                    System.out.println("<- Rot. Simple a Izquierda");
                    return rotacionSimple(nodo, true);
                }else {
                    return rotacionDoble(nodo, true);
                }

            }else {
                return nodo;
            }
        }
    }

    public NodoAVL rotacionSimple(NodoAVL nodo, boolean isLeft){
        NodoAVL temp;
        if(isLeft){
            temp = nodo.getRightChild();
            nodo.setRightChild(temp.getLeftChild());
            temp.setLeftChild(nodo);

            nodo.setHeight(max(altura(nodo.getLeftChild()), altura(nodo.getRightChild())) + 1);
            temp.setHeight(max(altura(nodo.getRightChild()), nodo.getHeight()) + 1);
        }else {
            temp = nodo.getLeftChild();
            nodo.setLeftChild(temp.getRightChild());
            temp.setRightChild(nodo);

            nodo.setHeight(max(altura(nodo.getLeftChild()), altura(nodo.getRightChild())) + 1);
            temp.setHeight(max(altura(nodo.getLeftChild()), nodo.getHeight()) + 1);
        }
        return temp;
    }

    public NodoAVL rotacionDoble(NodoAVL nodo, boolean isLeft){
        if(isLeft){
            //Rotacion simple a derecha sobre el hijo derecho del nodo
            //desequelibrado
            //Rotacion simple a izquierda sobre el nodo desequilibrado
            nodo.setRightChild(rotacionSimple(nodo.getRightChild(), false));
            return rotacionSimple(nodo, true);
        }else {
            //Rotacion simple a izquierda sobre el hijo izquierdo del nodo
            //Desequilibrado
            //Rotacion simple a derecha sobre el nodo desequilibrado
            nodo.setLeftChild(rotacionSimple(nodo.getLeftChild(), true));
            return rotacionSimple(nodo, false);
        }
    }
}
