package ProyectoFinal;

import Contenedores.Lista;

public abstract class AbsTransporte implements OperacionesTF{
    //Attributes
    protected MatrizTransporte matrizCosto;
    protected int ordenGrafo, ordenGrafo2;
    protected static double infinito = 10000;
    //Solucionar en caso de que la matriz no sea equilibrada
    protected Lista listDemanda, listaOferta;
    //builders
    public AbsTransporte(int ordenGrafo, int ordenGrafo2){
        this.ordenGrafo = ordenGrafo;
        this.matrizCosto = new MatrizTransporte(getOrden(), getOrden2());
    }
    public AbsTransporte(){
        this(0, 0);
    }
    //methods
    public void muestraVogel(){
        
    }

    public abstract void cargarGrafo();
    public abstract void mostrarGrafo();

    public int getOrden(){
        return this.ordenGrafo;
    }
    public int getOrden2(){
        return this.ordenGrafo2;
    }
}
