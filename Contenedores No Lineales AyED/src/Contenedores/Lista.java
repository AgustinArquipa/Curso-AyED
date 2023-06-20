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
        if(cont == tamaño()){
            response = true; //Si tenemos la misma cantidad que el tamaño de la lista tenemos fila o colum anulada
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
