package GrafoDirigido;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Contenedores.MatrizGrafo;

public class GrafoD extends AbsGrafoD{
    //Attributes
    private BufferedReader br;
    private File file;
    private String line;
    //builders
    public GrafoD(){
        inicializar();
        this.matrizCosto = new MatrizGrafo(this.ordenGrafo);
    }
    //methods
    public void inicializar(){
        Scanner rd = new Scanner(System.in);
        System.out.print("Ingrese un Grafo Dirigido: ");
        String direction = rd.nextLine();
        this.file = new File(direction);
        rd.close();
        try {
            this.br = new BufferedReader(new FileReader(this.file));
            this.line = this.br.readLine();
            if(this.line != null){
                String[] datos = this.line.split(",");
                this.ordenGrafo = Integer.parseInt(datos[1]);
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException iox){
            iox.printStackTrace();
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
                    //System.out.println("Longitud de la linea txt: " + datos.length);
                    int j = 0;
                    int pos = 0; //manejo de pos txt
                    while(j < getOrden()){
                        if(j == i){
                            this.matrizCosto.actualizar(infinito, i, j);
                        }else {
                            currCost = Double.parseDouble(datos[pos]);
                            if(currCost != -1){
                                this.matrizCosto.actualizar(currCost, i, j);
                            }else {
                                this.matrizCosto.actualizar(infinito, i, j);
                            }
                            pos++;
                        }
                        j++;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void mostrarGrafo() {
        double currCost;
        for (int i=0; i<getOrden(); i++){
            for (int j=0; j<getOrden(); j++){
                if(i != j){
                    currCost = (double)this.matrizCosto.devolver(i, j);
                    if(currCost != infinito){
                        System.out.println("Costo: " + i + " a " + j + " -> " + currCost);
                    }
                }
            }
        }
    }
    
}
