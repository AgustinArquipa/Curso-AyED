package Recursos;

public class Nodo {
	//Atributos
	private Object nodoElem;
	private Nodo nextNodo;
	//Constructores
	public Nodo(Object nodoElem, Nodo nextNodo) {
		this.nodoElem = nodoElem;
		this.nextNodo = nextNodo;
	}
	
	public Nodo(Object nodoElem) {
		this(nodoElem, null);
	}
	//Metodos
	public Object getNodoElement() {
		return this.nodoElem;
	}
	public void setNodoElement(Object nodoElem) {
		this.nodoElem = nodoElem;
	}
	public Nodo getNextNodo() {
		return this.nextNodo;
	}
	public void setNextNodo(Nodo nextNodo) {
		this.nextNodo = nextNodo;
	}
}
