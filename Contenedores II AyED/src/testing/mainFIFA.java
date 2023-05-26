package testing;

import Trabajo.*;

public class mainFIFA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Implementamos el ranking fifa con una lista ordenada
		Seleccionado s1 = new Seleccionado("Argentina", 7, 3);
		Seleccionado s2 = new Seleccionado("Brasil", 8, 2);
		Seleccionado s3 = new Seleccionado("Uruguay", 6, 4);
		Seleccionado s4 = new Seleccionado("España", 5, 5);
		Seleccionado s5 = new Seleccionado("Andorra", 7, 3);
		
		RankingFifa list = new RankingFifa();
		list.insertar(s1);
		list.insertar(s2);
		list.insertar(s3);
		list.insertar(s4);
		list.insertar(s5);
		
		//Recorremos la lista haber como nos devuelve
		for(int i=0; i<list.tamaño(); i++) {
			System.out.println("Ranking: " + list.devolver(i));
		}
	}

}
