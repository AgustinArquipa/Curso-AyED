package Arbol;

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
    
}
