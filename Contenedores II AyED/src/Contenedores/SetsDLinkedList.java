package Contenedores;

import Recursos.OperacionesST;

public abstract class SetsDLinkedList extends Lista1DEnlz implements OperacionesST{

	@Override
	public boolean esta(Object element) {
		boolean flag = false;
		if(estaVacia()) {
			System.out.println("Error... Conjunto Vacio!");
		}else {
			int pos = buscar(element);
			System.out.println("Posicion del elemento: " + pos);
			if(pos != -1) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void meter(Object element) {
		/* The method to put Objects in the set,
		 * we have to control that elements is not repeated */
		if(esta(element)) {
			System.out.println("Error... elemento repetido");
		}else {
			//Insert in the position 0??
			insertar(element, 0);
		}
	}

	@Override
	public Object sacar() {
		Object elemento = null;
		if(estaVacia()) {
			System.out.println("Error... Conjunto Vacio!");
		}else {
			elemento = devolver(tamaño());
			eliminar(tamaño());
		}
		return elemento;
	}
	//Method suscribited
	public Object sacar(int pos) {
		Object elemento = null;
		if(estaVacia()) {
			System.out.println("Error... Conjunto Vacio!");
		}else {
			elemento = devolver(pos);
			eliminar(pos);
		}
		return elemento;
	}
}
