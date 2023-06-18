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

    public abstract void cargarGrafo();
    public abstract void mostrarGrafo();

    public int getOrden(){
        return this.ordenGrafo;
    }
    public int getOrden2(){
        return this.ordenGrafo2;
    }
    //Metodos de Vogel para el calculo del transporte
    private void vogel(){

    }
    public void muestraVogel(){
        /*  que necesitamos para implementar el metodo de vogel
         * con i manejamos filas, con j manejamos columnas
         * Lista de Penalizaciones para filas y columnas, la manejamos con i, j??
         */
        double dato;
        double datMen, datMen1;
        Lista penalC, penalF;
        
        penalC = new Lista();
        penalF = new Lista();

        //Buscamos las penalidades menores para las Filas
        for(int i=0; i<getOrden(); i++){
            dato = (double)((Produccion)this.matrizCosto.devolver(i, 0)).getCosto();
            datMen = dato;
            datMen1 = dato;
            for(int j=1; j<getOrden(); j++){
                dato = (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto();
                if(dato < datMen && datMen1 < datMen){
                    datMen = dato;
                }else {
                    datMen1 = dato;
                }
            }
            penalF.insertar(Math.abs((int)(datMen-datMen1)), i);
        }
        //Buscamos las penalidaddes menores para las columnas
        for(int j=0; j<getOrden2(); j++){
            dato = (double)((Produccion)this.matrizCosto.devolver(0, j)).getCosto();
            datMen = dato;
            datMen1 = dato;
            for (int i=1; i<getOrden(); i++){
                dato = (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto();
                if(dato < datMen && datMen1 < datMen){
                    datMen = dato;
                }else {
                    datMen1 = dato;
                }
            }
            penalC.insertar(Math.abs((int)(datMen-datMen1)), j);
        }
        System.out.println(penalF + "\n" + penalC);
        
    }
}
