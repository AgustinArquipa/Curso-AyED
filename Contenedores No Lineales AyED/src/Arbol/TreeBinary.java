package Arbol;

import Recursos.NodoArbolBinario;
import Recursos.OperacionesArbolBinario;

public abstract class TreeBinary implements OperacionesArbolBinario{
    protected NodoArbolBinario root; //la raiz del arbol
    //builders
    public TreeBinary(){
        limpiar();
    }
    //methods abstract
    public abstract void imprimir(Object nodoInfo);
    //methods that class
    public boolean estaVacio(){
        return this.root == null;
    }
    public void limpiar(){
        this.root = null;
    }
    //method that get know elements the triee
    public void muestraInOrder(){
        inOrder(this.root);
    }
    private void inOrder(NodoArbolBinario nodo){
        if(nodo != null){
            inOrder(nodo.getHijoIzq());
            imprimir(nodo.getNodoElement());
            inOrder(nodo.getHijoDer());
        }
    }
    //methods the tree
    public int numberSheets(NodoArbolBinario nodo){
        if (nodo == null){
            return 0;
        }else {
            if(nodo.getHijoIzq()==null && nodo.getHijoDer()==null){
                return 1;
            }else {
                return numberSheets(nodo.getHijoIzq()) + numberSheets(nodo.getHijoDer());
            }
        }
    }
    //Con este metodo recupero la cantidad de hojas del arbol
    public int getNumberSheets(){
        return numberSheets(this.root);
    }
    public int treeHeight(NodoArbolBinario nodo){
        int alturaIzq, alturaDer;
        
        if(nodo == null){
            return -1;
        }else {
            alturaIzq = treeHeight(nodo.getHijoIzq());
            alturaDer = treeHeight(nodo.getHijoDer());

            if(alturaIzq > alturaDer){
                return alturaIzq + 1;
            }else {
                return alturaDer + 1;
            }
        }
    }
    //Con este metodo recupero la altura del arbol
    public int getTreeHeight(){
        return treeHeight(this.root);
    }

    //Metdos con el que recupero la cantidad de nodos
    private int numberNodos(NodoArbolBinario nodo){
        if (nodo == null){
            return 0;
        }else {
            return 1 + numberNodos(nodo.getHijoIzq()) + numberNodos(nodo.getHijoDer());
        }
    }

    public int getNumberNodos(){
        return numberNodos(this.root);
    }
}
