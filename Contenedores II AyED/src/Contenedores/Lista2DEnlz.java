package Contenedores;

import Recursos.*;

//Esta clase abstracta implementa la lista ordenada
public abstract class Lista2DEnlz extends Lista1DEnlz implements OperacionesCL4{
	
	//Metodos abstractos de la clase
	public abstract boolean esMenor(Object element1, Object element2);
	public abstract boolean esMayor(Object element1, Object element2);
	
	//Insertamos de manera ordenada
	public void insertar(Object element) {
		NodoDoble nodo;
		//Verificamos que la lista no este vacia, sino creamos un nvo ndo
		if(estaVacia()) {
			this.frenteL = this.finalL = new NodoDoble(element);
		}else {
			//Inserccion al frente
			if(esMenor(element, this.frenteL.getNodoInfo())) {
				this.frenteL = new NodoDoble(element, null, this.frenteL);
				this.frenteL.getNextNodo().setPrevNodo(this.frenteL);
			}else {
				if(esMayor(element, this.finalL.getNodoInfo()) || iguals(element, this.finalL.getNodoInfo())) {
					//Inserccion al final de la lista
					this.finalL = new NodoDoble(element, this.finalL, null);
					this.finalL.getPrevNodo().setNextNodo(this.finalL);
				}else {
					//Inserccion al medio
					NodoDoble temp = this.frenteL;
					boolean flag = false;
					//Basicamente haremos una busqueda
					while(temp.getNextNodo() != null && !flag) {
						if(esMayor(element, temp.getNextNodo().getNodoInfo()) 
								|| iguals(element, temp.getNextNodo().getNodoInfo())) {
							temp = temp.getNextNodo();
						}else {
							flag = true;
						}
					}
					nodo = new NodoDoble(element, temp, temp.getNextNodo());
					temp.getNextNodo().setPrevNodo(nodo);
					temp.setNextNodo(nodo);
				}
			}
		}
		this.ultimo++;
	}
	
}
