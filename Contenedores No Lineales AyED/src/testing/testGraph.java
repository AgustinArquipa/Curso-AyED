package testing;

import GrafoNoDirigido.GradoND;

public class testGraph {
    public static void main(String[] args){
        GradoND grafo = new GradoND();
        grafo.cargarGrafo();
        grafo.mostrarGrafo();
    }
}
