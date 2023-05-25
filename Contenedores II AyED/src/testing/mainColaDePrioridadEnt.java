package testing;

import Ejemplos.ColaPEnteros;

public class mainColaDePrioridadEnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColaPEnteros cola = new ColaPEnteros();
		
		cola.meter(new Integer(4));
		cola.meter(new Integer(6));
		cola.meter(new Integer(3));
		cola.meter(new Integer(5));
		
		cola.mostrar();
	}

}
