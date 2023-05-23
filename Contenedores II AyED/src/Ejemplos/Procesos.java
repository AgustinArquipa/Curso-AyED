package Ejemplos;

import java.util.Random;

public class Procesos {
	private static int nextID = 1;
    private int id;
    private int tiempo;
    private int cantAtenciones;

    //Constructor
    public Procesos(){
        this.id = nextID++;
        this.tiempo = 1 + new Random().nextInt(10);
        this.cantAtenciones = 0;
        System.out.println("Procesos ID: " + this.id + " Tiempo: " + this.tiempo);
    }

    //Gettesr y Setters
    public int getId() {return this.id;}
    public int getTiempo() {return this.tiempo;}
    public void incremCantAtenciones(){
        this.cantAtenciones++;
    }
    public int getCantAtenciones(){
        return this.cantAtenciones;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String toString(){
        return "Proceso ID: " + this.id + ", tiempo: " + this.tiempo;
    }
}
