package Contenedores;
import Recursos.OperacionesPC;

public class PilaArr implements OperacionesPC{
	//Atributos
	protected Object[] pila;
	protected int tope;
	protected int tamPila;
	//Constructores
	public PilaArr(int tamPila) {
		this.tamPila = tamPila;
		this.pila = new Object[this.tamPila];
		limpiar(); //Necesitamos limpiar la pila cuando creamo el objeto Pila
	}
	//Metodos
	public void incrementarTope() {this.tope++;}
	public void decrementarTope() {this.tope--;}
	
	public boolean estaLlena() {
		return this.tope == this.tamPila - 1;
	}
	@Override
	public boolean estaVacia() {
		return this.tope == -1;
	}
	@Override
	public void limpiar() {
		this.tope = -1;
	}
	@Override
	public void meter(Object element) {
		if (!estaLlena()) {
			incrementarTope();
			this.pila[this.tope] = element;
		}else {
			System.out.println("Error... Pila llena!");
		}
	}
	@Override 
	public Object sacar() {
		Object element = null;
		if(!estaVacia()) {
			element = this.pila[this.tope];
			decrementarTope();
		}else {
			System.out.println("Error... Pila Vacia");
		}
		return element;
	}
}
