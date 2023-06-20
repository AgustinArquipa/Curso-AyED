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
    //method that we allow know, if we have one Row or one Column
    public boolean isOneRow(double infinito){
        boolean response = false;
        int cont = 0;
        for(int i=0; i<getRows(); i++){
            //Contabilizamos las filas
            for (int j=0; j<getColumns(); j++){
                double currCant = ((Produccion)devolver(i, j)).getCantidad();
                double currCost = ((Produccion)devolver(i, j)).getCosto();
                if(currCant == 0 && currCost != infinito){
                    cont++;
                }
            }
        }
        if(cont == getColumns()){
            response = true;
        }
        return response;
    }
    public boolean isOneColumn(double infinito){
        boolean response = false;
        int cont = 0;
        for(int j=0; j<getColumns(); j++){
            //Contabilizamos columnas
            for(int i=0; i<getRows(); i++){
                double currCant = ((Produccion)devolver(i, j)).getCantidad();
                double currCost = ((Produccion)devolver(i, j)).getCosto();
                if(currCant == 0 && currCost != infinito){
                    cont++;
                }
            }
        }
        if(cont == getRows()){
            response = true;
        }
        return response;
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
