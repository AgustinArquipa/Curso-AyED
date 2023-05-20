package Test;

import javax.swing.JOptionPane;

import Herramientas.Primos;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		Primos op = new Primos();
		a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor para A:"));
		JOptionPane.showMessageDialog(null, "Es Primo??: " + op.esPrimo(a));
	}

}
