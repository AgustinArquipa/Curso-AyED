package testing;

import GrafoNoDirigido.GrafoND;

public class testGraph {
    public static void main(String[] args){
        GrafoND grafo = new GrafoND();
        grafo.cargarGrafo();
        //grafo.muestraBPF();
        grafo.muestraBEA();
        //grafo.mostrarGrafo();
    }
}
