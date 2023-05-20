package Tests;

import Recursos.Nodo;

public class MainNodo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instanciamos el Nodo
		Nodo F = new Nodo(90);
		Nodo B = new Nodo(80, F);
		Nodo C = new Nodo(65, B);
		Nodo D = new Nodo(60, C);
		Nodo E = new Nodo(45, D);
		Nodo A = new Nodo(30, E);
		Nodo lista = new Nodo(25, A);
		
		//Ejercicio 3a
		System.out.println(A.getNodoElement());
		System.out.println(B.getNextNodo());
		//lista de Nodos
		System.out.println(lista.getNextNodo().getNextNodo().getNodoElement());
		//Ejercicio 3b
		System.out.println(lista.getNextNodo()==A);
		System.out.println(A.getNextNodo().getNodoElement()==(Object)60); //Devuelve falso si null != 60
		System.out.println(B.getNextNodo()==null);
		
		//Ejercicio 3c
		System.out.println("Apuntando a 45: " + lista.getNextNodo().getNextNodo().getNodoElement());
		System.out.println("Apuntando al ultimo elemento de la lista: " + B.getNextNodo().getNodoElement());
		lista.setNextNodo(null);
		System.out.println(lista.getNextNodo());
	}

}
