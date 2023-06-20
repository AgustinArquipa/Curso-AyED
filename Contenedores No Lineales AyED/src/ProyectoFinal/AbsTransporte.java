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
    public void muestraVogel(){
        double suma; //Sirve para verificar que resolvimos bien el ejercicio
        while(!this.matrizCosto.isOneRow(infinito) || !this.matrizCosto.isOneColumn(infinito)){
            vogel();
        }

        //Para el 1 ejemplo, tenemos que recuperar ese valor de la listOferta y la posicion para realizar los ultimos pasos
        int posF = this.listaOferta.getPosListaVacia();
        double offert = (double)this.listaOferta.devolver(posF); //Recuperamos ese valor, para luego setear
        this.listaOferta.reemplazar((double)0, posF); //Hacemos la lista oferta todo cero;
        //Realizamos el control
        if(this.listaOferta.listIsCero()){
            suma = 0;
            //En este caso como listOferta es de las filas, tenemos esa fila ahora debemos pedir los valores de la listDemanda
            for(int j=0; j<getOrden2(); j++){
                //Vamos pidiendo elementos de listDemanda y modificanco en cada columna de la posF RECUPERADA
                double currDemand = (double)this.listDemanda.devolver(j);
                suma = suma + currDemand;
                ((Produccion)this.matrizCosto.devolver(posF, j)).setCantidad((int)currDemand);
            }
            if(suma == offert){
                //Ejercicio Resuelto correctamente
                System.out.println("La suma de las cantidades sobrantes es: (Oferta) " + suma);
                System.out.println("El Costo Minimo Calculado es: " + getCostoTotal() + "\n");
                mostrarTransporte();
            }
        }else {
            int posC = this.listDemanda.getPosListaVacia();
            double demand = (double)this.listDemanda.devolver(posC);
            this.listDemanda.reemplazar(0, posC);
            if(this.listDemanda.listIsCero()){
                suma = 0;
                for(int i=0; i<getOrden(); i++){
                    //Pedimos los elementos de la listOferta y modificando para cada fila de la posC RECUPERADA
                    double currOfert = (double)this.listaOferta.devolver(i);
                    suma = suma + currOfert;
                    ((Produccion)this.matrizCosto.devolver(i, posC)).setCantidad((int)currOfert);
                }
                if(suma == demand){
                    System.out.println("La suma de las cantidades sobrantes es: (Demandas) " + suma);
                    System.out.println("El Costo Minimo Calculado es: " + getCostoTotal() + "\n");
                    mostrarTransporte();
                }
            }
        }
    }

    private void vogel(){
        /*  que necesitamos para implementar el metodo de vogel
         * con i manejamos filas, con j manejamos columnas
         * Lista de Penalizaciones para filas y columnas, la manejamos con i, j??
         */
        double dato;
        double datMen, datMen1;
        boolean anuledRowOrColm;
        Lista penalC, penalF;
        
        penalC = new Lista();
        penalF = new Lista();

        //Buscamos las penalidades menores para las Filas
        for(int i=0; i<getOrden(); i++){
            //datMen = infinito;
            Lista listFil = new Lista();
            //datMen1 = infinito;
            for(int j=0; j<getOrden(); j++){
                dato = (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto();

                if((double)((Produccion)this.matrizCosto.devolver(i, j)).getCantidad() == 0
                    && (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto() != infinito){
                    listFil.insertar(dato, j);
                }
            }
            //Pedimo este chequeo antes, ya que cuando hace el ciclo va eliminando y eso no me funciona
            anuledRowOrColm = listFil.anuledRowOrColm(infinito);
            
            datMen = buscMenorPen(listFil, anuledRowOrColm);
            datMen1 = buscMenorPen(listFil, anuledRowOrColm);

            penalF.insertar(Math.abs((int)(datMen-datMen1)), i);
            
        }
        //Buscamos las penalidaddes menores para las columnas
        //Cremos una lista donde pasamos esa columna para este caso y simplementes buscamos los menores y eliminamos de esa lista
        //Lista listCol = new Lista();
        for(int j=0; j<getOrden2(); j++){
            Lista listCol = new Lista();
            //datMen = infinito;
            //datMen1 = infinito;
            for (int i=0; i<getOrden(); i++){
                dato = (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto();

                if((double)((Produccion)this.matrizCosto.devolver(i, j)).getCantidad() == 0
                    && (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto() != infinito){
                    listCol.insertar(dato, i);
                }
                /*if(dato < datMen){
                    if(dato < datMen && dato > datMen1){
                        datMen = dato;
                    }else {
                        datMen1 = dato;
                    }
                }else {
                    datMen1 = dato;
                } */   
            }

            anuledRowOrColm = listCol.anuledRowOrColm(infinito);

            datMen = buscMenorPen(listCol, anuledRowOrColm);
            datMen1 = buscMenorPen(listCol, anuledRowOrColm);
            
            penalC.insertar(Math.abs((int)(datMen-datMen1)), j);
        }

        //System.out.println(penalF + "\n" + penalC);

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
            valorP2 = (int)penalC.devolver(i); //Este valores de columnas, debemos guarda la fila o columna
            if(valorP1 > penalMayorC && valorP1 > valorP2){
                penalMayorF = valorP1; //Preguntamos si es mayor a penalColumna pq si es mayor es el unico
                //SI SE ASIGNA EL VALOR A PENALF, GUARDAMOS UNA POSICION posI, con esto recuperamos la fila
                posI = i;
            }else {
                //Y viceversa para la penalFila, ya que hay un solo mayor
                if(valorP2 > penalMayorF && valorP2 > valorP1){
                    if(valorP2 > penalMayorC){
                        //Cuando entramos preguntamos si pasa para asegurar y cambiar valores
                        penalMayorC = valorP2; //SI ASIGNA EL VALOR A PENALC, GUARDAMOS UNA POSICION posJ
                        posJ = i;   //Recuperamos la columna donde hay que trabajar
                    }
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
                if((double)((Produccion)this.matrizCosto.devolver(i, posJ)).getCosto() < costMenor 
                    && (double)((Produccion)this.matrizCosto.devolver(i, posJ)).getCantidad() == 0){
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
                        ((Produccion)this.matrizCosto.devolver(posFila, posJ)).setCantidad((int)ofertaMen);
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

    //Metodo que me sirve para buscar los elementos menores de esa fila o columna
    private double buscMenorPen(Lista list, boolean anuledRowOrColm){
        //Tenemos que hacer un metodo que nos diga si tenemos fila o columna anulada
        if(!anuledRowOrColm){
            double men = (double)list.devolver(0);
            int posEli = 0; //Posicion que guardamos para eliminar de la lista
            for(int i=1; i<list.tamaño(); i++){
                if((double)list.devolver(i) < men){
                    posEli = i;
                    men = (double)list.devolver(i);
                }
            }
            list.eliminar(posEli);
            return men;
        }else {
            return infinito;
        }
    }

    //Metodo que me devuelve el costo Minimo
    private double getCostoTotal(){
        double sumaCost = 0;
        double costM = 0;
        for(int i=0; i<getOrden(); i++){
            for(int j=0; j<getOrden2(); j++){
                costM = ((Produccion)this.matrizCosto.devolver(i, j)).costMinimo(infinito);
                if(costM != 0){
                    sumaCost = sumaCost + costM;
                }
            }
        }
        return sumaCost;
    }
    //Metodo que muestra como se obtuvo el costo total minimo
    private void mostrarTransporte(){
        Produccion aux;
        System.out.println("El Costo Minimo Total, se obtuvo de: ...");
        for(int i=0; i<getOrden(); i++){
            //i son las plantas productiva
            for(int j=0; j<getOrden2(); j++){
                //j son las ciudades a donde se transporta
                aux = (Produccion)this.matrizCosto.devolver(i, j);
                if(aux.getCosto() != infinito && aux.getCantidad() != 0){
                    System.out.println("Transportar " + aux.getCantidad() + " unidades " +   
                    "de la Planta " + i + " a la Ciudad " + j );
                }
            }
        }
    }
}
