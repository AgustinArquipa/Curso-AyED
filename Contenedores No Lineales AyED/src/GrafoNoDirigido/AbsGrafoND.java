package GrafoNoDirigido;

import Contenedores.AbsGrafo;
import Contenedores.Lista;
import Recursos.Conexion;

public abstract class AbsGrafoND extends AbsGrafo{
    //builders
    public AbsGrafoND(int ordenGrafo){
        super(ordenGrafo);
    }
    public AbsGrafoND(){
        super(0);
    }
    //methods that Graph Not Diriged
    private void Prim(int vertex){
        Lista listaMenorCosto, listaMasCercano;
        listaMenorCosto = new Lista();
        listaMasCercano = new Lista();
        double minCost, currCost, newCost;
        int minVertex, w;

        for(int i=0; i<getOrden(); i++){
            listaMenorCosto.insertar(this.matrizCosto.devolver(vertex, i), i);
            listaMasCercano.insertar(vertex, i);
        }

        listaMasCercano.reemplazar(-1, vertex);

        for(int i=1; i<getOrden(); i++){
            minCost = infinito;
            minVertex = -1;

            for(int j=0; j<getOrden(); j++){
                if((int)listaMasCercano.devolver(j) != -1 && (double)listaMenorCosto.devolver(j) != infinito){
                    currCost = (double)listaMenorCosto.devolver(j);
                    if(currCost < minCost){
                        minCost = currCost;
                        minVertex = j;
                    }
                }
            }

            System.out.println("La Arista: " + listaMasCercano.devolver(minVertex) + " " + minVertex);
            listaMenorCosto.reemplazar(infinito, minVertex);
            listaMasCercano.reemplazar(-1, minVertex);

            for (int j=0; j<getOrden(); j++){
                if(j!=minVertex){
                    currCost = (double)listaMenorCosto.devolver(j);
                    newCost = (double)this.matrizCosto.devolver(minVertex, j);
                    w = (int)listaMasCercano.devolver(j);
                    if(newCost < currCost && w > -1){
                        listaMenorCosto.reemplazar(newCost, j);
                        listaMasCercano.reemplazar(minVertex, j);
                    }
                }
            }
        }
    }
    //method that use algorithim Prim
    public void muestraPrim(int vertex){
        if (vertex >= 0 && vertex < getOrden()){
            Prim(vertex);
        }
    }

    private void Kruskal(){
        double currCost; 
        int cont, n, k, posI, posJ; 
        boolean flag;
        Conexion connect;
    }
}
