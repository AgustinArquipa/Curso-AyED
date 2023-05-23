package Contenedores;

import Recursos.*;

public abstract class Lista0DEnlz implements OperacionesCL2{
	//Atributos
	protected NodoDoble frenteL, finalL;
	protected int ultimo;
	//Constructores
	public Lista0DEnlz() {
		limpiar();
	}
	//Metodos
	public void limpiar() {
		this.frenteL = this.finalL = null;
		this.ultimo = -1;
	}
	public boolean estaVacia() {
		return (this.frenteL == null); //O me pregunto si this.ultimo == 1
	}
	public int tamaño() {
		return (this.ultimo + 1);
	}
	//Metodo para devolver un objeto en una posicion determinada
	public Object devolver(int posicion) {
		Object element = null;
		//Verificamos que la lista no este vacia
		if(estaVacia()) {
			System.out.println("Error a devolver... Lista vacia!");
		}else {
			//Y si no esta vacia, verificamos que la posicion sea valida
			if(posicion >= tamaño() || posicion < 0) {
				System.out.println("Error... Posicion invalida!");
			}else {
				//Una ves verificado eso, usamos un Nodo aux para buscar
				NodoDoble aux;
				aux = this.frenteL;
				for(int k=0; k<posicion; k++) {
					aux = aux.getNextNodo();
				}
				element = aux.getNodoInfo();
			}
		}
		return element;
	}
	//Si nos perdemos, pensarlo en forma grafica
	public void eliminar(int posicion) {
		//Controlamos que la listaDoble no este vacia
		if(estaVacia()) {
			System.out.println("Error al eliminar... Lista vacia!");
		}else {
			//Chequeamos que la posicion que nos paso sea valida
			if(posicion >= tamaño() || posicion <0) {
				System.out.println("Error... Posicion invalida!");
			}else {
				//Despues de verificar, tenemos 3 casos
				//La primera que el ususario quiera eliminar el primero
				if(posicion == 0) {
					//Si tenemos un caso, en el que tengamos un solo elemento
					if(this.frenteL == this.finalL) {
						limpiar();
					}else {
						//Esta parte es para cuando hay mas elementos en la lista, tenemos que cambiar las referencias
						this.frenteL = this.frenteL.getNextNodo();
						this.frenteL.setPrevNodo(null);
						this.ultimo--;
					}
				}else {
					//Ahora tenemos el caso de que sea la ultima posicion
					if(posicion == tamaño() - 1) {
						this.finalL = this.finalL.getPrevNodo();
						this.finalL.setNextNodo(null);
					}else {
						//Este es el caso, en que la posiciona sea un elemento del medio, hay que hacer una busqueda
						NodoDoble prev, next; //Nodos temporales
						prev = this.frenteL;
						next = this.frenteL.getNextNodo();
						for(int k=1; k<posicion; k++) {
							prev = prev.getNextNodo();
							next = next.getNextNodo();
						}
						//Actualizamos referencias
						next = next.getNextNodo();
						prev.setNextNodo(next);
						next.setPrevNodo(prev);
					}
					this.ultimo--;
				}
			}
		}
	}
}
