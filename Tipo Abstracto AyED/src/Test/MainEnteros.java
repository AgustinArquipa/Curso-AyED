package Test;

import Enteros.Enteros;

public class MainEnteros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Enteros e1 = new Enteros(10);
		Enteros e2 = new Enteros(3);
		Enteros e3 = new Enteros();
		System.out.println("La suma es: " + e3.suma(e1, e2));
		//System.out.println(e3);
		//System.out.println("La Pot es: " + e3.potencia(e1, 3));
		System.out.println("El resto es: " + e3.resto(e1, e2));
		System.out.println("Mcd: " + e3.mcd(e1, e2));
	}

}
