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
    public void vogel(){
        //Aca deberia ir el otro codigo
        for(int paso=1; paso<=2; paso++){
            //Una ves cumplido el primer ciclo pensamos en recuperar esa posicion de la fila o columna, 
            //ya que recuperado la fila o columna no trabajamos con es fila y es mas facil el control
            int ceroFila = -1; int ceroColumna = -1;
            int i=0; int count = 0;
            int j=0; int count2 = 0;
            while(i<getOrden() && count < 1){
                if((double)this.listaOferta.devolver(i)==0 && count < 1){
                    ceroFila = i;
                    count++; //Esto nose si estara bien, la idea es que termine apenas encuentre el primer 0
                }
                i++;
            }
            while(j<getOrden2() && count2 < 1){
                if((double)this.listDemanda.devolver(j)==0 && count2 < 1){
                    ceroColumna = j;
                    count2++;
                }
                j++;
            }

            muestraVogel(ceroFila, ceroColumna);
        }
    }
    public void muestraVogel(int ceroFila, int ceroColumna){
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
                if(i != ceroFila && (double)((Produccion)this.matrizCosto.devolver(i, j)).getCantidad() == 0){
                    if(dato < datMen && datMen1 < datMen){
                        datMen = dato;
                    }else {
                        datMen1 = dato;
                    }    
                }
            }
            if(dato != infinito){
                penalF.insertar(Math.abs((int)(datMen-datMen1)), i);
            }else {
                penalF.insertar((int)(-1), i);
            }
        }
        //Buscamos las penalidaddes menores para las columnas
        for(int j=0; j<getOrden2(); j++){
            dato = (double)((Produccion)this.matrizCosto.devolver(0, j)).getCosto();
            datMen = dato;
            datMen1 = dato;
            for (int i=1; i<getOrden(); i++){
                dato = (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto();
                if(j != ceroColumna){ //Lo ultimo que hicimos fue esto
                    if(dato < datMen && datMen1 < datMen){
                        datMen = dato;
                    }else {
                        datMen1 = dato;
                    }    
                }else {
                    dato = 0;
                }
            }
            if(dato != infinito){
                penalC.insertar(Math.abs((int)(datMen-datMen1)), j);
            }else {
                penalC.insertar((int)(-1), j);
            }
        }
        System.out.println(penalF + "\n" + penalC);
        //Una ves calculados las penalizaciones, tenemos que buscar el mayor de ellos y elejimo el menor valor 
        //de la matriz de costo y elejimos la menor de la lista de columna y demandas
        double valorOf, valorDe;
        int posI = -1; int posJ = -1;
        int valorP1, valorP2;
        int penalMayorC, penalMayorF;
        penalMayorF = penalMayorC = -1; //Lo usamos como control para saber si es fila o columna
        for (int i=0; i<getOrden(); i++){
            //Con este for recorremos la lista de ofertas
            valorP1 = (int)penalF.devolver(i);
            valorP2 = (int)penalC.devolver(i); //Este valores de de columnas, debemos guarda la fila o columna
            if(valorP1 > penalMayorC && valorP1 > valorP2){
                penalMayorF = valorP1; //Preguntamos si es mayor a penalColumna pq si es mayor es el unico
                //SI SE ASIGNA EL VALOR A PENALF, GUARDAMOS UNA POSICION posI, con esto recuperamos la fila
                posI = i;
            }else {
                //Y viceversa para la penalFila, ya que hay un solo mayor
                if(valorP2 > penalMayorF && valorP2 > valorP1){
                    penalMayorC = valorP2; //SI ASIGNA EL VALOR A PENALC, GUARDAMOS UNA POSICION posJ
                    posJ = i; //Recuperamos la columna donde hay que trabajar
                }
            }
            /*for(int j=0; j<getOrden(); j++){
                //con este dor recorremos la lista de demandas
                //Deberian ser 2 for, asi con i guardamos filas, y con j guardamos columnas
            } */
        }

        //Deberia ser int
        double val1 = -1; double val2 = -1;
        double ofertaMen = -1; double demandMenor = -1; 
        //Una ves encontrado la posicion, si es fila o columna, preguntamos para saber con cual trabajamos
        if(posI != -1 || penalMayorF != -1){
            //Aca trabajamos con la fila
        }
        if(posJ != -1 || penalMayorC != -1){
            //double costMenor = -1;
            int posFila = -1; //Tenemos que guardar la posicion i,j para setear la cantidad y no olvidar de restar
            //Ademas tenemos que buscar el menor de la lista de Oferta o lista de Demanda
            //val1 = (double)this.listaOferta.devolver(posJ); Todo lo de aca preguntamos la ultimo ya que hay que buscar el menor y esa fila
            val1 = (double)this.listDemanda.devolver(posJ); //Este valor no va a cambiar
            /*if(val1 < val2){
                ofertaMen = val1;
                this.listaOferta.insertar((val2-val1), posJ);
            }else {
                demandMenor = val2;
                this.listDemanda.insertar((val1-val2), posJ);
            } */
            //Aca trabajamos con la columna
            double costMenor = (double)((Produccion)this.matrizCosto.devolver(0, posJ)).getCosto();
            posFila = 0;
            for(int i=1; i<getOrden(); i++){
                //Si trabajamos con columna, recorremos filas, y buscamos el menor valor de la matriz
                if((double)((Produccion)this.matrizCosto.devolver(i, posJ)).getCosto() < costMenor){
                    costMenor = (double)((Produccion)this.matrizCosto.devolver(i, posJ)).getCosto();
                    posFila = i;
                }
            }
            val2 = (double)this.listaOferta.devolver(posFila);
            //Ahora realizamos las restas correspondientes
            if(val2 < val1){
                ofertaMen = val2;
                this.listaOferta.reemplazar((val2-val2), posFila);
                this.listDemanda.reemplazar((val1-val2), posJ);
            }else {
                demandMenor = val1;
                this.listDemanda.reemplazar((val1-val1), posJ);
                this.listaOferta.reemplazar((val2-val1), posFila);
            }
            //La lista de oferta se maneja con posicion FILA
            //La lista demanda se maneja con posicion COLUMNA
            //Una ves realizado eso, anulamos fila o columna si en la lista de demanda o de oferta se hace 0
            if((double)this.listaOferta.devolver(posFila)==0){
                //Si devuelve cero esa fila se anula
                Produccion aux;
                //Con este for anulamos la fila escogida
                for (int counter=0; counter<getOrden(); counter++){
                    if(counter == posJ){
                        ((Produccion)this.matrizCosto.devolver(posFila, posJ)).setCantidad((int)ofertaMen);;
                    }else {
                        //Como es fila la que anulamos
                        aux = new Produccion(infinito); //De esta manera lo pense
                        this.matrizCosto.actualizar(aux, posFila, counter);
                    }
                    
                }
            }else {
                if((double)this.listDemanda.devolver(posJ)==0){
                    //Esta columna se anula
                }
            }
        }
    }
}
