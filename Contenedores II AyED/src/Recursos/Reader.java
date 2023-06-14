package Recursos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    //Atributos para leer un archivo txt
    private BufferedReader br;
    private File file;
    //builders
    public Reader(String direction){
        this.br = null;
        this.file = new File(direction);
    }
    public Reader(){
        this.br = null;
        this.file = new File("src/");
    }
    //methods
    public void leerArchivo(ArrayList<String[]> data) throws IOException{
        if(this.file.exists()){
            this.br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while(line != null){
                data.add(line.split(","));
                line = br.readLine();
            }
            br.close();
        }else {
            throw new IOException("No se encuentra el archivo");
        }
    }
    public void leerArchivo(){
        try {
            this.br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            System.out.println("Una linea: " + line);
            /* 
            while(line != null){
                //System.out.println(line);
                String[] datos = line.split(",");
                //System.out.println(datos.length); devuelve la cantidad de elementos que hay en esa linea
                for(int k=0; k<datos.length; k++){
                    System.out.println("Elementos en posiciones: " + k + " " + datos[k]);
                }
                //System.out.println(line.split(","));
                line = br.readLine();
            }*/
            line = br.readLine();
            System.out.println("Otra linea: " + line);
        }catch (FileNotFoundException ex){
            System.err.println(ex.getMessage());
        } catch (IOException iox){
            System.err.println(iox.getMessage());
        }
    }
}
