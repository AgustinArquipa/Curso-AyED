package Test;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo_tp.Criba_Eratostenes;
import Codigo_tp.Divisibilidad_enteros;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Para numeros naturales
		Divisibilidad_enteros op = new Divisibilidad_enteros();
		int dividendo = 20;
		int divisor = -3;
		System.out.println("El dividendo es: " + dividendo + "\nEl divisor es: " + divisor);
		System.out.println(op);
		//ArrayList<Integer> cr = op.cr(dividendo, divisor);
		//System.out.println(cr);
		//Para enteros
		ArrayList<Integer> cr = op.crent(dividendo, divisor);
		System.out.println(cr);
		//Criba de Erastotenes
		int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero: "));
		Criba_Eratostenes criba = new Criba_Eratostenes(num);
		int[] lista = criba.criba(num);
		//System.out.println(lista.length);
		//criba.depuracion();
		JOptionPane.showMessageDialog(null, criba.mostrar_lista(lista));
		//Tenemos errores, deberiamos buscar la solucion
		//int a, b;
		//a = 2;
		//b = 15;
		//Criba_Eratostenes criba_do = new Criba_Eratostenes(b);
		//criba_do.criba(a, b); // Por mas que el metodo devuelva algo, simplemente lo llamos ya que sino creo una variable que no utilizo
	}

}
