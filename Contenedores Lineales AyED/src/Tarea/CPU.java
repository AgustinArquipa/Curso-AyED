package Tarea;

import Contenedores.ColaArr;

public class CPU {
	private int tiempoCPU;
	private ColaArr cola;
	
	public CPU(int a, int cantP) {
		this.tiempoCPU = a;
		this.cola = new ColaArr(cantP + 1);
	}
	
	public void cargar() {
		while(!this.cola.estaLlena()) {
			this.cola.meter(new Proceso());
		}
	}
	
	public void atender() {
		while(!this.cola.estaVacia()) {
			Proceso aux = (Proceso)this.cola.sacar();
			aux.incremCantAtenc();
			if(aux.getTiempo() > this.tiempoCPU) {
				aux.setTiempo(aux.getTiempo() - this.tiempoCPU);
				this.cola.meter(aux);
			} else {
				System.out.println("Proceso con ID: " + aux.getId() + " atendido, cant.veces: " + aux.getCantAtenc());
				System.out.println("Tiempo Ocioso: " + (this.tiempoCPU - aux.getTiempo()));
			}
		}
	}
}
