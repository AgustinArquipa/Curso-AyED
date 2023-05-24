package testing;

import Ejemplos.ListCaracteres;

public class mainCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListCaracteres list = new ListCaracteres();
		list.insertar('A');
		list.insertar('B');
		list.insertar('C');
		list.insertar('D');
		
		System.out.println("Buscamos un elemento: " + list.buscar('E'));
		
		//Mostramos la lista
		for(int i=0; i<list.tamaño(); i++) {
			System.out.println("Elementos de la lista: " + list.devolver(i));
		}
		
		//Mostramos los caracteres en codigo ASCII
		for(int k=0; k<list.tamaño(); k++) {
			System.out.println("ASCII: " + Character.getNumericValue((char) list.devolver(k)));
		}
	}

}
