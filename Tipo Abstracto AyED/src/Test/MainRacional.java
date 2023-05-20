package Test;

import Racionales.Racional;

public class MainRacional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Racional r1 = new Racional(2, 4);
		Racional r2 = new Racional(2, 3);
		Racional r3 = new Racional();
		//r1.simplificarRacional(2, 4);
		//System.out.println(r3);
		//r3.sumar(r1, r2);
		//r3.potencia(r1, 2);
		r3.restar(r1, r2);
		System.out.println(r3);
	}

}
