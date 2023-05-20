package Test;

import Complejos.Complex;

public class MainArg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex c = new Complex();
		//System.out.println(c.argZ(3, 3)); //Cuadrante 1
		Complex c1 = new Complex();
		System.out.println(c1.argZ((-Math.sqrt(3)), 1)); //Cuadrante 2
		Complex c2 = new Complex();
		System.out.println(c2.argZ(-1, -1)); //Cuadrante 3
		Complex c3 = new Complex();
		System.out.println(c3.argZ(2, (-2*Math.sqrt(3)))); //Cuadrante 4 
		
		//Comprobamos si la potencia esta bien
		Complex c4 = new Complex(2, 3);
		//System.out.println(Math.pow(Math.sqrt(3), 2));
		c.potencia(c4, 5);
		System.out.println(c);
	}

}
