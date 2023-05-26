package Ejemplos;

import Contenedores.ColaPriopertySL;

public class CPU {
	//Attributes for CPU
	private int timeCPU;
	private ColaPriopertySL cola;
	//builders
	public CPU(int timeCPU) {
		this.timeCPU = timeCPU;
		this.cola = new ColaPriopertySL() {
			
			@Override
			public boolean isOlder(Object element1, Object element2) {
				Proceso p1 = (Proceso)element1;
				Proceso p2 = (Proceso)element2;
				return p1.getTiempo() > p2.getTiempo();
			}
			
			@Override
			public boolean isLess(Object element1, Object element2) {
				Proceso p1 = (Proceso)element1;
				Proceso p2 = (Proceso)element2;
				return p1.getTiempo() < p2.getTiempo();
			}
			
			@Override
			public boolean equals(Object element1, Object element2) {
				Proceso p1 = (Proceso)element1;
				Proceso p2 = (Proceso)element2;
				return p1.getTiempo() == p2.getTiempo();
			}
		};
	}
	//Methods
	public void load() {
		this.cola.meter(new Proceso());
	}
	//method that allows to attend the processes
	public void serve() {
		while(!this.cola.estaVacia()) {
			Proceso aux = (Proceso)this.cola.sacar();
			aux.incrementarAtenciones();
			if(aux.getTiempo() > this.timeCPU) {
				aux.setTiempo(aux.getTiempo() - this.timeCPU);
				this.cola.meter(aux);
			}else {
				System.out.println("Proceso con ID: " + aux.getID() + " atendido, cant.veces: " + aux.getAtenciones());
				System.out.println("Tiempo Ocioso: " + (this.timeCPU - aux.getTiempo()));
			}
		}
	}
}
