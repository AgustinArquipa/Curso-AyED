package Recursos;

public interface OperacionesArbolBinario {
    //TAD que implenta un arbol
    public void meter(Object nodoInfo);
    public boolean esta(Object nodoInfo);
    public void sacar(Object nodoInfo);
    public boolean estaVacio();
    public void limpiar();
    public NodoArbolBinario devuelve(Object nodoInfo);
    //Metodos que sirven para mostrar
    public void muestraInOrder();
    public void muestraPreOrder();
    public void muestraPostOrder();
    //Metodos que sirven para calcular operaciones de un Arbol
    public int numberSheets(NodoArbolBinario nodo);
    public int treeHeight(NodoArbolBinario nodo);
}
