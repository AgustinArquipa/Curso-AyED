package Test;

import Complejos.Complex;

public class MainComplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex c1 = new Complex(2, 3);
		//Complex c2 = new Complex(1, -5);
		//C3 lo utilizamos para los calculos
		Complex c3 = new Complex();
		
		c3.potencia(c1, 5);
		System.out.println(c3);
	}

}
