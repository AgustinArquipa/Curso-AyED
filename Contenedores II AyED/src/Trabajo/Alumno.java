package Trabajo;

import java.util.Random;

public class Alumno {
	//Attributes
	private static int nextLu = 2010;
	private int lu;
	private int timeArrival;
	private int tiempo;
	//builders
	public Alumno(int timeArrival) {
		this.lu = nextLu++;
		this.timeArrival = timeArrival;
		this.tiempo = new Random().nextInt(30) + 30;
	}
	public Alumno() {
		this(0);
	}
	//methods
	public int getLU() {
		return this.lu;
	}
	/* method that alow to knows the arrival time */
	public int getTimeOfArrival() {
		return this.timeArrival;
	}
	public void setTimeOfArrival(int time) {
		this.timeArrival = time;
	}
	/* */
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
