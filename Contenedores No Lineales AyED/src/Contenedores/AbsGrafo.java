package Contenedores;

import Recursos.OperacionesG;

public abstract class AbsGrafo implements OperacionesG{
    //attributes
    protected MatrizGrafo matrizCosto; //Representa una matriz de costo, que se interpreta atraves de un grafo
    protected int ordenGrafo;
    protected static double infinito = 10000;
    //builders
    public AbsGrafo(int ordenGrafo){
        this.ordenGrafo = ordenGrafo;
        this.matrizCosto = new MatrizGrafo(getOrden());
    }
    public AbsGrafo(){
        this(0);
    }
    //methods that class
    public int getOrden(){
        return this.ordenGrafo;
    }

    public abstract void cargarGrafo();
    public abstract void mostrarGrafo();
    
    //methods that class Graphs
    private void bpf(Lista listaMarca, int v){
        boolean marcado;
        double currCost;

        listaMarca.reemplazar(true, v);
        System.out.println("Vertice Visitado: " + v);

        for (int w=0; w<getOrden(); w++){
            marcado = (boolean)listaMarca.devolver(w);
            currCost = (double)this.matrizCosto.devolver(v, w);
            if (currCost!=infinito && !marcado){
                bpf(listaMarca, w);
            }
        }
    }

    public void muestraBPF(){
        Lista listaMarca; //Para marcar las aristas visitadas, recordar que lista es una lista doblemente enlazada
        boolean marcado;

        listaMarca = new Lista();
        for(int v=0; v<getOrden(); v++){
            listaMarca.insertar(false, v);
        }

        for(int v=0; v<getOrden(); v++){
            marcado = (boolean)listaMarca.devolver(v);
            if(!marcado){
                bpf(listaMarca, v);
            }
        }
    }

    private void bea(Lista listaMarca, int v){
        boolean marcado;
        double currCost;
        Queu cola;
        int w;

        listaMarca.reemplazar(true, v);
        System.out.println("Vertice: " + v);
        cola = new Queu();
        cola.meter(v);

        while(!cola.estaVacia()){
            w = (int)cola.sacar();
            for(int z=0; z<getOrden(); z++){
                marcado = (boolean)listaMarca.devolver(z);
                currCost = (double)this.matrizCosto.devolver(w, z);
                if(currCost != infinito && !marcado){
                    listaMarca.reemplazar(true, z);
                    cola.meter(z);
                    System.out.println("Arista visitada: " + w + " - " + z);
                }
            }
        }
    }
    public void muestraBEA(){
        Lista listaMarca;
        boolean marcado;

        listaMarca = new Lista();
        for(int v=0; v<getOrden(); v++){
            listaMarca.insertar(false, v);
        }

        for(int v=0; v<getOrden(); v++){
            marcado = (boolean)listaMarca.devolver(v);
            if(!marcado){
                bea(listaMarca, v);
            }
        }
    }
}
