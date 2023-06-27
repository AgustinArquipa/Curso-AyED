package Contenedores;

public class Lista extends Lista1DEnlz{
    
    @Override
    public boolean equals(Object element1, Object element2){
        return (boolean)element1 == (boolean)element2;
    }

    //Metodo que me dice si tengo una fila o columna anulada
    public boolean anuledRowOrColm(double infinito){
        boolean response = false;
        double currCost = 0;
        int cont = 0;
        for(int i=0; i<tamaño(); i++){
            currCost = (double)devolver(i);
            if(currCost == infinito){
                cont++;
            }
        }
        if(cont >= tamaño()-1){
            response = true; //Si tenemos la misma cantidad que el tamaño de la lista tenemos fila o colum anulada
        }
        return response;
    }
    //Metodo en donde busco elementos de la lista distinto de cero
    public int getPosListaVacia(){
        int pos = -1;
        for(int i=0; i<tamaño(); i++){
            double actual = (double)devolver(i);
            if(actual != 0){
                pos = i;
            }
        }
        
        return pos;
    }
    //Metodo que nos dice si una lista tiene un elemento
    public boolean listHaveOneElement(){
        int cont = 0;
        boolean response = false;
        for (int i=0; i<tamaño(); i++){
            if((double)devolver(i)!= 0){
                cont++;
            }
        }
        if(cont == 1){
            response = true;
        }
        return response;
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
