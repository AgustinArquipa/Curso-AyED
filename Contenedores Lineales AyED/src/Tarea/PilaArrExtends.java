package Tarea;

import Contenedores.PilaArr;

public class PilaArrExtends extends PilaArr{

	public PilaArrExtends(int tamPila) {
		super(tamPila);
		// TODO Auto-generated constructor stub
	}
	//Metodos que nos permitan buscar si los elementos estan en la lista
	public boolean isExistElement(int num) {
		boolean band = false;
		if(!estaVacia()) {
			int i = 0;
			while(i<this.tamPila) {
				if((Integer)this.pila[this.tope]==num) {
					band = true;
				}
				decrementarTope();
				i++;
			}
		}
		return band;
	}
	//Motramos la pila
	public void muestra() {
		Object aux;
		while(!estaVacia()) {
			aux = sacar();
			if(aux != null) {
				System.out.println("Elemento de la Pila: " + aux.toString());
			}
		}
	}
}
