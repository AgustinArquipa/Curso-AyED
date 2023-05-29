package Trabajo;

import java.util.Random;

public class Alumno {
	//Attributes
	private static int nextLu = 2010;
	private int lu;
	private int tiempo;
	//builders
	public Alumno() {
		this.lu = nextLu++;
		this.tiempo = new Random().nextInt(30) + 30;
	}
	//methods
	public int getLU() {
		return this.lu;
	}
	public int getTiempoPC() {
		return this.tiempo;
	}
	public void setTiempoPC(int tiempo) {
		this.tiempo = tiempo;
	}
	
	public String toString() {
		return "LU: " + getLU() + "\nTiempo Necesitado: " + getTiempoPC();
	}
}
