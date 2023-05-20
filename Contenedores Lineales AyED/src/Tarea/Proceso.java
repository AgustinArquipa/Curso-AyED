package Tarea;

import java.util.Random;

public class Proceso {
	private static int nextID = 1;
	private int id;
	private int tiempo;
	private int cantAtenc;
	
	public Proceso() {
		this.id = nextID++;
		this.tiempo = 1 + new Random().nextInt(10);
		this.cantAtenc = 0;
		System.out.println("Procesos ID: " + this.id + " Tiempo: " + this.tiempo);
	}
	
	public int getId() {return this.id;}
	public int getTiempo() {return this.tiempo;}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int getCantAtenc() {return this.cantAtenc;}
	public void incremCantAtenc() {
		this.cantAtenc++;
	}
}
