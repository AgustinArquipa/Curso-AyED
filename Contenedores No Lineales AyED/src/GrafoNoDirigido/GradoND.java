package GrafoNoDirigido;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Contenedores.AbsGrafo;
import Contenedores.MatrizGrafo;

public class GradoND extends AbsGrafo{
    //attributes
    protected BufferedReader br;
    protected File file;
    protected String line;
    //builders
    public GradoND(int number){
        super(number);
    }
    public GradoND() {
        inicializar();
        this.matrizCosto = new MatrizGrafo(this.ordenGrafo);
    }
    //methods
    public void inicializar() {
        Scanner rd = new Scanner(System.in);
        System.out.print("Ingrese un Grafo: ");
        String direction = rd.nextLine();
        this.file = new File(direction);
        rd.close();
        try {
            this.br = new BufferedReader(new FileReader(this.file));
            this.line = br.readLine();
            if(this.line != null){
                String[] datos = this.line.split(",");
                //System.out.println(this.ordenGrafo = Integer.parseInt(datos[1]));
                this.ordenGrafo = Integer.parseInt(datos[1]);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void cargarGrafo() {
        double currCost;
        
        try {
            for(int i=0; i<getOrden(); i++){
                this.line = this.br.readLine();
                if(this.line != null){
                    String[] datos = this.line.split(","); 
                    int j = i;
                    //System.out.println("Posicion i, j: " + i + ", " + j);
                    int m = 0;  //Con esto tenemos que recuperar los datos del txt
                    while(m<datos.length && j<getOrden()){
                        if(i == j){
                            this.matrizCosto.actualizar(infinito, i, j);
                        }else {
                            currCost = Double.parseDouble(datos[m]);
                            //System.out.println("Costo: [" + m + "]: " + currCost);
                            if(currCost == -1){
                                this.matrizCosto.actualizar(infinito, i, j);
                                this.matrizCosto.actualizar(infinito, j, i);
                            }else {
                                this.matrizCosto.actualizar(currCost, i, j);
                                this.matrizCosto.actualizar(currCost, j, i);
                            }
                            m++;
                        }
                        j++;
                        //System.out.println("Posicion i, j: " + i + ", " + j);
                    }
                } else {
                    int j = i;
                    //System.out.println("Posicion i, j: " + i + ", " + j);
                    if(i == j){
                        this.matrizCosto.actualizar(infinito, i, j);
                    }
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        } /* */
       
    }

    @Override
    public void mostrarGrafo() {
        for(int i=0; i<getOrden(); i++){
            for(int k=0; k<getOrden(); k++){
                System.out.print(this.matrizCosto.devolver(i, k) + " ");
            }
            System.out.println();
        }
    }
}
