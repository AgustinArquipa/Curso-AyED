package Hospital;

import java.util.ArrayList;

public class Resultado {
    //attributes
    private static int nextID = 1;
    private int clave;
    private String valor;
    private ArrayList<Analisis> analisis;
    //builders
    public Resultado(int clave, String valor){
        this.clave = clave;
        this.valor = valor;
        this.analisis = new ArrayList<Analisis>();
    }
    public Resultado(String valor){
        this(nextID++, valor);
    }
    //methods
    public void agregarAnalisis(Analisis ana1){
        this.analisis.add(ana1);
    }
    public String mostrarAnalisis(){
        String cad = "\tLista de Analisis\n";
        for(Analisis ana: this.analisis){
            cad += ana + "\n";
        }
        return cad;
    }
    //toString
    public String toString(){
        String cad = "Resultado";
        cad += "\nClave: " + this.clave;
        cad += "\nValor (Result): " + this.valor;
        return cad;
    }
}
