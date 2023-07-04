package Recursos;

public class NodoAVL {
    private Object nodoInfo;
    private NodoAVL leftChild, rightChild;
    private int altura;
    //builders
    public NodoAVL(){
        this(null, null, null, 0);
    }
    public NodoAVL(Object nodoInfo){
        this(nodoInfo, null, null, 0);
    }
    public NodoAVL(Object nodoInfo, NodoAVL leftChild, NodoAVL rightChild, int altura){
        this.nodoInfo = nodoInfo;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.altura = altura;
    }
    //Getters y Setters
    public Object getNodoInfo(){return this.nodoInfo;}
    public void setNodoInfo(Object nodoInfo){
        this.nodoInfo = nodoInfo;
    }

    public NodoAVL getLeftChild(){return this.leftChild;}
    public void setLeftChild(NodoAVL leftChild){
        this.leftChild = leftChild;
    }

    public NodoAVL getRightChild(){return this.rightChild;}
    public void setRightChild(NodoAVL rightChild){
        this.rightChild = rightChild;
    }

    public int getHeight(){return this.altura;}
    public void setHeight(int altura){
        this.altura = altura;
    }
}
