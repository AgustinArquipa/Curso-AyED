package Test;

import Herramientas.Coc_rest_Ent;

public class MainHerramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -35;
		int b = -6;
		//Coc_rest op = new Coc_rest();
		//System.out.println("El cociente es: " + op.cociente(a, b));
		//System.out.println("El resto es: " + op.resto(a, b));
		Coc_rest_Ent op1 = new Coc_rest_Ent();
		System.out.println("El cociente entero es: " + op1.cocientEnt(a, b));
		System.out.println("El resto entero es: " + op1.restEnt(a, b));
	}

}
