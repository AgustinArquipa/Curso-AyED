package Test;

import java.util.ArrayList;

import Teorema_Chino.EcuacionLineal;
import Teorema_Chino.TeoremaChinoResto;

public class MainTeorema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b1, b2;
		b1 = 1; b2 = 4;
		//Probamos con el primer ejemplo del tp y luego generalizamos
		int m1, m2;
		m1 = 8; m2 = 11;
		//TeoremaChinoResto chi = new TeoremaChinoResto();
	//	System.out.println(chi.teoChinoRest(b1, b2, m1, m2));
		//Esto funciona faltaria generalizarlo para el caso de un bk, y mk
		EcuacionLineal ecu1 = new EcuacionLineal(1, b1, m1);
		//System.out.println(ecu1);
		EcuacionLineal ecu2 = new EcuacionLineal(1, b2, m2);
		//System.out.println(ecu2);
		EcuacionLineal ecu3 = new EcuacionLineal(1, 6, 5);
		//Bueno ahora armamos una lista de ecuaciones lineales
		ArrayList<EcuacionLineal> listE = new ArrayList<EcuacionLineal>();
		listE.add(ecu1);
		listE.add(ecu2);
		listE.add(ecu3);
		TeoremaChinoResto chi2 = new TeoremaChinoResto();
		System.out.println("El resultado es " + chi2.teoChinoRest(listE));
		System.out.println(chi2);
	}

}
