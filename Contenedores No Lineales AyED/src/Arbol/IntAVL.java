package Arbol;

public class IntAVL extends TreeAVL{

    @Override
    public boolean mayor(Object nodoA, Object nodoB) {
        Integer a = (Integer)nodoA;
        Integer b = (Integer)nodoB;
        return a.intValue() > b.intValue();
    }

    @Override
    public boolean menor(Object nodoA, Object nodoB) {
        Integer a = (Integer)nodoA;
        Integer b = (Integer)nodoB;
        return a.intValue() < b.intValue();
    }

    @Override
    public boolean iguales(Object nodoA, Object nodoB) {
        Integer a = (Integer)nodoA;
        Integer b = (Integer)nodoB;
        return a.intValue() == b.intValue();
    }

    @Override
    public void imprimir(Object nodoInf) {
        System.out.println("Nodo -> " + nodoInf.toString());
    }
    
}
