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
            }
        }

        //Como que queda si mostramos el camino al final del codigo
        //System.out.println("Lista de Caminos: " + this.listaCamino);
        int v = getOrden() - 1;
        System.out.println("Camino: " + v);
        w = (int)this.listaCamino.devolver(v);
        do {
            System.out.println("Camino: " + w);
            w = (int)this.listaCamino.devolver(w);
        }while(w != -1);
    }

    private void Dijkstra(int startVertex){
        double minCost, currCost, arcCost;
        int minVertex, vertex;

        this.listaDistancia = new Lista();
        this.listaCamino = new Lista();
        this.listaSolucion = new Lista();

        for (int i=0; i<getOrden(); i++){
            this.listaSolucion.insertar(-1, i);
            this.listaCamino.insertar(-1, i);
            this.listaDistancia.insertar(infinito, i);
        }
        this.listaSolucion.reemplazar(startVertex, startVertex);

        for (int i=0; i<getOrden();i++){
            if(i != startVertex){
                this.listaDistancia.reemplazar(this.matrizCosto.devolver(startVertex, i), i);
                this.listaCamino.reemplazar(startVertex, i);
            }
        }

        for (int i=1; i<getOrden(); i++){
            minCost = infinito;
            minVertex = -1;

            for (int w=0; w<getOrden(); w++){
                if (w != startVertex){
                    currCost = (double)this.listaDistancia.devolver(w);
                    vertex = (int)this.listaSolucion.devolver(w);
                    if (currCost < minCost && vertex == -1){
                        minCost = currCost;
                        minVertex = w;
                    }
                }
            }

            if (minVertex != -1){
                System.out.println("It: " + i + " vertice Minimo: " + minVertex + " - Costo Minimo: " + minCost);
                this.listaSolucion.reemplazar(minVertex, minVertex);
                this.listaDistancia.reemplazar(minCost, minVertex);

                for (int v=0; v<getOrden(); v++){
                    vertex = (int)this.listaSolucion.devolver(v);
                    if(vertex == -1){
                        arcCost = (double)this.matrizCosto.devolver(minVertex, v);
                        currCost = (double)this.listaDistancia.devolver(v);
                        if(minCost + arcCost < currCost){
                            this.listaDistancia.reemplazar(minCost + arcCost, v);
                            this.listaCamino.reemplazar(minVertex, v);
                        }
                    }
                }
            }
        }
    }

    public void muestraFloyd(){
        this.matrizCaminoF = new MatrizGrafo(getOrden());
        this.matrizCostoF = new MatrizGrafo(getOrden());

        double costoF;

        for(int i=0; i<getOrden(); i++){
            matrizCostoF.actualizar((double)0, i, i);
        }

        for(int i=0; i<getOrden(); i++){
            for(int j=0; j<getOrden(); j++){
                if(i != j){
                    costoF = (double)this.matrizCosto.devolver(i, j);
                    matrizCostoF.actualizar(costoF, i, j);
                }
            }
        }

        Object costo;
        for(int k=0; k<getOrden(); k++){
            for(int i=0; i<getOrden(); i++){
                for(int j=0; j<getOrden(); j++){
                    if(((Double)matrizCostoF.devolver(i, k)).doubleValue() + ((Double)matrizCostoF.devolver(k, j)).doubleValue()
                        < ((Double)this.matrizCostoF.devolver(i, j)).doubleValue()){
                        costo = (Double)this.matrizCostoF.devolver(i, k) + (Double)this.matrizCostoF.devolver(k, j);
                        matrizCostoF.actualizar(costo, i, j);
                        matrizCaminoF.actualizar(k, i, j); //Para obtener el camino segun Floyd
                    }
                }
            }
        }

        System.out.println("Floyd: ");
        for(int i=0; i<getOrden(); i++){
            for (int j=0; j<getOrden(); j++){
                if(i != j){
                    costoF = (double)this.matrizCostoF.devolver(i, j);
                    if(costoF != infinito){
                        System.out.println("Costo Minimo de " + i + " hasta " + j + ": " + costoF);
                    }
                }
            }
        }
    }

    public void muestraCaminoFloyd(int origen, int destino){
        double hayCamino = ((Double)this.matrizCostoF.devolver(origen, destino)).doubleValue();
        if(hayCamino != infinito){
            System.out.print("Camino entre " + origen + " y " + destino + ": ");
            System.out.print(origen);
            buscarCaminoFloyd(origen, destino);
            System.out.print(" " + destino);
            System.out.println();
        }else {
            System.out.println("No hay Camino entre: " + origen + " - " + destino);
        }
    }

    private void buscarCaminoFloyd(int i, int j){
        Object valor = this.matrizCaminoF.devolver(i, j);
        if(valor != null){
            int k = ((Integer)valor).intValue();
            buscarCaminoFloyd(i, k);
            System.out.print(" " + k);
            buscarCaminoFloyd(k, j);
        }else {
            System.out.print(" |");
        }
    }
}
