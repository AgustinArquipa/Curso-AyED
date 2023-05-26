package Ejemplos;

import java.util.Random;

public class Proceso {
	//Attributes
	private static int nextID = 1;
	private int id;
	private int tiempo;
	private int cantAtencciones;
	//Builders
	public Proceso() {
		this.id = nextID++;
		this.tiempo = 1 + new Random().nextInt(10);
		this.cantAtencciones = 0;
		System.out.println("Proceso ID: " + this.id + "\nTiempo: " + this.tiempo);
	}
	//methods
	public int getID() {
		return this.id;
	}
	public int getTiempo() {
		return this.tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int getAtenciones() {
		return this.cantAtencciones;
	}
	public void incrementarAtenciones() {
		this.cantAtencciones++;
	}
}
