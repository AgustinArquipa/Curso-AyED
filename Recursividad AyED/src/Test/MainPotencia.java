package Test;

import Ejercicios.PotRecursiva;
import Ejercicios.cantDigitos;

public class MainPotencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PotRecursiva op = new PotRecursiva();
		System.out.println("La potencia es: " + op.potR(2, 10));
		
		cantDigitos c = new cantDigitos();
		System.out.println("La cantidad de digitos de un num es: " + c.catDigR(100));
	}

}
