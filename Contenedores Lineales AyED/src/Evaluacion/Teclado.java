package Evaluacion;

public class Teclado {
    private int tamanio;
    private String clss;
    //builders
    public Teclado(int tamanio){
        this.tamanio = tamanio;
        this.clss = "Teclado";
    }
    //Getters
    public int getTamanio(){return this.tamanio;}
    public String getClss(){return this.clss;}

    public String toString(){
        return "Teclado de " + getTamanio() + " pulgadas.";
    }
}
