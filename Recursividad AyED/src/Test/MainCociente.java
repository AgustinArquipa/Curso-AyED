package Test;

import Ejercicios.Coc_RestRecursivo;
import Ejercicios.PrimoRec;

public class MainCociente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -10;
		int b = 11;
		Coc_RestRecursivo ope = new Coc_RestRecursivo();
		System.out.println("Cociente es: " + ope.cocienteR(a, b));
		System.out.println("El resto es: " + ope.restoR(a, b));
		
		PrimoRec primo = new PrimoRec();
		System.out.println("El num: " + b + " es Primo??\n" + primo.primo(b));

	}

}
