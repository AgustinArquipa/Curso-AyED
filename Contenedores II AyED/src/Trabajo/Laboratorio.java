package Trabajo;

import java.util.Random;

import Contenedores.ColaSLinkedList;

public class Laboratorio {
	private static int cantPC = 15;
	private static int open = 0;
	private static int close = 600;
	
	private listaPC pcs;
	private ColaSLinkedList espera;
	private Alumno alumno;
	//builders
	public Laboratorio() {
		
	}
	//methods
	public void apertura() {
		for(int i=open; i<close; i++) {
			
		}
	}
	public void instPC() {
		//Creamos la 15 pcs que usa el laboratorio
		for(int i=0; i<cantPC; i++) {
			this.pcs.insertar(new PC(), i);
		}
	}
	
	public void atender(int timeArrival) {
		this.alumno = new Alumno(timeArrival);
		if(new Random().nextInt(1) == 0) {
			for(int i=0; i<cantPC; i++) {
				PC aux = (PC)this.pcs.devolver(i);
				if(aux.control()) {
					aux.ingreso(this.alumno);
				}else {
					this.espera.meter(alumno);
				}
			}
		}
	}
	
	public void utilizacionPCs(int time) {
		for(int i=0; i<this.pcs.tamaño(); i++) {
			PC aux = (PC)this.pcs.devolver(i);
			aux.atender(time);
		}
	}
}
