package Evaluacion;

public class Base {
    private int tamanio;
    private String clss;
    //builder
    public Base(int tamanio){
        this.tamanio = tamanio;
        this.clss = "Base";
    }
    //Getter
    public int getTamanio(){return this.tamanio;}
    public String getClss(){return this.clss;}

    public String toString(){
        return "Base de " + getTamanio() + " pulgadas.";
    }
}
