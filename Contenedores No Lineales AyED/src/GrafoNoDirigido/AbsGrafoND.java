package GrafoNoDirigido;

import Contenedores.AbsGrafo;
import Contenedores.GraphPriorityQueue;
import Contenedores.IntegerSet;
import Contenedores.Lista;
import Recursos.Conexion;
import Recursos.OperacionesGND;

public abstract class AbsGrafoND extends AbsGrafo implements OperacionesGND{
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

    private void kruskal(){
        double currCost; 
        int cont, n, k, posI, posJ; 
        boolean flag;
        Conexion connect;
        GraphPriorityQueue colaP = new GraphPriorityQueue();
        IntegerSet conjuntoE = new IntegerSet();
        IntegerSet conjuntoU = new IntegerSet();

        Lista listaArbol = new Lista();

        for(int i=0; i<getOrden(); i++){
            conjuntoE.meter(i);
            listaArbol.insertar(conjuntoE, i);
        }

        for(int i=0; i<getOrden(); i++){
            for(int j=i+1; j<getOrden(); j++){
                currCost = (double)this.matrizCosto.devolver(i, j);
                if(currCost != infinito){
                    colaP.meter(new Conexion(i, j, currCost));
                }
            }
        }

        cont = getOrden();

        while (cont > 1){
            connect = (Conexion) colaP.sacar();
            System.out.println("Arista: " + connect.getVerticeI() + " " + connect.getVerticeJ() + ": " + connect.getCostoConexion());

            n = listaArbol.tamaño()-1;
            k = 0;
            flag = false;
            posI = posJ = -1;
            while(k <= n && !flag){
                conjuntoE = (IntegerSet)listaArbol.devolver(k);
                System.out.println("Mostrando conjunto parcial de vertices K = " + k);
                System.out.println(conjuntoE);
                if(conjuntoE.pertenece(connect.getVerticeI())){
                    posI = k;
                }
                if(conjuntoE.pertenece(connect.getVerticeJ())){
                    posJ = k;
                }
                if(posI > 0 && posJ > 0 && posI == posJ){
                    flag = true;
                } else {
                    k++;
                }
            }

            if(!flag){
                System.out.println("Arbol Minimo, Arista: " + connect.getVerticeI() + " " + connect.getVerticeJ());
                conjuntoU = new IntegerSet();
                conjuntoU.Union((Integer)listaArbol.devolver(posI), (IntegerSet)listaArbol.devolver(posJ));
                listaArbol.reemplazar(conjuntoU, posI);
                listaArbol.eliminar(posJ);
                cont--;
            }
        }
    }

    public void muestraKruskal(){
        kruskal();
    }
}
