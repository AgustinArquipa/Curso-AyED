package Tarea;

import Contenedores.PilaLinkedList;

//Realizamos el ejercicio 9 con la pila dinamica
public class Ejerc9Linked {
	private String frase;
	private PilaLinkedList pila;
	//Constructor
	public Ejerc9Linked(String frase) {
		this.frase = frase;
		this.pila = new PilaLinkedList();
	}
	//Metodos
	public void evaluar() {
		//Pensamos en 2 casos bases, cuando es ( metemos a la pila, y cuando es ) sacamos de la pila
		int i = 0;
		boolean band = false;
		while(i<this.frase.length()) {
			Character aux = this.frase.charAt(i);
			if(aux == '(') {
				this.pila.meter(aux);
			}else {
				if(this.pila.estaVacia() && aux == ')') {
					band = true;
				}else {
					if(aux == ')') {
						this.pila.sacar();
					}
				}
			}
			i++;
		}
		if(this.pila.estaVacia()) {
			if(!band) {
				System.out.println("La palabra: " + this.frase + ", esta BALANCEADA!");
			}else {
				System.out.println("La palabra: " + this.frase + ", NO esta BALANCEADA!");
			}
		}else {
			System.out.println("La palabra: " + this.frase + ", NO esta BALANCEADA!");
		}
	}
}
