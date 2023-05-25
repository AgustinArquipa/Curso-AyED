package Ejemplos;

import Contenedores.ColaPriopertySL;

public class ColaPEnteros extends ColaPriopertySL{

	@Override
	public boolean equals(Object element1, Object element2) {
		Integer a = (Integer)element1;
		Integer b = (Integer)element2;
		return a == b;
	}

	@Override
	public boolean isOlder(Object element1, Object element2) {
		Integer a = (Integer)element1;
		Integer b = (Integer)element2;
		return a > b;
	}

	@Override
	public boolean isLess(Object element1, Object element2) {
		Integer a = (Integer)element1;
		Integer b = (Integer)element2;
		return a < b;
	}
	
	public void mostrar() {
		Object aux;
		while(!estaVacia()) {
			aux = sacar();
			if (aux != null) {
				System.out.println("Elemento cola: " + aux.toString());
			}
		}
	}
}
