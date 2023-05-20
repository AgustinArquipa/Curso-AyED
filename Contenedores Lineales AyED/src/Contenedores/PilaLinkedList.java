package Contenedores;
import Recursos.*;

public class PilaLinkedList implements OperacionesPC{
	protected Nodo pila;

	public PilaLinkedList() {
		limpiar();
	}
	@Override
	public void limpiar() {
		this.pila = null;
	}
	@Override
	public boolean estaVacia() {
		return (this.pila == null);
	}
	@Override 
	public void meter(Object element) {
		this.pila = new Nodo(element, this.pila);
	}
	@Override
	public Object sacar() {
		Object element = null;
		if(!estaVacia()) {
			element = this.pila.getNodoElement();
			this.pila = this.pila.getNextNodo();
		}else {
			System.out.println("Error al sacar... Pila vacia!");
		}
		return element;
	}
	
	public void muestra() {
		Nodo temp;
		if(!estaVacia()) {
			temp = this.pila;
			while(temp != null) {
				System.out.println("Elemento: " + temp.getNodoElement().toString());
				temp = temp.getNextNodo();
			}
		}else {
			System.out.println("Erorr... Pila vacia!");
		}
	}
}
