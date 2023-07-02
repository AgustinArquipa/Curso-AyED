package Recursos;

public class NodoArbolBinario {
    //Attributes
    private Object nodoObject;
    private NodoArbolBinario leftChild, rightChild;
    //builders
    public NodoArbolBinario(){
        this(null, null, null);
    }
    public NodoArbolBinario(Object nodoObject){
        this(nodoObject, null, null);
    }
    public NodoArbolBinario(Object nodObject, NodoArbolBinario hijoIzq, NodoArbolBinario hijoDer){
        this.nodoObject = nodObject;
        this.leftChild = hijoIzq;
        this.rightChild = hijoDer;
    }
    //methods, getters y setters
    public Object getNodoElement(){return this.nodoObject;}
    public void setNodoElement(Object nodoObject){
        this.nodoObject = nodoObject;
    }

    public NodoArbolBinario getHijoIzq(){return this.leftChild;}
    public void setHijoIzq(NodoArbolBinario leftChild){
        this.leftChild = leftChild;
    }

    public NodoArbolBinario getHijoDer(){return this.rightChild;}
    public void setHijoDer(NodoArbolBinario rightChild){
        this.rightChild = rightChild;
    }
}
