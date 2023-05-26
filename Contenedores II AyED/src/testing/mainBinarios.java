package testing;

import Trabajo.Binarios;
import Trabajo.listaBin;

public class mainBinarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listaBin lis1 = new listaBin();
		lis1.insertar('1', 0);
		lis1.insertar('0', 1);
		lis1.insertar('1', 2);
		lis1.insertar('0', 3);
		lis1.insertar('1', lis1.tamaño());
		
		listaBin lis2 = new listaBin();
		lis2.insertar('1', 0);
		lis2.insertar('0', 1);
		lis2.insertar('1', 2);
		
		Binarios op = new Binarios();
		op.suma(lis1, lis2);
		System.out.println(op);
	}

}
