package ProyectoFinal;

import Contenedores.MatrizArr;

public class MatrizTransporte extends MatrizArr{
    //builders
    public MatrizTransporte(int rows, int columns){
        super(rows, columns);
        //Pensamos este constructor en el caso de que tengamos 3 plantas productoras y 4 ciudades
        //Es generico este constructor
    }
    public MatrizTransporte(int ordenGrafo){
        super(ordenGrafo, ordenGrafo);
        //En caso de que tengamos 3 plantas y 3 ciudades
    }
    //methods
    public void mostrarMatriz(){
        for(int i=0; i<getRows(); i++){
            for(int j=0; j<getColumns(); j++){
                //System.out.print("\nDestino " + (j+1) + "\n");
                System.out.print(devolver(i, j) + "\t");
            }
            System.out.println();
        }
    }
}
