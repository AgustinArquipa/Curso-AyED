package Evaluacion;

public class Pantalla {
    private int tamanio;
    private String clss;
    //builders
    public Pantalla(int tamanio){
        this.tamanio = tamanio;
        this.clss = "Pantalla";
    }
    //Getters y Setters
    public int getTamanio(){return this.tamanio;}
    public String getClss(){return this.clss;}

    public String toString(){
        return "Pantalla de " + getTamanio() + " pulgadas.";
    }
}
