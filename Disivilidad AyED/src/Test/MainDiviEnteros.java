package Test;

import Codigo_tp.Divisibilidad_enteros;

public class MainDiviEnteros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Divisibilidad_enteros op = new Divisibilidad_enteros();
		int a = -35;
		int b = -6;
		System.out.println("Cociente: " + op.crent(a, b).get(0));
		System.out.println("Resto: " + op.crent(a, b).get(1));
	}

}
