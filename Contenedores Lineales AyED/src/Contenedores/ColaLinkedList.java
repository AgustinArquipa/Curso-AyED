package Contenedores;
import Recursos.*;

public class ColaLinkedList implements OperacionesPC{
	private Nodo frenteC, finalC;
	
	public ColaLinkedList() {
		limpiar();
	}
	
	//Metodos
	public void limpiar() {
		this.frenteC = this.finalC = null;
	}
	@Override
	public boolean estaVacia() {
		return (this.frenteC == null);
	}

	@Override
	public void meter(Object element) {
		if(!estaVacia()) {
			this.finalC.setNextNodo(new Nodo(element));
			this.finalC = this.finalC.getNextNodo();
		}else {
			this.frenteC = this.finalC = new Nodo(element);
		}
	}

	@Override
	public Object sacar() {
		Object element = null;
		if(!estaVacia()) {
			element = this.frenteC.getNodoElement();
			this.frenteC = this.frenteC.getNextNodo();
			if(estaVacia()) {
				this.finalC = null;
			}
		}else {
			System.out.println("Error sacar. Cola vacia!");
		}
		return element;
	}
}
