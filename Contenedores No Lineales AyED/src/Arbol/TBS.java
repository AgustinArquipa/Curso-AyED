package Arbol;

import Recursos.NodoArbolBinario;

//Binary search tree (Arbol binario de busqueda)
public abstract class TBS extends TreeBinary{
    //methods abstracts that class
    public abstract boolean equals(Object nodoA, Object nodoB);
    public abstract boolean isLess(Object nodoA, Object nodoB);
    public abstract boolean isOlder(Object nodoA, Object nodoB);

    public void meter(Object nodoInfo){
        NodoArbolBinario temp, ant;
        NodoArbolBinario nodo = new NodoArbolBinario(nodoInfo);

        if(estaVacio()){
            this.root = nodo;
        }else {
            temp = this.root;
            ant = null;
            while (temp != null){
                ant = temp;
                if (isOlder(temp.getNodoElement(), nodoInfo)){
                    temp = temp.getHijoIzq();
                }else {
                    temp = temp.getHijoDer();
                }
            }
            if (isLess(ant.getNodoElement(), nodoInfo) || equals(ant.getNodoElement(), nodoInfo)){
                ant.setHijoDer(nodo);
            }else {
                ant.setHijoIzq(nodo);
            }
        }
    }

    //metodo privado que nos devuelve el nodo
    private NodoArbolBinario devuelveNodo(Object nodoInfo){
        NodoArbolBinario nodo = null;
        boolean response = false;

        nodo = this.root;

        while (nodo != null && !response){
            if(equals(nodo.getNodoElement(), nodoInfo)){
                response = true;
            }else {
                if (isLess(nodo.getNodoElement(), nodoInfo)){
                    nodo = nodo.getHijoDer();
                }else {
                    nodo = nodo.getHijoIzq();
                }
            }
        }
        return nodo;
    }
}
