package Tarea;

import Contenedores.ColaArr;
import Contenedores.PilaLinkedList;

public class ColaArrExtends extends ColaArr{
	
	public ColaArrExtends(int tam) {
		super(tam);
	}
	public ColaArrExtends() {
		super(0);
	}
	
	//Metodo que nos permite obtner el cardinal de una cola
	//Buscar la manera para desarmar una cola auxiliar
	/*
	public int cardinalCola(ColaArr cola) {
		int n = 0;
		ColaArr aux = cola;
		Object obj = null;
		while(!aux.estaVacia()) {
			obj = aux.sacar();
			if(obj != null) {
				n++;
			}
		}
		return n; 
	} */
	public int cardinalCola() {
		int n = 0;
		Object aux = null;
		while(!estaVacia()) {
			aux = sacar();
			if(aux != null) {
				n++;
			}
		}
		return n;
	}
	//Metodo que usamos para invertir una cola
	public void invertCola() {
		Object obj = null;
		PilaLinkedList pila = new PilaLinkedList();
		while(!estaVacia()) {
			obj = sacar();
			if(obj != null) {
				pila.meter(obj);
			}
		}
		swappingStackAQueu(pila);
	}
	private void swappingStackAQueu(PilaLinkedList pila) {
		Object aux = null;
		while(!pila.estaVacia()) {
			aux = pila.sacar();
			meter(aux);
		}
	}
	//Metodo que nos permite concatenar 2 colas
	public void concatenar(ColaArrExtends c1, ColaArrExtends c2) {
		//ColaArrExtends cont = new ColaArrExtends(c1.getTamanio() + c2.getTamanio());
		if(!estaLlena()) {
			while(!c1.estaVacia()) {
				meter(c1.sacar());
			}
			while(!c2.estaVacia()) {
				meter(c2.sacar());
			}
		}
		mostrar();
	}
	public int getTamanio() {
		return this.tamCola - 1;
	}
	//Metodo que muestra
	public void mostrar() {
		Object aux;
		while(!estaVacia()) {
			aux = sacar();
			if (aux != null) {
				System.out.println("Elemento cola: " + aux.toString());
			}
		}
	}
	public void mostrar(ColaArr cola) {
		Object aux;
		ColaArr co = cola;
		while(!estaVacia()) {
			aux = co.sacar();
			if(aux != null) {
				System.out.print("Elemento cola: " + aux.toString());
			}
		}
	}
}
