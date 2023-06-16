package GrafoDirigido;

import Contenedores.AbsGrafo;
import Contenedores.Lista;
import Contenedores.MatrizGrafo;
import Recursos.OperacionesGD;

public abstract class AbsGrafoD extends AbsGrafo implements OperacionesGD{
    //Attributes
    protected MatrizGrafo matrizCostoF, matrizCaminoF;
    protected Lista listaDistancia, listaCamino, listaSolucion;
    //builders
    public AbsGrafoD(int ordenGrafo){
        super(ordenGrafo);
    }
    public AbsGrafoD(){
        super(0);
    }
    //methods
    public void muestraDijkstra(int startVertex){
        double currCost;
        int w;
        
        Dijkstra(startVertex);

        for(int v=0; v<getOrden(); v++){
            System.out.println("Vertice: " + v);
            if(v != startVertex){
                currCost = (double)this.listaDistancia.devolver(v);
                System.out.println("Costo desde: " + startVertex + " a " + v + " -> " + currCost);

                System.out.println("Mostrando un camino desde: " + v + " a " + startVertex);
                w = (int)this.listaCamino.devolver(v);

                do {
                    //Recordemos que al inicializar cambiamos todos los -1 salvo el startVertex
                    System.out.println("Camino: " + v);
                    w = (int)listaCamino.devolver(w);
                }while(w != -1);
            }
        }
    }

    private void Dijkstra(int startVertex){

    }

    public void muestraFloyd(){
        
    }
}
