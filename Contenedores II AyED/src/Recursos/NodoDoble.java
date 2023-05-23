package Recursos;

public class NodoDoble {
	//Atributos 
	//Imaginamos la clase nodo como una caja con un elemento al medio, y dos cajas que lo separan. Una anterios y una sig
	private Object nodoInfo;
	private NodoDoble prevNodo, nextNodo;
	//Constructores
	public NodoDoble(Object Element, NodoDoble prevNodo, NodoDoble nextNodo) {
		this.nodoInfo = Element;
		this.prevNodo = prevNodo;
		this.nextNodo = nextNodo;
	}
	public NodoDoble(Object element, NodoDoble nextNodo) {
		this(element, null, nextNodo);
	}
	public NodoDoble(Object element) {
		this(element, null, null);
	}
	//Getters y Setters
	//Aqui obtenemos la informacion que guarda el nodo, osea el elemento del medio
	public Object getNodoInfo() {return this.nodoInfo;}
	public void setNodoInfo(Object element) {
		this.nodoInfo = element;
	}
	//Con este metodo obtenemos el nodo anterior y lo setiamos
	public NodoDoble getPrevNodo() {return this.prevNodo;}
	public void setPrevNodo(NodoDoble prevNodo) {
		this.prevNodo = prevNodo;
	}
	//Con este metodo setiamos y obtenemos el nodo siguiente
	public NodoDoble getNextNodo() {return this.nextNodo;}
	public void setNextNodo(NodoDoble nextNodo) {
		this.nextNodo = nextNodo;
	}
}
