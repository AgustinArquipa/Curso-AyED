package testing;

import Ejemplos.ListProcesos;
import Ejemplos.Procesos;

public class mainListProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListProcesos list = new ListProcesos();
		for(int k=0; k<10; k++) {
			list.insertar(new Procesos());
		}
		//Mostramos la lista
		System.out.println();
		for(int i=0; i<list.tamaño(); i++) {
			System.out.println(list.devolver(i));
		}
	}

}
