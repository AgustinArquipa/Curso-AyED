package Arbol;

import Recursos.NodoArbolBinario;

public class IntTSB extends TBS{

    @Override
    public boolean equals(Object nodoA, Object nodoB) {
        int elemen1 = (int)nodoA;
        int elemen2 = (int)nodoB;
        return elemen1 == elemen2;
    }

    @Override
    public boolean isLess(Object nodoA, Object nodoB) {
        int elemen1 = (int)nodoA;
        int elemen2 = (int)nodoB;
        return elemen1 < elemen2;
    }

    @Override
    public boolean isOlder(Object nodoA, Object nodoB) {
        int elemen1 = (int)nodoA;
        int elemen2 = (int)nodoB;
        return elemen1 > elemen2;
    }

    @Override
    public void imprimir(Object nodoInfo) {
        System.out.println("Nodo -> " + nodoInfo.toString());
    }
    
    @Override
    public void meter(Object nodoInfo){
        //NodoArbolBinario temp, ant;
        NodoArbolBinario nodo = new NodoArbolBinario(nodoInfo);

        if(estaVacio()){
            this.root = nodo;
        }else {
            meterR(this.root, nodo);
        }
    }

    private void meterR(NodoArbolBinario nodo, NodoArbolBinario hoja){
        if(isLess(hoja.getNodoElement(), nodo.getNodoElement())){
            if(nodo.getHijoIzq() == null){
                nodo.setHijoIzq(hoja);
            }else {
                meterR(nodo.getHijoIzq(), hoja);
            }
        }else {
            if(nodo.getHijoDer() == null){
                nodo.setHijoDer(hoja);
            }else {
                meterR(nodo.getHijoDer(), hoja);
            }
        }
    }
}
