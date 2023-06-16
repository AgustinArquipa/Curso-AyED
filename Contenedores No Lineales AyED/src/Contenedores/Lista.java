package Contenedores;

public class Lista extends Lista1DEnlz{
    
    @Override
    public boolean equals(Object element1, Object element2){
        return (boolean)element1 == (boolean)element2;
    }

    public String toString(){
        String cad = "[";
        for(int i=0; i<tamaño(); i++){
            if(i == tamaño()-1){
                cad += devolver(i) + "]";
            }else {
                cad += devolver(i) + ", ";
            }
        }
        return cad;
    }
}
