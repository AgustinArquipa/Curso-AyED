package Tests;

import Tarea.ColaArrExtends;

public class mainCola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tam = 4;
		//Nos acordamos que la cola es circular
		//ColaArrExtends cola = new ColaArrExtends();
		ColaArrExtends col = new ColaArrExtends(tam + 1); //Tamanio 5
		ColaArrExtends col1 = new ColaArrExtends(tam);
		//Scanner sc1, sc2;
		
		//System.out.println("Ingrese una cantidad: ");
		//sc1 = new Scanner(System.in);
		col.meter('A');
		col.meter('B');
		col.meter('C');
		col.meter('D');
		col1.meter('E');
		col1.meter('F');
		col1.meter('g');
		//En teoria si metemos E nos tiene que dar error
		col.meter('E');
		//System.out.println("El cardinal de la cola es: " + cola.cardinalCola(col));
		//System.out.println("El cardinal de la cola es; " + col.cardinalCola());
		//col.invertCola();
		//Vemos como funciona el mostrar
		//col.mostrar();
		//col1.mostrar();
		
		//Probamos el concatenar
		ColaArrExtends cont = new ColaArrExtends(col.getTamanio() + col1.getTamanio() + 1);
		cont.concatenar(col, col1);
	}
}
