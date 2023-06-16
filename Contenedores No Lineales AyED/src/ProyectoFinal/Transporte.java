package ProyectoFinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Contenedores.Lista;


public class Transporte extends AbsTransporte{
    //Attributes
    private BufferedReader br;
    private File file;
    private String line;
    //builerds
    public Transporte(){
        inicializar();
        //System.out.println("Orden 1: " + getOrden() + "\nOrden 2: " + getOrden2());
        this.matrizCosto = new MatrizTransporte(this.ordenGrafo, this.ordenGrafo2);
    }
    //methods
    private void inicializar(){
        Scanner nd = new Scanner(System.in);
        System.out.print("Ingrese un Modelo a Calcular: ");
        String direction = nd.nextLine();
        this.file = new File(direction);
        nd.close();
        try {
            this.br = new BufferedReader(new FileReader(this.file));
            this.line = this.br.readLine();
            if (this.line != null){
                String[] datos = this.line.split(",");
                //En el txt pasamos el orden ej: 3, 3
                int orden1 = Integer.parseInt(datos[0]);
                int orden2 = Integer.parseInt(datos[1]);
                if(orden1 == orden2){
                    this.ordenGrafo = this.ordenGrafo2 = orden1 - 1; //Ponemos -1 porque en la matriz no insertamos la Oferta y Demanda
                    //La oferta y demanda se lo hace atraves de una lista
                }else {
                    this.ordenGrafo = orden1 - 1;
                    this.ordenGrafo2 = orden2 - 1;
                }
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }
    @Override
    public void cargarGrafo() {
        double currCost; 

        this.listaOferta = new Lista();
        this.listDemanda = new Lista();

        try {
            for(int i=0; i<=getOrden(); i++){
                this.line = this.br.readLine();
                if(this.line != null && i != getOrden()){
                    String[] datos = this.line.split(",");
                    for(int j=0; j<=getOrden2(); j++){
                        if(j==getOrden2()){
                            currCost = Double.parseDouble(datos[j]);
                            this.listaOferta.insertar(currCost, i);
                        }else {
                            currCost = Double.parseDouble(datos[j]);
                            this.matrizCosto.actualizar(new Produccion(currCost), i, j);
                            //Aca tenemos el objeto Produccion que tiene Cij:Xij, solo para recordad todos inician con cantidad 0
                        }
                    }
                }else {//Si i==getOrden() entonces entra por aca, donde creamos la lista de Demanda
                    String[] datos = this.line.split(","); //Como line != null, podemos volver a recorrer y pedir los datos para completar
                    for(int j=0; j< getOrden2(); j++){
                        currCost = Double.parseDouble(datos[j]);
                        this.listDemanda.insertar(currCost, j);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void mostrarGrafo() {
        // TODO Auto-generated method stub
        System.out.println(this.listaOferta);
        System.out.println(this.listDemanda);
        this.matrizCosto.mostrarMatriz();
    }
}
