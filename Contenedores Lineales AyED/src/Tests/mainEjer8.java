package Tests;

import Tarea.PilaArrExtends;

public class mainEjer8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("removal")
		Integer a1 = new Integer(2);
		@SuppressWarnings("removal")
		Integer a2 = new Integer(5);
		
		PilaArrExtends pila = new PilaArrExtends(2);
		pila.meter(a1);
		pila.meter(a2);
		
		pila.muestra();
	}

}
