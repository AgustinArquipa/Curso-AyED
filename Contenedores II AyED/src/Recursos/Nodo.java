package Recursos;

public class Nodo {
	private Object ndoInfo;
	private Nodo nextNodo;
	//Builder
	public Nodo(Object element) {
		this(element, null);
	}
	public Nodo(Object element, Nodo nextNodo) {
		this.ndoInfo = element;
		this.nextNodo = nextNodo;
	}
	//Methods
	public Object getNodoInf() {
		return this.ndoInfo;
	}
	public void setNodoInfo(Object element) {
		this.ndoInfo = element;
	}
	public Nodo getNextNodo() {
		return this.nextNodo;
	}
	public void setNextNodo(Nodo nextNodo) {
		this.nextNodo = nextNodo;
	}
}
