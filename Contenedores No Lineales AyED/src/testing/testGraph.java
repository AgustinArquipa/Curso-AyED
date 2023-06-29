package testing;

import GrafoDirigido.GrafoD;
import GrafoNoDirigido.GrafoND;

public class testGraph {
    public static void main(String[] args){
        GrafoND grafo = new GrafoND();
        grafo.cargarGrafo();
        //grafo.mostrarGrafo();
        //grafo.muestraBPF();
        grafo.muestraBEA();
    }
}
