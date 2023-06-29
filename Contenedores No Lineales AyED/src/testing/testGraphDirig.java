package testing;

import GrafoDirigido.GrafoD;

public class testGraphDirig {
    
    public static void main(String[] args){
        GrafoD grafo = new GrafoD();
        grafo.cargarGrafo();
        //grafo.muestraBEA();
        grafo.muestraDijkstra(0);
        //grafo.mostrarGrafo();
    }
}
