package Test;

import Herramientas.Par;
import Operaciones.EuclidesExtendido;
import Operaciones.MCD;

public class MainOperaciones {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 6;
		int b = -17;
		MCD ope = new MCD();
		int d = ope.mcd(a, b);
		System.out.println(ope.mostrar(a, b, d));
		EuclidesExtendido esete = new EuclidesExtendido();
		Par st = esete.st(a, b);
		System.out.println(st.mostrar_st(a, b, d));
	}
}
