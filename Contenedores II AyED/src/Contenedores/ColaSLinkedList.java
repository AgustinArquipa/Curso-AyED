package Contenedores;

import Recursos.*;
//Queda como pregunta preguntar al profe pq no pude hacer abstracta esta clase
//Error la jerarquia del tipo de dato colaPrioperty es inconsistente
public class ColaSLinkedList implements OperacionesCL1{
	//Attributes used Nodo Simple
	protected Nodo frenteC, finalC;

	//Builders
	public ColaSLinkedList() {
		limpiar();
	}
	//Methods
	public void limpiar() {
		this.frenteC = this.finalC = null;
	}
	public boolean estaVacia() {
		return (this.frenteC == null);
	}
	public Object sacar() {
		Object element = null;
		if(estaVacia()) {
			System.out.println("Error... Cola Vacia!");
		}else {
			element = this.frenteC.getNodoInf();
			this.frenteC = this.frenteC.getNextNodo();
			if(estaVacia()) {
				this.finalC = null;
			}
		}
		return element;
	}
	@Override
	public void meter(Object element) {
		// TODO Auto-generated method stub
	}
}
