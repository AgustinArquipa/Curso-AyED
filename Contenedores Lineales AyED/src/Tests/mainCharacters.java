package Tests;

import Tarea.PilaLinkedExtend;

public class mainCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("removal")
		Character a = new Character('a');
		@SuppressWarnings("removal")
		Character b = new Character('b');
		@SuppressWarnings("removal")
		Character c = new Character('c');
		@SuppressWarnings("removal")
		Character d = new Character('d');
		@SuppressWarnings("removal")
		Character e = new Character('e');
		//Creamos la cola
		PilaLinkedExtend pila = new PilaLinkedExtend();
		pila.meter(a);
		pila.meter(b);
		pila.meter(c);
		pila.meter(d);
		pila.meter(e);
		
		//pila.muestra();
		Character e1 = (Character)pila.sacar();
		Character e2 = (Character)pila.sacar();
		//Sacamos elementos de la pila sin modificar la pila
		System.out.println("Elementos sacados: " + e1 + " ," + e2);
		System.out.println("Mostramos la pila cuando sacamos 2 elementos...");
		pila.muestra();
		Character tp = (Character)pila.topePila();
		System.out.println("Elemento sacado: " + tp);
		System.out.println("Pila sin modificar...");
		pila.muestra();
		
	}

}
