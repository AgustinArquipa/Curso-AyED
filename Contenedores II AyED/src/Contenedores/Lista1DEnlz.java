package Contenedores;

import Recursos.*;

//Esta lista 1 doblemente enlazada, la vemos como una lista simple ya que implementa metodos para una lista comun
public abstract class Lista1DEnlz extends Lista0DEnlz implements OperacionesCL3{
	//Metodos
	public void insertar(Object element, int posicion) {
		NodoDoble aux; //Nodo auxiliar
		//Primeros verificamos que la posicion sea valida
		if(posicion > tamaño() || posicion < 0) {
			System.out.println("Error al insertar... Posicion inexistente!");
		}else {
			//Luego que verificamos, tenemos 3 casos
			//Inserccion al comienzo
			if(posicion == 0) {
				if(!estaVacia()) {
					//Si la lista no esta vacia, cambiamos las referencias
					this.frenteL = new NodoDoble(element, null, this.frenteL);
					this.frenteL.getNextNodo().setPrevNodo(this.frenteL);
				}else {
					//En el caso de que la lista este vacia, creamos el nodo
					this.frenteL = this.finalL = new NodoDoble(element);
				}
			}else {
				//Insertamos al final
				if(posicion == tamaño()) {
					this.finalL = new NodoDoble(element, this.finalL, null);
					this.finalL.getPrevNodo().setNextNodo(this.finalL);
				}else {
					//Este es el caso si queremos insertar al medio
					NodoDoble prev, next; //Nodos auxiliares que hacen la busqueda de inserccion
					prev = this.frenteL;
					next = this.frenteL.getNextNodo();
					for(int i=1; i<posicion; i++) {
						prev = prev.getNextNodo();
						next = next.getNextNodo();
					}
					//Actualizamos referencias
					aux = new NodoDoble(element, prev, next);
					prev.setNextNodo(aux);
					next.setPrevNodo(aux);
				}
			}
			//Incrementamos el tamaño de la lista
			this.ultimo++;
		}
	}
	//Metodo para remplazar
	public void reemplazar(Object element, int pos) {
		if(estaVacia()) {
			System.out.println("Error... Lista Vacia!");
		}else {
			if(pos >= tamaño() || pos < 0) {
				System.out.println("Error... Posicion invalida!");
			}else {
				if(pos == 0) {
					this.frenteL.setNodoInfo(element);
				}else {
					if(pos == tamaño() - 1) {
						this.finalL.setNodoInfo(element);
					}else {
						//Realizamos una busqueda sobre la posicion q queremos reemplazar el nvo elemento
						NodoDoble temp;
						temp = this.frenteL;
						for(int i=1; i<pos; i++) {
							temp = temp.getNextNodo();
						}
						temp.setNodoInfo(element);
					}
				}
			}
		}
	}
	public abstract boolean iguals(Object element1, Object element2);
	
	//Metodo de busqueda
		public int buscar(Object element) {
			int pos = -1;
			int cont = 0;
			Object unElement;
			NodoDoble temp;
			temp = this.frenteL;
			while(temp != null && pos == -1) {
				unElement = temp.getNodoInfo();
				if(iguals(unElement, element)) {
					pos = cont;
				}else {
					temp = temp.getNextNodo();
					cont++;
				}
			}
			return pos;
		}
}
