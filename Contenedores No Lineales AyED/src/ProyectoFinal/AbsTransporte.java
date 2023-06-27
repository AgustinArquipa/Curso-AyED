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
        
        while(!this.listaOferta.listHaveOneElement() 
            && !this.listDemanda.listHaveOneElement()){

            double dato;
            double datMen, datMen1;
            boolean anuledRowOrColm;
            Lista penalF, penalC;

            penalC = new Lista();
            penalF = new Lista();

            //Buscamos las penalidades menores para las Filas
            for(int i=0; i<getOrden(); i++){
                int cont = 0;
                //datMen = infinito;
                Lista listFil = new Lista();
                //datMen1 = infinito;
                for(int j=0; j<getOrden2(); j++){
                    dato = (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto();

                    if((double)((Produccion)this.matrizCosto.devolver(i, j)).getCantidad() == 0
                        && (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto() != infinito){
                        listFil.insertar(dato, cont);
                        cont++;
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
                int cont = 0;
                Lista listCol = new Lista();
                //datMen = infinito;
                //datMen1 = infinito;
                for (int i=0; i<getOrden(); i++){
                    dato = (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto();

                    if((double)((Produccion)this.matrizCosto.devolver(i, j)).getCantidad() == 0
                        && (double)((Produccion)this.matrizCosto.devolver(i, j)).getCosto() != infinito){
                        listCol.insertar(dato, cont);
                        cont++;
                    }   
                }

                anuledRowOrColm = listCol.anuledRowOrColm(infinito);

                datMen = buscMenorPen(listCol, anuledRowOrColm);
                datMen1 = buscMenorPen(listCol, anuledRowOrColm);
                
                penalC.insertar(Math.abs((int)(datMen-datMen1)), j);
            }
            //Ejecutamos el metodo de vogel
            vogel(penalF, penalC);
        }

        double suma; //Sirve para verificar que resolvimos bien el ejercicio
        //Para el 1 ejemplo, tenemos que recuperar ese valor de la listOferta y la posicion para realizar los ultimos pasos
        if(this.listaOferta.listHaveOneElement()){
            int posF = this.listaOferta.getPosListaVacia();
            double offert = (double)this.listaOferta.devolver(posF); //Recuperamos ese valor, para luego setear
            this.listaOferta.reemplazar((double)0, posF); //Hacemos la lista oferta todo cero;
            //Realizamos el control
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
        }
        if(this.listDemanda.listHaveOneElement()){
            int posC = this.listDemanda.getPosListaVacia();
            double demand = (double)this.listDemanda.devolver(posC);
            this.listDemanda.reemplazar((double)0, posC);
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

    private void vogel(Lista penalF, Lista penalC){
        /*  que necesitamos para implementar el metodo de vogel
         * con i manejamos filas, con j manejamos columnas
         * Lista de Penalizaciones para filas y columnas, la manejamos con i, j??
         */

        //System.out.println(penalF + "\n" + penalC);

        //Una ves calculados las penalizaciones, tenemos que buscar el mayor de ellos y elejimo el menor valor 
        //de la matriz de costo y elejimos la menor de la lista de columna y demandas
        //double valorOf, valorDe;
        int posI = -1; int posJ = -1;
        int valorP1, valorP2;
        int penalMayorC, penalMayorF;
        penalMayorF = penalMayorC = -1; //Lo usamos como control para saber si es fila o columna

        //Buscamos el mayor de esas listas
        posI = buscMayorPen(penalF); //posI guardamos la fila a anular
        posJ = buscMayorPen(penalC); //posJ guardamos la columna a anular

        valorP1 = (int)penalF.devolver(posI);
        valorP2 = (int)penalC.devolver(posJ);

        if(valorP1 > valorP2){
            penalMayorF = valorP1;
            posJ = -1;
        }else {
            penalMayorC = valorP2;
            posI = -1;
        }

        //Deberia ser int
        double val1 = -1; double val2 = -1;
        double ofertaMen = -1; double demandMenor = -1; 
        //Una ves encontrado la posicion, si es fila o columna, preguntamos para saber con cual trabajamos
        if(posI != -1 || penalMayorF != -1){
            //Aca trabajamos con la fila
            int posColum = -1;

            val1 = (double)this.listaOferta.devolver(posI);
            double costMenor = (double)((Produccion)this.matrizCosto.devolver(posI, 0)).getCosto();
            posColum = 0;
            for (int j=1; j<getOrden2(); j++){
                //Si trabajamos con la fila, recorremos las columnas en esa posI
                if((double)((Produccion)this.matrizCosto.devolver(posI, j)).getCosto() < costMenor 
                    && (double)((Produccion)this.matrizCosto.devolver(posI, j)).getCantidad() == 0){
                        costMenor = (double)((Produccion)this.matrizCosto.devolver(posI, j)).getCosto();
                        posColum = j;
                    }
            }
            val2 = (double)this.listDemanda.devolver(posColum);

            if(val2 < val1){ //Restamos en la lista de demanda o de oferta segun el valor recuperado
                demandMenor = val2;
                this.listDemanda.reemplazar((val2-val2), posColum);
                this.listaOferta.reemplazar((val1-val2), posI);
            } else {
                ofertaMen = val1;
                this.listaOferta.reemplazar((val1-val1), posI);
                this.listDemanda.reemplazar((val2-val1), posColum);
            }
            //Una lista de oferta se maneja con posicion Fila
            //Una lista de demanda se maneja con posicion COLUMNA
            if((double)this.listaOferta.devolver(posI)==0){
                //Si devuelve cero esa fila se anula
                Produccion aux;
                //Con este for anulamos la fila
                for (int counter=0; counter<getOrden2(); counter++){
                    if(counter == posColum){
                        ((Produccion)this.matrizCosto.devolver(posI, posColum)).setCantidad((int)ofertaMen);
                    }else {
                        aux = new Produccion(infinito);
                        //Agregamos un control mas, por el caso en el que llegaramos a tener una cantidad ya calculada
                        if(((Produccion)this.matrizCosto.devolver(posI, counter)).getCantidad() == 0){
                            this.matrizCosto.actualizar(aux, posI, counter);
                        }
                    }
                }
            } else {
                if((double)this.listDemanda.devolver(posColum)==0){
                    //Si devuelve cero esa columna se alumna
                    Produccion aux;
                    //Con este for anulamos la columna
                    for (int counter=0; counter<getOrden(); counter++){
                        if(counter == posI){
                            ((Produccion)this.matrizCosto.devolver(posI, posColum)).setCantidad((int)demandMenor);
                        }else {
                            aux = new Produccion(infinito);
                            if(((Produccion)this.matrizCosto.devolver(counter, posColum)).getCantidad() == 0){
                                this.matrizCosto.actualizar(aux, counter, posColum);
                            }
                        }
                    }
                }
            }
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
                for (int counter=0; counter<getOrden2(); counter++){
                    if(counter == posJ){
                        ((Produccion)this.matrizCosto.devolver(posFila, posJ)).setCantidad((int)ofertaMen);
                    }else {
                        //Como es fila la que anulamos
                        aux = new Produccion(infinito); //De esta manera lo pense
                        if(((Produccion)this.matrizCosto.devolver(posFila, counter)).getCantidad() == 0){
                            this.matrizCosto.actualizar(aux, posFila, counter);
                        }
                    }
                }
            }else { //Probar para este caso
                if((double)this.listDemanda.devolver(posJ)==0){
                    System.err.println("Este metodo falta probar");
                    Produccion aux;
                    //Esta columna se anula
                    for (int counter=0; counter<getOrden(); counter++){
                        if(counter == posFila){
                            ((Produccion)this.matrizCosto.devolver(counter, posJ)).setCantidad((int)demandMenor);
                        }else {
                            aux = new Produccion(infinito);
                            if(((Produccion)this.matrizCosto.devolver(counter, posJ)).getCantidad() == 0){
                                this.matrizCosto.actualizar(aux, counter, posJ);
                            }
                        }
                    }
                }
            }
        }
    }
    //Metodo que me sirve para buscar el mayor de la penalidades de esa fila o columna y devovler la posicion
    private int buscMayorPen(Lista list){
        int may = (int)list.devolver(0);
        int posMay = 0;
        for (int k=1; k<list.tamaño(); k++){
            if((int)list.devolver(k) > may){
                posMay = k;
                may = (int)list.devolver(k);
            }
        }
        return posMay;
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
