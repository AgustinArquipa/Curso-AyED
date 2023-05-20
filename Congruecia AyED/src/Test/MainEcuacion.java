package Test;

import Ecuacion.Diofantica;

public class MainEcuacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 21;
		int b = 18;
		int mod = 30;
		Diofantica ecua = new Diofantica();
		//System.out.println(ecua.ecuaLineal(a, b, mod));
		int sol = ecua.ecuaLineal(a, b, mod);
		System.out.println(ecua.mostrar_ecua(a, b, mod, sol));
	}

}
