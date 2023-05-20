package Test;

import Herramientas.Par;
import Operaciones.EuclidesExtendido;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		a = 6; b = -17;
		EuclidesExtendido op = new EuclidesExtendido();
		Par par = op.st(a, b);
		System.out.println(par);
	}

}
